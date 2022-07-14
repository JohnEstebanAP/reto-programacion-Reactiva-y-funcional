package org.sofka.software.ejercicios;

import org.sofka.software.operadores.*;
import org.sofka.software.utilities.Start;

import java.util.List;

import static org.sofka.software.utilities.DataUtilsEmails.consultarEmails;
import static org.sofka.software.utilities.DataUtilsEmails.consultarEmailsYEstados;

/**
 * [Clase controladora del ejercicio 1.]
 * Esta clase extiende de Start para ser iniciada desde el menu principal.
 * Controlador de las posibles operaciones
 * funcionales que puede tener una lista
 * o data de correos electrónicos.
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class ejercicio1 extends Start {

    List<String> correos = consultarEmails();

    /**
     * [Método Controlador llamado Start para ejecutar las operaciones a aplicar en la data de correos]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    @Override
    public void start() {
        OperadorA  operadorA = new OperadorA(correos);
        operadorA.controladorOperadorA();

        OperadorB operadorB = new OperadorB(correos);
        operadorB.controladorOperadorB();

        OperadorC operadorC = new OperadorC(correos);
        operadorC.controladorOperadorC();

        OperadorD operadorD = new OperadorD(correos);
        operadorD.controladorOperadorD();

        OperadorE operadorE = new OperadorE(correos);
        operadorE.controladorOperadorE();

        EstadosDelosCorreos estadosDelosCorreos = new EstadosDelosCorreos(consultarEmailsYEstados());
        estadosDelosCorreos.controladorOperadorEstados();
    }
}
