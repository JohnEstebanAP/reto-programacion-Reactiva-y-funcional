package org.sofka.software.ejercicios;

import org.sofka.software.operadores.*;
import org.sofka.software.utilities.Start;

import java.util.List;


public class ejercicio1 extends Start {

    List<String> correos = List.of(
            "esteban.ea145@gmail.com",
            "pedro@gmail.com",
            "j.alvarez2744@gmail.com",
            "johnEsteban@",
            "juangmail.com",
            "carlos@hotmail.com",
            "carlos@hotmail.com",
            "juan@hotmail.com",
            "juan@hotmail.com",
            "juan@hotmail.com",
            "juan@hotmail.com",
            "juan@outlook.com",
            "juan@outlook.com"
    );

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
    }
}
