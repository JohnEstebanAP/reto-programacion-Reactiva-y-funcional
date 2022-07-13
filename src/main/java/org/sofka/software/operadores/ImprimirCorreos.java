package org.sofka.software.operadores;

import org.sofka.software.utilities.MyPrintAbstract;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class  ImprimirCorreos extends MyPrintAbstract {

    public static void imprimirCorreos(List<String> correos, String message){

        AtomicReference<Integer> contador = new AtomicReference<>(1);

        var correosConcatenados = correos.stream()
                .reduce("", ( acumulador, correo) ->  {
                    String index = (contador.getAndSet(contador.get() + 1)).toString();
                   return  acumulador.toString()
                           .concat("\n")
                           .concat(index)
                           .concat(": ")
                           .concat(correo.toString());
                }).toString();

        logMessage(message ,correosConcatenados);
    }
}
