package terceraEntregaTpi.M;
import javax.swing.JOptionPane;
import terceraEntregaTpi.V.PantallaCrearCuenta;
public interface VerificarDatos {
    Boolean verificarVehiculo(PantallaCrearCuenta pantalla,String marca, String modelo, String patente);
    Boolean verificarContraseña(PantallaCrearCuenta pantalla, String contraseña);
}
