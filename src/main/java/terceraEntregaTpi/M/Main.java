package terceraEntregaTpi.M;
import terceraEntregaTpi.V.PantallaPrincipal;
import terceraEntregaTpi.C.ControladorPersona;
import terceraEntregaTpi.V.PantallaPrincipal;
import terceraEntregaTpi.V.Usuarios;
import terceraEntregaTpi.C.ControladorCuentas;

public class Main {
    public static void main(String[] args) {
        
            PantallaPrincipal vistaPrincipal = new PantallaPrincipal();
            vistaPrincipal.setVisible(true);
            

            vistaPrincipal.getBotonNuevaCuenta().addActionListener(e -> {
                Usuarios vistaCrear = new Usuarios();
                ControladorPersona controlador = new ControladorPersona(vistaCrear);
                vistaCrear.setVisible(true);
                vistaPrincipal.dispose();    
            });
            vistaPrincipal.getBotonGestionarCuentas().addActionListener(e->{
               Usuarios vistaCrear = new Usuarios();
               ControladorCuentas controladorCuentas = new ControladorCuentas(vistaCrear);
               vistaCrear.setVisible(true);
            });
            
            
        
    }
}
