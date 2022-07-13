package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;

import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

public class OperadorE {

    private final List<String> list;

    public OperadorE(List<String> list) {
        this.list = list;
    }

    public void controladorOperadorE(){

        Long correosGmail = dominioDeGmail();
        logMessage(String.valueOf(correosGmail), "Correos de Gmail");

        Long correosHotmail = dominioDeHotmail();
        logMessage(String.valueOf(correosHotmail), "Correos de Hotmail");

        Long correosOutlook = dominioDeOutlook();
        logMessage(String.valueOf(correosOutlook), "Correos de Outlook");
    }

    //Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
    public Long dominioDeGmail(){
    return list.stream().filter( correo -> correo.contains("gmail")).count();
    }
    public Long dominioDeHotmail(){
    return list.stream().filter( correo -> correo.contains("hotmail")).count();
    }
    public Long dominioDeOutlook(){
    return  list.stream().filter( correo -> correo.contains("outlook")).count();
    }
}
