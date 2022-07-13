package org.sofka.software.operadores;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.sofka.software.utilities.MyPrintAbstract.log;
import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

public class OperadorD {

    private final List<String> list;

    public OperadorD(List<String> list) {
        this.list = list;
    }

    public void controladorOperadorD(){
        Long countCorreos = countCorreos();
        logMessage("Cantidad de correos: ", countCorreos.toString());
    }

    //Saber la cantidad de correos que hay, sin usar un ciclo
    public Long countCorreos(){
        return list.stream().count();
    }
}
