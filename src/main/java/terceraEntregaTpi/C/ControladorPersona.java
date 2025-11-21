package terceraEntregaTpi.C;
import terceraEntregaTpi.V.PantallaMostrarUsuarios;
import org.jpl7.*;
import java.util.ArrayList;
import terceraEntregaTpi.V.PantallaCrearCuenta;
import java.util.List;
import java.util.Map;
import terceraEntregaTpi.M.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import terceraEntregaTpi.M.Vehiculo;
import terceraEntregaTpi.M.CuentaUsuario;
import terceraEntregaTpi.M.Buscador;
import terceraEntregaTpi.M.ManipuladorArchivosProlog;
import java.util.stream.Collector;
import terceraEntregaTpi.V.PantallaMostrarCuenta;



public class ControladorPersona implements Buscador, VerificarDatos{
    private final PantallaMostrarUsuarios vista;
    
    
    public ControladorPersona(PantallaMostrarUsuarios vista){
        ManipuladorArchivosProlog manipulador = new ManipuladorArchivosProlog();
        this.vista = vista;
        this.vista.getBotonBuscar().addActionListener(e -> {mostrarPersonas(manipulador);});
        this.vista.getBotonGestionarCuenta().addActionListener(evt->{
            String usuarioSeleccionado = this.vista.obtenerUsuarioSeleccionado();
            if(usuarioSeleccionado!=null){
                vista.dispose();
                Persona pSeleccionada = llamarPersonaSeleccionada(usuarioSeleccionado,buscarListaPersonasSinCuenta(manipulador));
                PantallaCrearCuenta pantalla = new PantallaCrearCuenta(pSeleccionada.getNombre(),pSeleccionada.getApellido(),pSeleccionada.getLegajo(),pSeleccionada.getDNI(),pSeleccionada.getTelefono());
                pantalla.setVisible(true);
                pantalla.getBotonGuardar().addActionListener(tocar-> {
                    String marca = pantalla.getTxtMarcaVehiculo().getText();
                    String modelo = pantalla.getTxtModeloVehiculo().getText();
                    String patente = pantalla.getTxtPatenteVehiculo().getText();
                    String contraseña = pantalla.getTxtContraseña().getText();

                    
                    if(verificarVehiculo(pantalla,marca,modelo,patente) && verificarContraseña(pantalla,contraseña)){
                        Vehiculo vehiculo = new Vehiculo(marca,modelo,patente);
                        CuentaUsuario nuevaCuenta = new CuentaUsuario(pSeleccionada,contraseña,vehiculo);//REVISAR ESTO
                        pantalla.dispose();
                        manipulador.cambiarParametroNoTieneCuenta(pSeleccionada,vehiculo,contraseña);
                    }
                    
                    
                    
                });
            }   
        });
    }
    
    
    public void mostrarPersonas(ManipuladorArchivosProlog manipulador) {
        try {
            String nombreBuscar = vista.getTxtBusqueda().getText().toLowerCase();

            List<Persona> usuarios = buscarListaPersonasSinCuenta(manipulador);

            DefaultListModel<String> modeloLista = usuarios.stream()

                
                .filter(u ->
                    nombreBuscar.isEmpty() ||
                    u.getNombre().toLowerCase().contains(nombreBuscar) ||
                    u.getApellido().toLowerCase().contains(nombreBuscar)
                )

                
                .map(u -> u.getNombre() + " " + u.getApellido() + " " + u.getDNI())

                
                .collect(Collector.of(
                    DefaultListModel<String>::new,
                    DefaultListModel::addElement,
                    (m1, m2) -> { 
                        for (int i = 0; i < m2.size(); i++) {m1.addElement(m2.get(i));}
                        return m1; 
                    }
                ));
            vista.getListaUsuarios().setModel(modeloLista);
            
        }catch (Exception e) {vista.mostrarMensaje("No se pudo realizar la busqueda");}
    }

    
    public Boolean verificarVehiculo(PantallaCrearCuenta pantalla,String marca, String modelo, String patente){
        if(marca.trim().isEmpty() || modelo.trim().isEmpty() || patente.trim().isEmpty()){
            pantalla.mostrarMensaje("Debe completar todos los campos");
            return false;
        }
        return true;
    }
    
    public Boolean verificarContraseña(PantallaCrearCuenta pantalla, String contraseña){
        if(contraseña.trim().isEmpty()){
            pantalla.mostrarMensaje("Debe completar todos los campos");
        }
        return true;
    }
    
    
    
    
    
       
       
    
    public List<Persona> buscarListaPersonasSinCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> sinCuenta = new ArrayList<>();
        
        if (!manipulador.abrirArchivoBaseDeConocimientoPersonas()) {
            return sinCuenta;
        }
        
        
        Query buscar = new Query("usuario(Nombre, Apellido, Legajo, Dni, Telefono, Correo, Tipo, Marca, Modelo, Patente, Saldo, Contraseña, Cuenta)");

        while(buscar.hasMoreSolutions()){
            Map<String, Term> solucion = buscar.nextSolution();
            String nombre = solucion.get("Nombre").toString().replace("\"", "");
            String apellido = solucion.get("Apellido").toString().replace("\"", "");
            Long legajo = Long.parseLong(solucion.get("Legajo").toString().replace("\"", ""));
            Long dni = Long.parseLong(solucion.get("Dni").toString().replace("\"", ""));
            Long telefono = Long.parseLong(solucion.get("Telefono").toString().replace("\"", ""));
            String correo = solucion.get("Correo").toString().replace("\"", "");
            String marca = solucion.get("Marca").toString().replace("\"", "");
            String modelo = solucion.get("Modelo").toString().replace("\"", "");
            String patente = solucion.get("Patente").toString().replace("\"", "");
            Boolean cuenta = false;
            String tipoPersona = solucion.get("Tipo").toString().replace("\"", "");
            Persona personaSinCuenta = new Persona(nombre, apellido, legajo, dni, telefono, correo, tipoPersona, marca, modelo, patente, cuenta);
            sinCuenta.add(personaSinCuenta);
        }
        return sinCuenta;
    }
    
    public Persona llamarPersonaSeleccionada(String datosPersona, List<Persona> listaPersonas){
        String[] datos = datosPersona.split(" ");
        Long dni = Long.parseLong(datos[2]);
        for(Persona p: listaPersonas){
            if(p.getDNI().equals(dni)){
                return p;
            }
        }
        return null;
    }
    
    public List<Persona> buscarPersonasConCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> conCuenta = new ArrayList<>();
        return conCuenta;
    }
}
    
    
    
    
    
