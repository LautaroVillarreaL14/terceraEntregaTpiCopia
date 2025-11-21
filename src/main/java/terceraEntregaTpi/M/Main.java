package terceraEntregaTpi.M;
import terceraEntregaTpi.C.ControladorPersona;
import terceraEntregaTpi.V.PantallaPrincipal;
import terceraEntregaTpi.V.PantallaMostrarUsuarios;
import terceraEntregaTpi.C.ControladorCuentas;
//REFACTORIZADA
public class Main {
    public static void main(String[] args) {
        
            PantallaPrincipal vistaPrincipal = new PantallaPrincipal();
            ManipuladorArchivosProlog manipulador = new ManipuladorArchivosProlog();
            RepositorioPersonas repositorio = new ManipuladorArchivosPrologRepositorio(manipulador);
            vistaPrincipal.setVisible(true);
            

            vistaPrincipal.getBotonNuevaCuenta().addActionListener(e -> {
                PantallaMostrarUsuarios vistaCrear = new PantallaMostrarUsuarios();
                ControladorPersona controlador = new ControladorPersona(vistaCrear, repositorio);
                vistaCrear.setVisible(true);
                    
            });
            vistaPrincipal.getBotonGestionarCuentas().addActionListener(e->{
               PantallaMostrarUsuarios vistaCrear = new PantallaMostrarUsuarios();
               
               ControladorCuentas controladorCuentas = new ControladorCuentas(vistaCrear, repositorio);
               vistaCrear.setVisible(true);
            });
            
            
        
    }
}
