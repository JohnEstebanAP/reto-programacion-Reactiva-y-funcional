package org.sofka.software.ejercicios;

import org.sofka.software.utilities.Start;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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
            "pirobo"
    );
    @Override
    public void start() {

        final String SEPARATOR = "--------------------------------------------------------------------------";
        String message1 = " **************** Chat ************** ";
        String message2 = "Por favor ingrese una frase:";
        String message3 = "Las groserías que ingrese serán remplazadas por **** ";

        makeLog("\n{0} \n{1} \n{2} \n{3} \n{0}", new Object[]{SEPARATOR, message1, message2, message3});
        Scanner scanner = new Scanner(System.in);
        String message4 = scanner.nextLine().toLowerCase(Locale.ROOT);

        String[] listaPalabrasDelMensaje = message4.split(" ");
        //hola sebas
        var palabras = Flux.just(listaPalabrasDelMensaje).map(palabra -> {
            return (groserias.contains(palabra)) ? (palabra = "*****") : (palabra);
        }).collect(Collectors.toList());

        Mono<String> mensajeConcatenado = imprimirPalabras(palabras);

        mensajeConcatenado.subscribe(mensaje -> logMessage2("Mensaje Filtrado: " , mensaje.toString()));
    }

    public Mono<String> imprimirPalabras( Mono<List<String>>  palabras){
        return palabras.map(palabra -> {
            return palabra.toString();
        });
    }
}
