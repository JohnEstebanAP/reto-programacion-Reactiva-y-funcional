package org.sofka.software.operadores;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.sofka.software.utilities.MyPrintAbstract.log;
import static org.sofka.software.utilities.MyPrintAbstract.logMessage;
/**
 * [Clase encargada de mapear una lista de correos y verificar
 * si todos los correos cumple con todas las condiciones
 * (Que cuente con el @ y el dominio)
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class OperadorC {

    private final List<String> list;

    /**
     * [Meto constructor]
     *
     * @param list recibe una Lista de correos de tipo List<String>
     */
    public OperadorC(List<String> list) {
        this.list = list;
    }

    /**
     * [Método Controlador]
     * Encargado de imprimir si todos los coreos cumplen o no las condiciones
     * (Que cuente con el @ y el dominio)
     */
    public Boolean controladorOperadorC(){
        if(validarGmail()){
            log("Todos los correos cumplen con El @ y el dominio");
            return true;
        }
        log("No Todos los correos cumplen con El @ y el dominio");
        return false;
    }

    /**
     * Método para saber si todos los correos
     * cumple con todas las condiciones (Que cuente con el @ y el dominio)
     * @return Boolean
     */
    public Boolean validarGmail(){

        var listCorreosValidos =  list.stream().map(correo -> {

             Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
             Matcher mat = pat.matcher(correo);

             var isValido = (mat.find()) ? true : false;

             return isValido;
        }).toList();

        var  isValido= listCorreosValidos.stream().filter(correo -> correo == false).reduce((a,b) -> a).get();
        return isValido;
    }
}
