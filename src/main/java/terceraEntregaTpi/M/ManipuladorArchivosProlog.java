/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceraEntregaTpi.M;

import javax.swing.JOptionPane;
import org.jpl7.Query;

/**
 *
 * @author lautaro
 */
public class ManipuladorArchivosProlog {
    public Boolean abrirArchivoBaseDeConocimientoPersonas(){
        try {
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";

        
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
            Query consulta = new Query("consult('" + rutaArchivo +"')");
            return consulta.hasSolution();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ocurrio un error inesperado");
            return false;
        }
    }
    
    
    
    public void cambiarParametroNoTieneCuenta(Persona pSeleccionada,Vehiculo vehiculo){
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
        
        
        // 1. Abrir archivo .pl
        if(!abrirArchivoBaseDeConocimientoPersonas()){
            JOptionPane.showMessageDialog(null, "No se pudo abrir la base de conocimiento");
            return;
        }

        // 2. HECHO ORIGINAL CON FALSE
        String hechoViejo = String.format(
        "usuario(_,_,%d,_,_,_,_,_,_,_,false)",
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
        "assert(usuario(%s,%s,%d,%d,%d,%s,%s,%s,%s,%s,true))",
        nombre,
        apellido,
        legajo,
        dni,
        telefono,
        correo,
        tipo,
        marca,
        modelo,
        patente
        );

        Query assertQ = new Query(hechoNuevo);
        assertQ.hasSolution();

        // 5. SOBRESCRIBIR ARCHIVO REAL CON TODOS LOS HECHOS
        String rutaArchivo = "src/main/resources/prolog/BaseConocimientoPersonasUtn.pl";

        Query salida = new Query("tell('" + rutaArchivo + "')");
        salida.hasSolution();

        Query listing = new Query("listing(usuario).");
        listing.hasSolution();

        Query told = new Query("told");
        told.hasSolution();

        System.out.println("Hecho actualizado y guardado correctamente.");
    }
}
