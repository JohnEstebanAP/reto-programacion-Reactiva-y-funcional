package org.sofka.software.ejercicios;

import org.sofka.software.operadores.*;
import org.sofka.software.utilities.Start;

import java.util.List;

import static org.sofka.software.utilities.utilsEmails.consultarEmails;
import static org.sofka.software.utilities.utilsEmails.consultarEmailsYEstados;


public class ejercicio1 extends Start {

    List<String> correos = consultarEmails();

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
