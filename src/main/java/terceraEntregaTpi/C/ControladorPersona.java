package terceraEntregaTpi.C;
import terceraEntregaTpi.V.PantallaMostrarUsuarios;
import terceraEntregaTpi.V.PantallaCrearCuenta;
import java.util.List;
import terceraEntregaTpi.M.Persona;
import javax.swing.DefaultListModel;
import terceraEntregaTpi.M.ListadoAModelo;
import terceraEntregaTpi.M.Vehiculo;
import terceraEntregaTpi.M.Buscador;
import terceraEntregaTpi.M.RepositorioPersonas;

public class ControladorPersona extends VerificarDatos implements Buscador{
    private final PantallaMostrarUsuarios vista;
    private final RepositorioPersonas repositorio;

    public ControladorPersona(PantallaMostrarUsuarios vista, RepositorioPersonas repositorio){
        this.vista = vista;
        this.repositorio = repositorio;

        this.vista.getBotonBuscar().addActionListener(e -> {mostrarPersonas();});

        this.vista.getBotonGestionarCuenta().addActionListener(evt->{
            String usuarioSeleccionado = this.vista.obtenerUsuarioSeleccionado();
            if(usuarioSeleccionado!=null){
                vista.dispose();
                Persona pSeleccionada = llamarPersonaSeleccionada(usuarioSeleccionado,buscarListaPersonasSinCuenta());
                PantallaCrearCuenta pantalla = new PantallaCrearCuenta(pSeleccionada.getNombre(),pSeleccionada.getApellido(),pSeleccionada.getLegajo(),pSeleccionada.getDNI(),pSeleccionada.getTelefono());
                pantalla.setVisible(true);

                pantalla.getBotonGuardar().addActionListener(tocar-> {
                    String marca = pantalla.getTxtMarcaVehiculo().getText();
                    String modelo = pantalla.getTxtModeloVehiculo().getText();
                    String patente = pantalla.getTxtPatenteVehiculo().getText();
                    String contraseña = pantalla.getTxtContraseña().getText();

                    if(verificarVehiculo(pantalla,marca,modelo,patente) && verificarContraseña(pantalla,contraseña)){
                        Vehiculo vehiculo = new Vehiculo(marca,modelo,patente);
                        pantalla.dispose();
                        repositorio.cambiarParametroNoTieneCuenta(pSeleccionada,vehiculo,contraseña);
                    }
                });
            }
        });
    }
    
    
    public void mostrarPersonas() {
        try {
            String nombreBuscar = vista.getTxtBusqueda().getText().toLowerCase();

            List<Persona> usuarios = buscarListaPersonasSinCuenta();

            DefaultListModel<String> modeloLista = ListadoAModelo.personasAListaModelo(
                usuarios.stream()
                    .filter(u ->
                        nombreBuscar.isEmpty() ||
                        u.getNombre().toLowerCase().contains(nombreBuscar) ||
                        u.getApellido().toLowerCase().contains(nombreBuscar)
                    )
                    .toList(),
                u -> u.getNombre() + " " + u.getApellido() + " " + u.getDNI()
            );
            vista.getListaUsuarios().setModel(modeloLista);
            
        }catch (Exception e) {vista.mostrarMensaje("No se pudo realizar la busqueda");}
    }

    public List<Persona> buscarListaPersonasSinCuenta(){
        return repositorio.listarPersonasSinCuenta();
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
    
    public List<Persona> buscarPersonasConCuenta(){
        return repositorio.listarPersonasConCuenta();
    }
}
    
    
    
    
    
