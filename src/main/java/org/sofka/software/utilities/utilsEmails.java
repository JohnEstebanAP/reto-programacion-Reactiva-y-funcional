package org.sofka.software.utilities;

import java.util.List;
import java.util.stream.Collectors;

public class utilsEmails {
    //38 correos
    static final private List<Email> correos = List.of(
            new Email("esteban.ea145@gmail.com", false),
            new Email("pedro@gmail.com", false),
            new Email("j.alvarez2744@gmail.com", false),
            new Email("HernanVelasquez@gmail.com", false),
            new Email("DuvanLeal@gmail.com", false),
            new Email("DiegoFelipeMoños@gmail.com", false),
            new Email("JuanDavid@gmail.com", false),
            new Email("JuanRamallo@gmail.com", false),
            new Email("Manuel@gmail.com", false),
            new Email("piter@gmail.com", false),
            new Email("santiago@gmail.com", false),

            new Email("johnEsteban@", false),
            new Email("juangmail.com", false),
            new Email("esteban.ea145@gmail.com", false),

            new Email("carlos@hotmail.com", false),
            new Email("carlos@hotmail.com", false),
            new Email("HernanVelasquez@gmail.com", false),
            new Email("DuvanLeal@hotmail.com", false),
            new Email("DiegoFelipeMoños@hotmail.com", false),
            new Email("JuanDavid@hotmail.com", false),
            new Email("JuanRamallo@hotmail.com", false),
            new Email("Manuel@hotmail.com", false),
            new Email("piter@hotmail.com", false),
            new Email("santiago@hotmail.com", false),
            new Email("juan@hotmail.com", false),
            new Email("juan@hotmail.com", false),

            new Email("juan@outlook.com", false),
            new Email("juan@outlook.com", false),
            new Email("pedro@outlook.com", false),
            new Email("j.alvarez2744@outlook.com", false),
            new Email("HernanVelasquez@outlook.com", false),
            new Email("DuvanLeal@outlook.com", false),
            new Email("DiegoFelipeMoños@outlook.com", false),
            new Email("JuanDavid@outlook.com", false),
            new Email("JuanRamallo@outlook.com", false),
            new Email("Manuel@outlook.com", false),
            new Email("piter@outlook.com", false),
            new Email("santiago@outlook.com", false)

    );

    public static List<String> consultarEmails(){
        return  correos.stream().map( correo -> correo.email()).collect(Collectors.toList());
    }

    public static List<Email> consultarEmailsYEstados(){
        return  correos.stream().map( correo -> correo).collect(Collectors.toList());
    }


}
