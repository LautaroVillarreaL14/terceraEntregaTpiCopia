package terceraEntregaTpi.M;

import org.jpl7.Query;
import org.jpl7.Term;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManipuladorArchivosPrologRepositorio implements RepositorioPersonas {
    private final ManipuladorArchivosProlog delegado;

    public ManipuladorArchivosPrologRepositorio(ManipuladorArchivosProlog delegado) {
        this.delegado = delegado;
    }

    @Override
    public List<Persona> listarPersonasSinCuenta() {
        List<Persona> sinCuenta = new ArrayList<>();
        if (!delegado.abrirArchivoBaseDeConocimientoPersonas()) return sinCuenta;

        Query buscar = new Query("usuario(Nombre, Apellido, Legajo, Dni, Telefono, Correo, Tipo, Marca, Modelo, Patente, Saldo, Contraseña, Cuenta)");
        while (buscar.hasMoreSolutions()) {
            Map<String, Term> solucion = buscar.nextSolution();
            String nombre = solucion.get("Nombre").toString().replace("\"", "");
            String apellido = solucion.get("Apellido").toString().replace("\"", "");
            Long legajo = Long.parseLong(solucion.get("Legajo").toString().replace("\"", ""));
            Long dni = Long.parseLong(solucion.get("Dni").toString().replace("\"", ""));
            Long telefono = Long.parseLong(solucion.get("Telefono").toString().replace("\"", ""));
            String correo = solucion.get("Correo").toString().replace("\"", "");
            String marca = solucion.get("Marca").toString().replace("\"", "");
            String modelo = solucion.get("Modelo").toString().replace("\"", "");
            String patente = solucion.get("Patente").toString().replace("\"", "");
            Boolean cuenta = false;
            String tipoPersona = solucion.get("Tipo").toString().replace("\"", "");
            Persona personaSinCuenta = new Persona(nombre, apellido, legajo, dni, telefono, correo, tipoPersona, marca, modelo, patente, cuenta);
            sinCuenta.add(personaSinCuenta);
        }

        return sinCuenta;
    }

    @Override
    public List<Persona> listarPersonasConCuenta() {
        List<Persona> conCuenta = new ArrayList<>();
        if (!delegado.abrirArchivoBaseDeConocimientoPersonas()) return conCuenta;

        Query buscar = new Query("usuario(Nombre, Apellido, Legajo, Dni, Telefono, Correo, Tipo, Marca, Modelo, Patente, Saldo, Contraseña, true)");
        while (buscar.hasMoreSolutions()) {
            Map<String, Term> solucion = buscar.nextSolution();
            String nombre = solucion.get("Nombre").toString().replace("\"", "");
            String apellido = solucion.get("Apellido").toString().replace("\"", "");
            Long legajo = Long.parseLong(solucion.get("Legajo").toString().replace("\"", ""));
            Long dni = Long.parseLong(solucion.get("Dni").toString().replace("\"", ""));
            Long telefono = Long.parseLong(solucion.get("Telefono").toString().replace("\"", ""));
            String correo = solucion.get("Correo").toString().replace("\"", "");
            String tipoPersona = solucion.get("Tipo").toString().replace("\"", "");
            String marca = solucion.get("Marca").toString().replace("\"", "");
            String modelo = solucion.get("Modelo").toString().replace("\"", "");
            String patente = solucion.get("Patente").toString().replace("\"", "");
            Boolean cuenta = true;
            Persona personaConCuenta = new Persona(nombre, apellido, legajo, dni, telefono, correo, tipoPersona, marca, modelo, patente, cuenta);
            conCuenta.add(personaConCuenta);
        }

        return conCuenta;
    }

    @Override
    public String obtenerContraseñaPorLegajo(Long legajo) {
        return delegado.obtenerContraseñaPorLegajo(legajo);
    }

    @Override
    public String obtenerSaldoPorLegajo(Long legajo) {
        return delegado.obtenerSaldoPorLegajo(legajo);
    }

    @Override
    public void cambiarSaldoCuenta(Persona pSeleccionada, String contra, String nuevoSaldo) {
        delegado.cambiarSaldoCuenta(pSeleccionada, contra, nuevoSaldo);
    }

    @Override
    public void cambiarParametroNoTieneCuenta(Persona pSeleccionada, Vehiculo vehiculo, String contra) {
        delegado.cambiarParametroNoTieneCuenta(pSeleccionada, vehiculo, contra);
    }
}
