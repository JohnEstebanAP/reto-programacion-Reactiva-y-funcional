package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;

import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

/**
 * [Clase encargada imprimir la cantidad de correos en una lista]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class OperadorE {

    private final List<String> list;

    public OperadorE(List<String> list) {
        this.list = list;
    }

    /**
     * [Método Controlador]
     * encargado de imprimir la cantidad de coreos en una lista deacuerdo a su dominio [Gmail, Hotmail, etc]
     */
    public void controladorOperadorE(){

        Long correosGmail = dominioDeGmail();
        logMessage(String.valueOf(correosGmail), "Correos de Gmail");

        Long correosHotmail = dominioDeHotmail();
        logMessage(String.valueOf(correosHotmail), "Correos de Hotmail");

        Long correosOutlook = dominioDeOutlook();
        logMessage(String.valueOf(correosOutlook), "Correos de Outlook");
    }

    /**
     * Método para saber la cantidad de correos que hay con un filtro y que sean del tipo Gmail,
     * sin usar un ciclo.
     * @return Long
     */
    public Long dominioDeGmail(){
    return list.stream().filter( correo -> correo.contains("gmail")).count();
    }
    /**
     * Método para saber la cantidad de correos que hay con un filtro y que sean del tipo Hotmail,
     * sin usar un ciclo.
     * @return Long
     */
    public Long dominioDeHotmail(){
    return list.stream().filter( correo -> correo.contains("hotmail")).count();
    }
    /**
     * Método para saber la cantidad de correos que hay con un filtro y que sean del tipo outlook,
     * sin usar un ciclo.
     * @return Long
     */
    public Long dominioDeOutlook(){
    return  list.stream().filter( correo -> correo.contains("outlook")).count();
    }
}
