package terceraEntregaTpi.M;
import java.util.List;

public abstract interface RepositorioPersonas {
    List<Persona> listarPersonasSinCuenta();
    List<Persona> listarPersonasConCuenta();
    String obtenerContraseñaPorLegajo(Long legajo);
    String obtenerSaldoPorLegajo(Long legajo);
    void cambiarSaldoCuenta(Persona pSeleccionada, String contra, String nuevoSaldo);
    void cambiarParametroNoTieneCuenta(Persona pSeleccionada, Vehiculo vehiculo, String contra);
}
