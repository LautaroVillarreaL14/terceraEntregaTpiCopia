package terceraEntregaTpi.M;
//SACAR el toString DEL FINAL SI AFECTA A NADA

public class Persona{
    private final String nombre;       
    private final String apellido;     
    private final long legajo;         
    private final long dni;            
    private final long telefono;       
    private final String correo;       
    private final String tipoPersona; 
    private String marcaVehiculo;
    private String modelovehiculo;
    private String patenteVehiculo;
    private Boolean cuenta;     
   
   
    
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
