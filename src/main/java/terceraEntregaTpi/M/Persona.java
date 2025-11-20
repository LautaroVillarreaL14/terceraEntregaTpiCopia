package terceraEntregaTpi.M;
import java.util.stream.Stream;
import java.util.Scanner;

public class Persona{
    private String nombre;       // Nombre de la persona
    private String apellido;     // Apellido de la persona
    private long legajo;         // Legajo de la persona
    private long dni;            // DNI
    private long telefono;       // Número de teléfono
    private String correo;       // Correo electrónico
    private String tipoPersona; // Tipo de persona (Estudiante, Docente, etc.)
    private String marcaVehiculo;
    private String modelovehiculo;
    private String patenteVehiculo;
    
    private Boolean cuenta;     // La cuenta de usuario asociada, si tiene
   
   
    // Constructor: inicializamos todos los datos de la persona
    public Persona (String n, String a, long l, long d ,long t, String c,String tp,String m,String mod,String p, Boolean cuenta) {
        this.nombre = n;
        this.apellido = a;
        this.legajo = l;
        this.dni = d;
        this.telefono = t;
        this.correo = c;
        this.tipoPersona = tp;
        this.marcaVehiculo = m;
        this.modelovehiculo = mod;
        this.patenteVehiculo = p;
        this.cuenta = cuenta;
        
    }


    
    public String toString() {
        return this.nombre + " " + this.apellido + " - " + this.legajo;
    }

    // Obtenemos el legajo de la persona
    public long getLegajo() {
        return this.legajo;
    }
    public String getTipoPersona(){
        return this.tipoPersona;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    public String getApellido(){
        return this.apellido;
    }
    public String getCorreo(){
        return this.correo;
    }
    public Long getDNI(){
        return this.dni;
    }
    public Long getTelefono(){
        return this.telefono;
    }
    
    public void setMarca(String marca){
        marcaVehiculo = marca;
    }
    public void setModelo(String modelo){
        modelovehiculo = modelo;
    }
    public void setPatente(String patente){
        patenteVehiculo = patente;
    }
    public String getMarcaVehiculo(){
        return this.marcaVehiculo;
    }
    public String getModeloVehiculo(){
        return this.modelovehiculo;
    }
    public String getPatenteVehiculo(){
        return this.patenteVehiculo;
    }
    
    
}
