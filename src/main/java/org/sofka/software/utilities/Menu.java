package org.sofka.software.utilities;

import java.util.ArrayList;
import java.util.List;

/**
 * [Clase que facilita la utilidad de imprimir en consola un Menu con opciones.]
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class Menu extends MyPrintAbstract {

    /**
     * Lista de elementos que pintara el menu.
     */
    private static List<String> elemenst = new ArrayList<>();

    /*
     *Array de objetos con el orden que debe pintar las opciones
     * */
    static Object[] object;

    /**
     * [Método constructor de la Clase Menu]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    public Menu() {
        //Método Constructor
    }

    /**
     * [Imprime en consola Menú con las instrucciones para ingresar un número y seleccionar un punto a ejecutar]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    public static void showMenu() {

        int cantidadOrder = elemenst.size();
        object = new Object[cantidadOrder];
        String order = "";

        for (int i = 0; i < cantidadOrder; i++) {
            order = order.concat("\n{" + i + "}");
            object[i] = elemenst.get(i);
        }

        order = order.concat("\n{0}");
        makeLog(order, object);
    }


    /**
     * [Método que permite pasarle una lista de opciones para mostrar en el menu]
     * @param elemenst Variable de tipo List<String> que contendrá la lista de elementos a imprimir y su correspondiente orden.
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    public static void setElemenstMenu(List<String> elemenst) {
        Menu.elemenst = elemenst;
    }

    public static List<String> elemenstMenu() {
        return elemenst;
    }
}
