package terceraEntregaTpi.C;
import terceraEntregaTpi.V.PantallaMostrarUsuarios;
import java.util.List;
import terceraEntregaTpi.M.Persona;
import javax.swing.DefaultListModel;
import terceraEntregaTpi.M.ListadoAModelo;
import terceraEntregaTpi.M.RepositorioPersonas;
import terceraEntregaTpi.M.Buscador;
import terceraEntregaTpi.V.PantallaMostrarCuenta;
import terceraEntregaTpi.V.PantallaCargarSaldo;

public class ControladorCuentas implements Buscador{
    private final PantallaMostrarUsuarios vista;
    private final RepositorioPersonas repositorio;

    public ControladorCuentas(PantallaMostrarUsuarios vista, RepositorioPersonas repositorio){
        this.vista = vista;
        this.repositorio = repositorio;

        this.vista.getBotonBuscar().addActionListener(e->{mostrarPersonas();}); 
        this.vista.getBotonGestionarCuenta().addActionListener(e->{
            String usuarioSeleccionado = this.vista.obtenerUsuarioSeleccionado();
            if(usuarioSeleccionado!=null){
                vista.dispose();
                Persona pSeleccionada = llamarPersonaSeleccionada(usuarioSeleccionado,buscarPersonasConCuenta());
                String contraseña = repositorio.obtenerContraseñaPorLegajo(pSeleccionada.getLegajo());
                String saldo = repositorio.obtenerSaldoPorLegajo(pSeleccionada.getLegajo());
                PantallaMostrarCuenta mostrarCuenta = new PantallaMostrarCuenta(pSeleccionada, contraseña, saldo);
                mostrarCuenta.setVisible(true);

                mostrarCuenta.getBotonRecargarSaldo().addActionListener(evt->{
                    int saldoAnterior = java.lang.Integer.parseInt(repositorio.obtenerSaldoPorLegajo(pSeleccionada.getLegajo()));
                    PantallaCargarSaldo cargarSaldo = new PantallaCargarSaldo();
                    cargarSaldo.setVisible(true);

                    cargarSaldo.getBotonConfirmarRecarga().addActionListener(evento->{
                        String saldoString = cargarSaldo.getTxtSaldoCargar().getText();
                        int  saldoEntero = java.lang.Integer.parseInt(saldoString);
                        if(!saldoString.isEmpty() && saldoEntero>=0){
                            String nuevoSaldo = String.valueOf(saldoEntero+saldoAnterior);
                            repositorio.cambiarSaldoCuenta(pSeleccionada, contraseña, nuevoSaldo);
                            String mensaje = "Saldo cargado con exito: +$"+saldoEntero+"\n"+"Nuevo saldo total: $"+nuevoSaldo;
                            cargarSaldo.mostrarMensaje(mensaje);
                            cargarSaldo.dispose();
                        }
                    });
                });
                
            }
            
        });
    }
    
    
    public void mostrarPersonas() {
        try {
            String nombreBuscar = vista.getTxtBusqueda().getText().toLowerCase();
            List<Persona> usuarios = buscarPersonasConCuenta();

            DefaultListModel<String> modeloLista = ListadoAModelo.personasAListaModelo(usuarios.stream()
                    .filter(u -> nombreBuscar.isEmpty() || u.getNombre().toLowerCase().contains(nombreBuscar) || u.getApellido().toLowerCase().contains(nombreBuscar))
                    .toList(),
                    u -> u.getNombre() + " " + u.getApellido() + " " + u.getDNI()
            );

            if (modeloLista.size() > 0) {
                vista.getListaUsuarios().setModel(modeloLista);
            } else {
                vista.mostrarMensaje("No hay cuentas creadas");
            }

        } catch (Exception e) {vista.mostrarMensaje("No se pudo realizar la búsqueda");}
    }

    public List<Persona> buscarListaPersonasSinCuenta(){
        return repositorio.listarPersonasSinCuenta();
    }

    public List<Persona> buscarPersonasConCuenta(){
        return repositorio.listarPersonasConCuenta();
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
    
    
    
    
