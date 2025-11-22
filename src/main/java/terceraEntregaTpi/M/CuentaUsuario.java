package terceraEntregaTpi.M;
import java.util.ArrayList;


public class CuentaUsuario{
    final String nombreUsuario;
    final String apellidoUsuario;
    final long legajo;
    final String contraseña;
    final Double saldo = 0.0;
    final ArrayList<Vehiculo> vehiculos;
    

    public CuentaUsuario(Persona persona, String contraseña,Vehiculo vehiculo) {
        vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo);
        this.nombreUsuario = persona.getNombre();
        this.apellidoUsuario = persona.getApellido();
        this.legajo = persona.getLegajo();
        this.contraseña = contraseña;
    }
    
    public String getCuenta(){
        return this.nombreUsuario+" "+this.apellidoUsuario+" "+this.legajo+" "+this.contraseña+" "+this.saldo.toString()+" "+this.vehiculos+" ";
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }
    
    public String getNombreUsuario(){
        return this.nombreUsuario;
    }

    public String getApellidoUsuario(){
        return this.apellidoUsuario;
    }

    public Long getLegajoUsuario(){
        return this.legajo;
    }

    public String getContraseña(){
        return this.contraseña;
    }
    
    public Double getSaldoUsuario(){
        return this.saldo;
    }
    
    
    
    

    

    

    
}
