package org.sofka.software.operadores;

import org.sofka.software.utilities.Email;
import org.sofka.software.utilities.MyPrintAbstract;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


/**
 * Clase encargada de imprimir una lista
 * formatiandolo de manera bonita y con su correspondent index
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class  ImprimirCorreos extends MyPrintAbstract {

    /**
     * [Método para imprimir una lista de correos de tipo String]
     * @param correos List<String>
     * @param message String
     */
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

        logMessage2(message ,correosConcatenados);
    }

    /**
     * Recorre una Lista de correos mapeándola
     * para reducirla en una sola variable de tipo String
     * para posterior-mente ser imprimida.
     * @param correos List<Email>
     * @return String
     */
    public static String cadenaDeCorreos(List<Email> correos){

        AtomicReference<Integer> contador = new AtomicReference<>(1);

        return correos.stream()
                .map(email -> email.toString())
                .reduce("", ( acumulador, correo) ->  {
                    String index = (contador.getAndSet(contador.get() + 1)).toString();
                   var mensajeConcatenado=  acumulador.toString()
                           .concat("\n")
                           .concat(index)
                           .concat(": ")
                           .concat(correo.toString()).toString();
                   return mensajeConcatenado;
                });
    }
}
