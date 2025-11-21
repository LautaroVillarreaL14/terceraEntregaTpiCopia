package terceraEntregaTpi.M;

import java.util.List;


public interface Buscador {
    // Mostrar personas se encarga la vista/controlador; el buscador debe exponer solo
    // métodos de búsqueda que devuelvan datos para desacoplar lógica y presentación.
    List<Persona> buscarListaPersonasSinCuenta();
    List<Persona> buscarPersonasConCuenta();
    Persona llamarPersonaSeleccionada(String usuario, List<Persona> listaPersonas);
}
