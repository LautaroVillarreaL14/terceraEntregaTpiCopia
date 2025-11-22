package terceraEntregaTpi.M;
import javax.swing.DefaultListModel;
import java.util.List;
import java.util.function.Function;


public final class ListadoAModelo {
    private ListadoAModelo() {}

    public static DefaultListModel<String> personasAListaModelo(List<Persona> personas, Function<Persona, String> mapper) {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        if (personas == null) return modelo;
        personas.stream()
                .map(mapper)
                .forEach(modelo::addElement);
        return modelo;
    }
}