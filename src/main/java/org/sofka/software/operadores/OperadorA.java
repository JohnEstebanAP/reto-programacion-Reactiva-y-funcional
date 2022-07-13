package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;

public class OperadorA {

    private List list;

    public OperadorA(List list) {
        this.list = list;
    }

    public void controladorOperadorA(){
        ImprimirCorreos.imprimirCorreos(list);
        List correosFiltrados = eliminarCorreosRepetidos();
        ImprimirCorreos.imprimirCorreos(correosFiltrados);

    }

    ///Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
    public List eliminarCorreosRepetidos(){
        return (List) list.stream().distinct().collect(Collectors.toList());
    }

}
