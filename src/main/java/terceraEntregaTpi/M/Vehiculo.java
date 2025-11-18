package terceraEntregaTpi.M;
public class Vehiculo {
    private String marca;
    private String modelo;
    private String patente;
    

    public Vehiculo(String marca,String modelo,String patente) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getPatente() {
        return this.patente;
    }
    public String getMarca(){
        return this.marca;
    }
    public String getModelo(){
        return this.modelo;
    }

    public String toString() {
        return this.marca+" "+this.modelo+" "+this.patente  ;
    }
    
    public String vehiculoConFormato() {
        return this.marca+"_"+this.modelo+"_"+this.patente  ;
    }

}
