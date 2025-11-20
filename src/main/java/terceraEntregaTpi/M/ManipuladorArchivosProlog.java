/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceraEntregaTpi.M;

import javax.swing.JOptionPane;
import org.jpl7.Term;
import org.jpl7.Query;
import java.io.File;



/**
 *
 * @author lautaro
 */
public class ManipuladorArchivosProlog {
    public Boolean abrirArchivoBaseDeConocimientoPersonas(){
        try {
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";
        System.out.println("Ruta que intento abrir: " + new File(rutaArchivo).getAbsolutePath());
        System.out.println(new File(rutaArchivo).exists());

        
        Query cargarArchivo = new Query("consult('" + rutaArchivo + "')");
        return cargarArchivo.hasSolution();
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
        return false;
        }
    }
    
    public Boolean abrirArchivoBaseConocimientoCuentasUsuarios(){
        try{
            String rutaArchivo = ManipuladorArchivosProlog.class.getClassLoader().getResource("prolog/BaseConocimientoCuentasUsuarios.pl").getPath();
            System.out.println("Ruta que intento abrir: " + new File(rutaArchivo).getAbsolutePath());
            System.out.println(new File(rutaArchivo).exists());
            Query consulta = new Query("consult('" + rutaArchivo +"')");
            return consulta.hasSolution();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
            return false;
        }
    }
    
    
    
    public void cambiarParametroNoTieneCuenta(Persona pSeleccionada,Vehiculo vehiculo,String contra){//pasar contraseña
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
        
        
        
        // 1. Abrir archivo .pl
        if(!abrirArchivoBaseDeConocimientoPersonas()){
            JOptionPane.showMessageDialog(null, "No se pudo abrir la base de conocimiento");
            return;
        }

        // 2. HECHO ORIGINAL CON FALSE
        String hechoViejo = String.format(
        "usuario(_,_,%d,_,_,_,_,_,_,_,_,_,false)",
        legajo
        );

        // 3. Retirar el hecho con false
        Query retract = new Query("retract(" + hechoViejo + ")");
        if(!retract.hasSolution()){
            System.out.println("No se pudo retractar, no coincidió el hecho.");
            return;
        }

        // 4. HECHO NUEVO CON TRUE
        String hechoNuevo = String.format(
        "assert(usuario('%s','%s',%d,%d,%d,'%s','%s','%s','%s','%s','%s','%s',true))",
        nombre,
        apellido,
        legajo,
        dni,
        telefono,
        correo,
        tipo,
        marca,
        modelo,
        patente,
        saldo,
        contraseña
        
        );

        Query assertQ = new Query(hechoNuevo);
        assertQ.hasSolution();

        // 5. SOBRESCRIBIR ARCHIVO REAL CON TODOS LOS HECHOS
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";

        Query salida = new Query("tell('" + rutaArchivo + "')");
        salida.hasSolution();

        Query listing = new Query("listing(usuario/13).");
        listing.hasSolution();

        Query told = new Query("told");
        told.hasSolution();

        System.out.println("Hecho actualizado y guardado correctamente.");
    }
    
    
    public String obtenerContraseñaPorLegajo(Long legajoBuscado) {

        try {
            if (!abrirArchivoBaseDeConocimientoPersonas()) {
                return null;
            }

            String consulta = String.format(
                "usuario(_,_,%d,_,_,_,_,_,_,_,_,Contraseña,_)", 
                legajoBuscado
            );

            Query q = new Query(consulta);

            if (!q.hasSolution()) return null;

            Term solucion = q.oneSolution().get("Contraseña");

            return solucion.name(); // sin comillas

        } catch (Exception e) {
            return null;
        }
    }
    public String obtenerSaldoPorLegajo(Long legajoBuscado){
         try {
            if (!abrirArchivoBaseDeConocimientoPersonas()) {
                
                return null;
            }

            String consulta = String.format(
                "usuario(_,_,%d,_,_,_,_,_,_,_,Saldo,_,true)", 
                legajoBuscado
            );
            
            
            Query q = new Query(consulta);

            if (!q.hasSolution()){ 
                
                return null;
            };
            

            Term solucion = q.oneSolution().get("Saldo");
             System.out.println("Saldo "+solucion);

            return solucion.name(); // sin comillas

        } catch (Exception e) {
             
            return null;
        }
    }
    
    public void CambiarSaldoCuenta(Persona pSeleccionada, String contra,String nuevoSaldo){//pasar contraseña
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
        if (!abrirArchivoBaseDeConocimientoPersonas()) {
                
                return;
            }
        String hechoViejo = String.format(
        "usuario(_,_,%d,_,_,_,_,_,_,_,_,_,true)",
        legajo
        );
        
        // 3. Retirar el hecho con false
        Query retract = new Query("retract(" + hechoViejo + ")");
        if(!retract.hasSolution()){
            
            return;
        }
        
        String hechoNuevo = String.format(
        "assert(usuario('%s','%s',%d,%d,%d,'%s','%s','%s','%s','%s','%s','%s',true))",
        nombre,
        apellido,
        legajo,
        dni,
        telefono,
        correo,
        tipo,
        marca,
        modelo,
        patente,
        nuevoSaldo,
        contraseña
        );
        
        Query assertQ = new Query(hechoNuevo);
        assertQ.hasSolution();

        // 5. SOBRESCRIBIR ARCHIVO REAL CON TODOS LOS HECHOS
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";

        Query salida = new Query("tell('" + rutaArchivo + "')");
        salida.hasSolution();

        Query listing = new Query("listing(usuario/13).");
        listing.hasSolution();

        Query told = new Query("told");
        told.hasSolution();

        System.out.println("Hecho actualizado y guardado correctamente.");
        
        
        
        
        
    }

    

    
    
}
