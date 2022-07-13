package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;

public class OperadorA {

    private final List<String> list;

    public OperadorA(List<String> list) {
        this.list = list;
    }

    public void controladorOperadorA(){
        ImprimirCorreos.imprimirCorreos(list, "Correos Repetidos" );
        List<String> correosFiltrados = eliminarCorreosRepetidos();
        ImprimirCorreos.imprimirCorreos(correosFiltrados, "Correos Filtrados");
    }

    ///Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
    public List<String> eliminarCorreosRepetidos(){
        return (List<String>) list.stream().distinct().collect(Collectors.toList());
    }

}
