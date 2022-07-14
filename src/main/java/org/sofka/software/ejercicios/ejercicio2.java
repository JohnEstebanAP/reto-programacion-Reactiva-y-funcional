package org.sofka.software.ejercicios;

import org.sofka.software.utilities.Start;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * [Clase controladora del ejercicio 2.]
 * Esta clase extiende de Start para ser iniciada desde el menu principal.
 * Controlador un chat creado con programación reactiva y funcional
 * filtra las malas palabras y las retorna como ***
 * o data de correos electrónicos.
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class ejercicio2 extends Start {

    private List<String> groserias = List.of(
            "hp",
            "lichigo",
            "gorrero",
            "gonorrea",
            "huevón",
            "garbimba",
            "sapo",
            "perro",
            "perra",
            "atolondrado",
            "bazofia",
            "bobalicon",
            "bobo",
            "cacorro",
            "chimba",
            "corroncho",
            "coscorria",
            "fufa",
            "puta",
            "puta",
            "garbimba",
            "gonorrea",
            "guaricha",
            "guisa",
            "hijueputa",
            "idiota",
            "imbécil",
            "locota",
            "nenitas",
            "malparido",
            "mediocre",
            "menso",
            "ñero",
            "puto",
            "pirobo",
            "pirobos",
            "hijueputas"
    );

    /**
     * [Método Controlador llamado Start para ejecutar las operaciones a aplicar en el Chat de malas palabras]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    @Override
    public void start() {

        /**
         * Mensajes para imprimir de una manera agradable para el usuario
         */
        final String SEPARATOR = "--------------------------------------------------------------------------";
        String message1 = " **************** Chat ************** ";
        String message2 = "Por favor ingrese una frase:";
        String message3 = "Las groserías que ingrese serán remplazadas por **** ";

        //Imprimimos un Mensaje en consola
        makeLog("\n{0} \n{1} \n{2} \n{3} \n{0}", new Object[]{SEPARATOR, message1, message2, message3});

        Scanner scanner = new Scanner(System.in);
        String message4 = scanner.nextLine().toLowerCase(Locale.ROOT);


        String[] listaPalabrasDelMensaje = message4.split(" ");

        Mono<List<String>> palabras = filtrarPalabras(listaPalabrasDelMensaje);

        Mono<String> mensajeConcatenado = imprimirPalabras(palabras);

        //Mediante él uso del flujo Mono, aplicamos un Subscriber para imprimir el mensaje filtrado;
        mensajeConcatenado.subscribe(mensaje -> logMessage2("Mensaje Filtrado: " , mensaje.toString()));
    }

    /**
     * [Método encargado de mapear una lista de palabras y
     * si se encuentra una mala palabra esta sera remplazada por ****]
     * @param listaPalabrasDelMensaje String[]
     * @return Mono<List<String>>
     */
    public Mono<List<String>> filtrarPalabras(String[] listaPalabrasDelMensaje){
        return Flux.just(listaPalabrasDelMensaje).map(palabra -> {
            return (groserias.contains(palabra)) ? (palabra = "*****") : (palabra);
        }).collect(Collectors.toList());
    }

    /**
     * [Método para mapear una lista de palabras de tipo String para retornarlas como una sola cadena.
     * @param palabras Mono<List<String>>
     * @return Mono<String>
     */
    public Mono<String> imprimirPalabras( Mono<List<String>>  palabras){
        return palabras.map(Object::toString);
    }
}
