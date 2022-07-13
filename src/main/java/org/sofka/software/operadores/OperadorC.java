package org.sofka.software.operadores;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.sofka.software.utilities.MyPrintAbstract.log;
import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

public class OperadorC {

    private final List<String> list;

    public OperadorC(List<String> list) {
        this.list = list;
    }

    public Boolean controladorOperadorC(){
        if(validarGmail()){
            log("Todos los correos cumplen con El @ y el dominio");
            return true;
        }
        log("No Todos los correos cumplen con El @ y el dominio");
        return false;
    }

    //Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
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
