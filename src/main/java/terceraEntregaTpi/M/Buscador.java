package terceraEntregaTpi.M;
import java.util.List;

public interface Buscador {
    List<Persona> buscarListaPersonasSinCuenta();
    List<Persona> buscarPersonasConCuenta();
    Persona llamarPersonaSeleccionada(String usuario, List<Persona> listaPersonas);
}