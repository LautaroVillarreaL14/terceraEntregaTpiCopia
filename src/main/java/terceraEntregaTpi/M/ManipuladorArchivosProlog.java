package terceraEntregaTpi.M;
import org.jpl7.Term;
import org.jpl7.Query;





public class ManipuladorArchivosProlog {
    public Boolean abrirArchivoBaseDeConocimientoPersonas(){
        try {
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";
        

        
        Query cargarArchivo = new Query("consult('" + rutaArchivo + "')");
        return cargarArchivo.hasSolution();
        } catch (Exception e) {return false;}
    }
    
    public Boolean abrirArchivoBaseConocimientoCuentasUsuarios(){
        try{
            String rutaArchivo = ManipuladorArchivosProlog.class.getClassLoader().getResource("prolog/BaseConocimientoCuentasUsuarios.pl").getPath();
            Query consulta = new Query("consult('" + rutaArchivo +"')");
            return consulta.hasSolution();
        }catch (Exception e){return false;}
    }
    
    
    
    public void cambiarParametroNoTieneCuenta(Persona pSeleccionada,Vehiculo vehiculo,String contra){
        String nombre = pSeleccionada.getNombre();
        String apellido = pSeleccionada.getApellido();
        Long legajo = pSeleccionada.getLegajo();
        Long dni = pSeleccionada.getDNI();
        String correo = pSeleccionada.getCorreo();
        String tipo = pSeleccionada.getTipoPersona();
        Long telefono = pSeleccionada.getTelefono();
        String marca = vehiculo.getMarca();
        String modelo = vehiculo.getModelo();
        String patente = vehiculo.getPatente();
        String contraseña = contra;
        int saldo = 0;
        
        if(!abrirArchivoBaseDeConocimientoPersonas()){return;}
        
        String hechoViejo = String.format("usuario(_,_,%d,_,_,_,_,_,_,_,_,_,false)",legajo);
        
        Query retract = new Query("retract(" + hechoViejo + ")");
        if(!retract.hasSolution()) return;
        
        String hechoNuevo = String.format("assert(usuario('%s','%s',%d,%d,%d,'%s','%s','%s','%s','%s','%s','%s',true))",
            nombre,apellido,legajo,dni,telefono,correo,tipo,marca,modelo,patente,saldo,contraseña);

        Query assertQ = new Query(hechoNuevo);
        assertQ.hasSolution();
        
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";
        Query salida = new Query("tell('" + rutaArchivo + "')");
        salida.hasSolution();

        Query listing = new Query("listing(usuario/13).");
        listing.hasSolution();

        Query told = new Query("told");
        told.hasSolution();
    }
    
    
    public String obtenerContraseñaPorLegajo(Long legajoBuscado) {

        try {
            if (!abrirArchivoBaseDeConocimientoPersonas()) return null;

            String consulta = String.format("usuario(_,_,%d,_,_,_,_,_,_,_,_,Contraseña,_)",legajoBuscado);

            Query q = new Query(consulta);

            if (!q.hasSolution()) return null;

            Term solucion = q.oneSolution().get("Contraseña");

            return solucion.name();

        } catch (Exception e) {return null;}
    }
    
    public String obtenerSaldoPorLegajo(Long legajoBuscado){
         try {
            if (!abrirArchivoBaseDeConocimientoPersonas()) return null;

            String consulta = String.format("usuario(_,_,%d,_,_,_,_,_,_,_,Saldo,_,true)",legajoBuscado);
            
            Query q = new Query(consulta);

            if (!q.hasSolution()) return null;
            
            Term solucion = q.oneSolution().get("Saldo");

            return solucion.name(); 

        } catch (Exception e) {return null;}
    }
    
    public void cambiarSaldoCuenta(Persona pSeleccionada, String contra,String nuevoSaldo){
        String nombre = pSeleccionada.getNombre();
        String apellido = pSeleccionada.getApellido();
        Long legajo = pSeleccionada.getLegajo();
        Long dni = pSeleccionada.getDNI();
        String correo = pSeleccionada.getCorreo();
        String tipo = pSeleccionada.getTipoPersona();
        Long telefono = pSeleccionada.getTelefono();
        String marca = pSeleccionada.getMarcaVehiculo();
        String modelo = pSeleccionada.getModeloVehiculo();
        String patente = pSeleccionada.getPatenteVehiculo();
        String contraseña = contra;
        if (!abrirArchivoBaseDeConocimientoPersonas()) return;
        
        String hechoViejo = String.format("usuario(_,_,%d,_,_,_,_,_,_,_,_,_,true)",legajo);
        
        
        Query retract = new Query("retract(" + hechoViejo + ")");
        if(!retract.hasSolution()) return;
        
        
        String hechoNuevo = String.format("assert(usuario('%s','%s',%d,%d,%d,'%s','%s','%s','%s','%s','%s','%s',true))",
        nombre,apellido,legajo,dni,telefono,correo,tipo,marca,modelo,patente,nuevoSaldo,contraseña);
        
        Query assertQ = new Query(hechoNuevo);
        assertQ.hasSolution();
        
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";

        Query salida = new Query("tell('" + rutaArchivo + "')");
        salida.hasSolution();

        Query listing = new Query("listing(usuario/13).");
        listing.hasSolution();

        Query told = new Query("told");
        told.hasSolution();
    }

}
