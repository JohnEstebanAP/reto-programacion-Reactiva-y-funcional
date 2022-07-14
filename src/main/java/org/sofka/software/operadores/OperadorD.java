package org.sofka.software.operadores;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.sofka.software.utilities.MyPrintAbstract.log;
import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

/**
 * [Clase encargada imprimir la cantidad de correos en una lista]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class OperadorD {

    private final List<String> list;

    public OperadorD(List<String> list) {
        this.list = list;
    }

    /**
     * [Método Controlador]
     * encargado de imprimir la cantidad de coreos en una lista
     */
    public void controladorOperadorD(){
        Long countCorreos = countCorreos();
        logMessage("Cantidad de correos: ", countCorreos.toString());
    }

    /**
     * Método para saber la cantidad de correos que hay,
     * sin usar un ciclo.
     * @return Long
     */
    public Long countCorreos(){
        return list.stream().count();
    }
}
