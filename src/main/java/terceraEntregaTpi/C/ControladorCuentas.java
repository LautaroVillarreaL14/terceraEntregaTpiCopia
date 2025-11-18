/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package terceraEntregaTpi.C;
import terceraEntregaTpi.V.Usuarios;
import terceraEntregaTpi.V.Usuarios;
import org.jpl7.*;
import java.util.ArrayList;
import terceraEntregaTpi.V.PantallaCrearCuenta;
import java.util.List;
import java.util.Map;
import terceraEntregaTpi.M.Persona;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import terceraEntregaTpi.M.Vehiculo;
import terceraEntregaTpi.M.CuentaUsuario;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import terceraEntregaTpi.M.Main;
import terceraEntregaTpi.C.ControladorPersona;
import terceraEntregaTpi.V.Usuarios;
import terceraEntregaTpi.V.PantallaPrincipal;
import terceraEntregaTpi.M.ManipuladorArchivosProlog;
import terceraEntregaTpi.M.Buscador; //aca usamos interfaz, habria que agregarle algo mas o hacer otra

public class ControladorCuentas implements Buscador{
    private final Usuarios vista;
    
    
    public ControladorCuentas(Usuarios vista){
        this.vista = vista;
        
        
        ManipuladorArchivosProlog manipulador = new ManipuladorArchivosProlog();
        this.vista.getBotonBuscar().addActionListener(e->{mostrarPersonas(manipulador);});    
    }
    
    
    public void mostrarPersonas(ManipuladorArchivosProlog manipulador){
        try{
            String nombreBuscar = vista.getTxtBusqueda().getText().toLowerCase();
            List<Persona> usuarios = buscarPersonasConCuenta(manipulador);
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            for (Persona u : usuarios) {
                if (nombreBuscar.isEmpty() ||
                    u.getNombre().toLowerCase().contains(nombreBuscar) ||
                    u.getApellido().toLowerCase().contains(nombreBuscar)) {

                    modeloLista.addElement(u.getNombre() + " " + u.getApellido() + " " + u.getDNI());
                }
            }
            vista.getListaUsuarios().setModel(modeloLista);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "No se pudo realizar la busqueda");
        }
    }
    public List<Persona> buscarPersonasSinCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> sinCuenta = new ArrayList<>();
        return sinCuenta;
    }
    public List<Persona> buscarPersonasConCuenta(ManipuladorArchivosProlog manipulador){
        List<Persona> conCuenta = new ArrayList<>();
        if (!manipulador.abrirArchivoBaseDeConocimientoPersonas()) {
            return conCuenta;
        }
        Query buscar = new Query("usuario(Nombre, Apellido, Legajo, Dni, Telefono, Correo, Tipo, Marca, Modelo, Patente, true)");
        while(buscar.hasMoreSolutions()){
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
     
}
    
    
    
    
