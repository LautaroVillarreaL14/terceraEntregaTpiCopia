package terceraEntregaTpi.M;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Objects;
import javax.swing.JOptionPane;
import terceraEntregaTpi.V.PantallaPrincipal;

/*
public class GestorPersonas implements VerificarDatos {
    
    public GestorPersonas() {
        personas = new ArrayList<>();
        
    }
    
    

    private ArrayList<Persona> personas; // lista de personas
    
    public void crearPersona(String n, String a, Long l, Long d, Long t, String c, TipoPersona tp) {
        // Validaciones:
        
        //Validar aca nombre, apellido y legajo
        //
        Stream.of(n,a,l,d,t,c,tp).forEach(this::verificarCamposVacios);
        Stream.of(n, a, c).forEach(this::verificarCadenaValida);
        Stream.of(l, d, t).forEach(this::verificarEnteroValido);

        Persona persona = new Persona(n, a, l, d, t, c, tp);
        personas.add(persona);
        System.out.println("Se agrego la persona a la lista");
        escribirArchivo(persona);
    }
    
    
    

    public void escribirArchivo(Persona persona) {
        try (FileWriter escritor = new FileWriter("Personas.txt", true)) {
            escritor.write(persona.toString()+"\n");
            JOptionPane.showMessageDialog(null, "Persona agregada correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "No se pudo agregar la persona.");
        }
    }

    public void mostrarPersonas() {
        System.out.println("Lista de personas:");
        personas.stream().forEach(System.out::println);
    }

    public void existenCuentasUsuario() {
        boolean noExiste = personas.stream()
            .map(Persona::getCuentaUsuario)
            .allMatch(Objects::isNull);

        if (noExiste) throw new RuntimeException("No existe ninguna cuenta registrada.");
    }

    public void mostrarCuentasUsuario() {
        existenCuentasUsuario();
        System.out.println("Lista de cuentas:");
        personas.stream()
            .map(Persona::getCuentaUsuario)
            .filter(Objects::nonNull)
            .forEach(System.out::println);
    }

    private Stream<Vehiculo> streamVehiculosRegistrados() {
        return personas.stream()
            .map(Persona::getCuentaUsuario)
            .filter(Objects::nonNull)
            .flatMap(obtenerStreamVehiculos)
            .filter(Objects::nonNull);
    }

    Function<CuentaUsuario, Stream<Vehiculo>> obtenerStreamVehiculos = 
        c -> c.getVehiculos().stream();

    public void existenVehiculosRegistrados() {
        boolean noExiste = streamVehiculosRegistrados().findAny().isEmpty();
        if (noExiste) throw new RuntimeException("No existen vehículos registrados.");
    }

    public void mostrarVehiculosRegistrados() {
        existenCuentasUsuario();
        existenVehiculosRegistrados();
        System.out.println("Lista de vehículos:");
        streamVehiculosRegistrados().forEach(System.out::println);
    }
}
*/
