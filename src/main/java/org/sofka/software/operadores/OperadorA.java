package org.sofka.software.operadores;


import org.sofka.software.utilities.Email;

import java.util.List;
import java.util.stream.Collectors;


/**
 * [Clase encargada de Eliminar correos Repetidos en una Lista]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class OperadorA {
    /**
     * Lista de Strings con correos.
     */
    private final List<String> list;


    /**
     * [Meto constructor]
     *
     * @param list recibe una Lista de correos de tipo List<String>
     */
    public OperadorA(List<String> list) {
        this.list = list;
    }

    /**
     * [Método Controlador]
     * encargado de filtrar los correos repetidos
     * e imprimir la lista original y la lista sin los correos repetidos.
     */
    public void controladorOperadorA(){
        ImprimirCorreos.imprimirCorreos(list, "Correos Repetidos" );
        List<String> correosFiltrados = eliminarCorreosRepetidos();
        ImprimirCorreos.imprimirCorreos(correosFiltrados, "Correos Filtrados");
    }

    /**
     * Método que utiliza Distinct para ver si hay correo repetidos, si hay correos repetidos eliminarlos
     * @return List<String>
     */
    public List<String> eliminarCorreosRepetidos(){
        return (List<String>) list.stream().distinct().collect(Collectors.toList());
    }

}
