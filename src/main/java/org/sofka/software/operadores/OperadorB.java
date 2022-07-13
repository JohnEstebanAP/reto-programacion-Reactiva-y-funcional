package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;

public class OperadorB {

    private final List<String> list;

    public OperadorB(List<String> list) {
        this.list = list;
    }

    public void controladorOperadorB(){
        ImprimirCorreos.imprimirCorreos(list, "Correos Completos" );

        List<String> correosGmail = dominioDeGmail();
        ImprimirCorreos.imprimirCorreos(correosGmail, "Correos de Gmail");

        List<String> correosHotmail = dominioDeHotmail();
        ImprimirCorreos.imprimirCorreos(correosHotmail, "Correos de Hotmail");

        List<String> correosOutlook = dominioDeOutlook();
        ImprimirCorreos.imprimirCorreos(correosOutlook, "Correos de Outlook");
    }

    //Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
    public List<String> dominioDeGmail(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("gmail")).collect(Collectors.toList());
    }

    public List<String> dominioDeHotmail(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("hotmail")).collect(Collectors.toList());
    }

    public List<String> dominioDeOutlook(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("outlook")).collect(Collectors.toList());
    }

}
