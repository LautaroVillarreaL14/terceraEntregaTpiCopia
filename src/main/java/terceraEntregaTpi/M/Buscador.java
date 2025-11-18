/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package terceraEntregaTpi.M;

import java.util.List;

/**
 *
 * @author lautaro
 */
public interface Buscador {
    void mostrarPersonas(ManipuladorArchivosProlog manipulador);
    List<Persona> buscarPersonasSinCuenta(ManipuladorArchivosProlog manipulador);//unificar este con personas con cuenta, que el mismo devuvleva una lista de personas pero que sea las personas
        //con o sin cuenta dependiendo de un parametro booleano que se le pase, el mismo debera ser utilizado para el filtrado de personas
        //en la linea 80, en vez de true->bandera
    List<Persona> buscarPersonasConCuenta(ManipuladorArchivosProlog manipulador);
}
