package org.sofka.software.operadores;


import java.util.List;
import java.util.stream.Collectors;
/**
 * Clase encargada de Filtrar los coreos por los dominios {Gmail, hotmail, outlook}
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class OperadorB {

    private final List<String> list;

    public OperadorB(List<String> list) {
        this.list = list;
    }

    /**
     * [Método Controlador]
     * encargado de filtrar los correos por su correspondiente
     * dominio imprimiéndolos de una manera organizada y por su dominio.
     */
    public void controladorOperadorB(){
        ImprimirCorreos.imprimirCorreos(list, "Correos Completos" );

        List<String> correosGmail = dominioDeGmail();
        ImprimirCorreos.imprimirCorreos(correosGmail, "Correos de Gmail");

        List<String> correosHotmail = dominioDeHotmail();
        ImprimirCorreos.imprimirCorreos(correosHotmail, "Correos de Hotmail");

        List<String> correosOutlook = dominioDeOutlook();
        ImprimirCorreos.imprimirCorreos(correosOutlook, "Correos de Outlook");
    }




    /**
     * utilizando filter, saber si hay correos con dominio gmail.
     * @return List<String>
     */
    public List<String> dominioDeGmail(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("gmail")).collect(Collectors.toList());
    }

    /**
     * utilizando filter, saber si hay correos con dominio hotmail.
     * @return List<String>
     */
    public List<String> dominioDeHotmail(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("hotmail")).collect(Collectors.toList());
    }

    /**
     * utilizando filter, saber si hay correos con dominio outlook.
     * @return List<String>
     */
    public List<String> dominioDeOutlook(){
    return (List<String>)
        list.stream().filter( correo -> correo.contains("outlook")).collect(Collectors.toList());
    }

}
