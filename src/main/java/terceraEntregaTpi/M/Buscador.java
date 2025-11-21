package terceraEntregaTpi.M;
import java.util.List;


public interface Buscador {
    void mostrarPersonas(ManipuladorArchivosProlog manipulador);
    List<Persona> buscarListaPersonasSinCuenta(ManipuladorArchivosProlog manipulador);
    List<Persona> buscarPersonasConCuenta(ManipuladorArchivosProlog manipulador);
    Persona llamarPersonaSeleccionada(String usuario, List<Persona> listaPersonas);
    
}
