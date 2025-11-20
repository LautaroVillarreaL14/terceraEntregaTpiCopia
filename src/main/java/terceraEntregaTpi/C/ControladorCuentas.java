package terceraEntregaTpi.C;
import terceraEntregaTpi.V.PantallaMostrarUsuarios;
import org.jpl7.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import terceraEntregaTpi.M.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import terceraEntregaTpi.M.ManipuladorArchivosProlog;
import terceraEntregaTpi.M.Buscador;
import terceraEntregaTpi.V.PantallaMostrarCuenta;
import terceraEntregaTpi.V.PantallaCargarSaldo;


public class ControladorCuentas implements Buscador{
    private final PantallaMostrarUsuarios vista;
    
    
    public ControladorCuentas(PantallaMostrarUsuarios vista){
        this.vista = vista;

        ManipuladorArchivosProlog manipulador = new ManipuladorArchivosProlog();

        this.vista.getBotonBuscar().addActionListener(e->{mostrarPersonas(manipulador);}); 
        this.vista.getBotonGestionarCuenta().addActionListener(e->{
            String usuarioSeleccionado = this.vista.obtenerUsuarioSeleccionado();
            if(usuarioSeleccionado!=null){
                vista.dispose();
                Persona pSeleccionada = llamarPersonaSeleccionada(usuarioSeleccionado,buscarPersonasConCuenta(manipulador));
                String contraseña = manipulador.obtenerContraseñaPorLegajo(pSeleccionada.getLegajo());
                String saldo = manipulador.obtenerSaldoPorLegajo(pSeleccionada.getLegajo());
                PantallaMostrarCuenta mostrarCuenta = new PantallaMostrarCuenta(pSeleccionada, contraseña, saldo);
                mostrarCuenta.setVisible(true);
                mostrarCuenta.getBotonRecargarSaldo().addActionListener(evt->{
                    int saldoAnterior = java.lang.Integer.parseInt(manipulador.obtenerSaldoPorLegajo(pSeleccionada.getLegajo()));
                    PantallaCargarSaldo cargarSaldo = new PantallaCargarSaldo();
                    cargarSaldo.setVisible(true);
                    cargarSaldo.getBotonConfirmarRecarga().addActionListener(evento->{
                        String saldoString = cargarSaldo.getTxtSaldoCargar().getText();
                        int  saldoEntero = java.lang.Integer.parseInt(saldoString);
                        if(!saldoString.isEmpty() && saldoEntero>=0){
                            String nuevoSaldo = String.valueOf(saldoEntero+saldoAnterior);
                            manipulador.CambiarSaldoCuenta(pSeleccionada, contraseña, nuevoSaldo);
                            JOptionPane.showMessageDialog(null, "Saldo cargado con exito \n Nuevo saldo: $"+nuevoSaldo);
                            cargarSaldo.dispose();
                        }
                    });
                });
                
            }
            
        });
    }
    
    
    public void mostrarPersonas(ManipuladorArchivosProlog manipulador) {
        try {
            String nombreBuscar = vista.getTxtBusqueda().getText().toLowerCase();

            List<Persona> usuarios = buscarPersonasConCuenta(manipulador);

            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            usuarios.stream()
                .filter(u -> nombreBuscar.isEmpty() || u.getNombre().toLowerCase().contains(nombreBuscar) || u.getApellido().toLowerCase().contains(nombreBuscar))
                .map(u -> u.getNombre() + " " + u.getApellido() + " " + u.getDNI())
                .forEach(modeloLista::addElement);

            if (modeloLista.size() > 0) {
                vista.getListaUsuarios().setModel(modeloLista);
            } else {
                JOptionPane.showMessageDialog(null, "No hay cuentas creadas");
            }

        } catch (Exception e) {JOptionPane.showMessageDialog(null, "No se pudo realizar la búsqueda");}
    }

    public List<Persona> buscarPersonasSinCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> sinCuenta = new ArrayList<>();
        return sinCuenta;
    }
    public List<Persona> buscarPersonasConCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> conCuenta = new ArrayList<>();
        if (!manipulador.abrirArchivoBaseDeConocimientoPersonas()) {
            return conCuenta;
        }
        Query buscar = new Query("usuario(Nombre, Apellido, Legajo, Dni, Telefono, Correo, Tipo, Marca, Modelo, Patente, Saldo, Contraseña, true)");
        while(buscar.hasMoreSolutions()){
            Map<String, Term> solucion = buscar.nextSolution();
            String nombre = solucion.get("Nombre").toString().replace("\"", "");
            String apellido = solucion.get("Apellido").toString().replace("\"", "");
            Long legajo = Long.parseLong(solucion.get("Legajo").toString().replace("\"", ""));
            Long dni = Long.parseLong(solucion.get("Dni").toString().replace("\"", ""));
            Long telefono = Long.parseLong(solucion.get("Telefono").toString().replace("\"", ""));
            String correo = solucion.get("Correo").toString().replace("\"", "");
            String tipoPersona = solucion.get("Tipo").toString().replace("\"", "");
            String marca = solucion.get("Marca").toString().replace("\"", "");
            String modelo = solucion.get("Modelo").toString().replace("\"", "");
            String patente = solucion.get("Patente").toString().replace("\"", "");
            String contraseña = solucion.get("Contraseña").toString().replace("\"", "");
            Boolean cuenta = true;
            
            Persona personaConCuenta = new Persona(nombre, apellido, legajo, dni, telefono, correo, tipoPersona, marca, modelo, patente, cuenta);
            conCuenta.add(personaConCuenta);
            
        }
        
        return conCuenta;
    }
    public Persona llamarPersonaSeleccionada(String usuario, List<Persona> listaPersonas){
        String[] datos = usuario.split(" ");
        Long dni = Long.parseLong(datos[2]);
        for(Persona p: listaPersonas){
            if(p.getDNI().equals(dni)){
                System.out.println(p);
                return p;
            }
        }
        return null;
    }
    
    
    
     
}
    
    
    
    
