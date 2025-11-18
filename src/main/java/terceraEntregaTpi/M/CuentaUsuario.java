package terceraEntregaTpi.M;
import terceraEntregaTpi.M.VerificarDatos;
import java.util.ArrayList;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import terceraEntregaTpi.M.Vehiculo;

public class CuentaUsuario{
    private String nombreUsuario;   // Nombre de usuario de la cuenta
    private String apellidoUsuario;
    private long legajo;            // Legajo de la persona
    private String contraseña;     // Contraseña de la cuenta
    private Double saldo = 0.0;     // Saldo disponible en la cuenta
    private ArrayList<Vehiculo> vehiculos; // Lista de vehículos del usuario
    private ArrayList<Recarga> recargas;   // Lista de recargas realizadas

    public CuentaUsuario(Persona persona, String contraseña,Vehiculo vehiculo) {
        vehiculos = new ArrayList<>(); // Inicializamos lista de vehículos vacía
        recargas = new ArrayList<>();  // Inicializamos lista de recargas vacía
        vehiculos.add(vehiculo);
        this.nombreUsuario = persona.getNombre();
        this.apellidoUsuario = persona.getApellido();       
        this.legajo = persona.getLegajo();               
        this.contraseña = contraseña;          
    }
    
    public String getCuenta(){
        return this.nombreUsuario+" "+this.apellidoUsuario+" "+this.legajo+" "+this.contraseña+" "+this.saldo.toString()+" "+this.vehiculos+" "+this.recargas;
    }
    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }
    
    public String conocerNombreUsuario(){
        return this.nombreUsuario;
    }
    public String conocerApellidoUsuario(){
        return this.apellidoUsuario;
    }
    public Long conocerLegajoUsuario(){
        return this.legajo;
    }
    public String conocerContraseña(){
        return this.contraseña;
    }
    public Double conocerSaldoUsuario(){
        return this.saldo;
    }
    
    
    
    

    

    

    
}
