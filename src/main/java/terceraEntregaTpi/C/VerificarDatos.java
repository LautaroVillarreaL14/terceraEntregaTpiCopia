package terceraEntregaTpi.C;
import java.util.stream.Stream;
import terceraEntregaTpi.V.PantallaCrearCuenta;

public class VerificarDatos {
    public Boolean verificarVehiculo(PantallaCrearCuenta pantalla,String marca, String modelo, String patente){
        boolean hayInvalida = Stream.of(marca, modelo, patente).anyMatch(p -> !verificarCadenaValida(p));
        if (hayInvalida) {
            pantalla.mostrarMensaje("Debe completar de forma valida todos los campos");
            return false;
        }
        return true;
    }

    public Boolean verificarContraseña(PantallaCrearCuenta pantalla, String contraseña){
        if(contraseña.trim().isEmpty()){
            pantalla.mostrarMensaje("Debe completar de forma valida todos los campos");
        }
        return true;
    }
    
    public Boolean verificarCadenaValida(String c) {
        if (c.trim().isEmpty() || c.contains(" ")) {
            return false;
        }
        return true;
    }

}
