package org.sofka.software;

import org.sofka.software.utilities.Start;

import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static org.sofka.software.utilities.Menu.*;
import static org.sofka.software.utilities.MyPrintAbstract.logMessage;

/**
 * [Clase que facilita la utilidad de imprimir en consola un Menu con opciones y ejecutar los puntos seleccionados.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.2.0
 * @since Esta presente desde la version 1.0.0
 */
public class Main extends Menu {

    protected static List<Start> puntos = new ArrayList<>();

    /**
     * [Método de inicio de la Clase Menu]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.2.0]
     */
    public static void main(String[] args) {
        List<Integer> list1 = List.of(2,35,44,8,44);
        List<Integer> list2 = List.of(2,5,44,0,6);

        puntos(new Sumar(list1, list2));
        startMenu();
    }

    /**
     * [Método de inicialización del menu]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.2.0]
     */
    public static void startMenu() {
        List<String> elemenst = new ArrayList<>();

        final String SEPARATOR = "--------------------------------------------------------------------------";
        final String MENU = " ********************************* Calculadora *********************************";
        final String MESSAGE = "  Por favor seleccione la opción que desea ejecutar";
        final String OPCIONES = "  ingrese un número para indicar un opción: ";

        elemenst.add(SEPARATOR);
        elemenst.add(MENU);
        elemenst.add(MESSAGE);
        elemenst.add(OPCIONES);
        elemenst.add("\n");
        elemenst.add("  1: Ejercio 1");
        elemenst.add("  2: Ejercio 2");
        elemenst.add("  3: Ejercio 3");
        elemenst.add("  20: Salir");

        setElemenstMenu(elemenst);
        showMenu();
        int option = initDatos();
        selectionIntro(option);
    }

    /**
     * [Imprime en consola las instrucciones para ingresar un número y comprobar que es un Entero de no ser asi se repite la función]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.2.0]
     */
    public static int initDatos() {
        Scanner scanner = new Scanner(System.in);
        int num;
        try {
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            showMenu();
            log("Por favor ingrese el número de manera correcta");
            num = initDatos();
        }
        return num;
    }

    /**
     * [ejecuta la opción seleccionada]
     *
     * @param option parámetro de tipo Entero(int) para indicar la opción seleccionada.
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.2.0]
     */
    public static void selectionIntro(int option) {
        option = option - 1;
        if (option < 4 && option >= 0) {
            logMessage("La opción seleccionada es", elemenstMenu().get(option + 3));
            Main.puntos.get(option).start();
            logMessage("Por favor presione una tecla y enter para continuar","");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            startMenu();
        } else if (option == 19) {
            log("Salir del menu :)");
        } else {

            log("Por favor ingrese una opción correcta");
            int num = initDatos();
            selectionIntro(num);
        }
    }

    /**
     * [Método para asignarle a la Lista de Objetos las tareas o clase a instance para ser ejecutadas]
     *
     * @param punto parámetro de tipo Entero(Objeto).
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.2.0]
     */
    public static void puntos(Start punto) {
        Main.puntos.add(punto);
    }
}
