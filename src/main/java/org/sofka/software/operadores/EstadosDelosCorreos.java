package org.sofka.software.operadores;

import org.sofka.software.utilities.Email;

import java.util.List;
import java.util.stream.Collectors;

import static org.sofka.software.operadores.ImprimirCorreos.cadenaDeCorreos;
import static org.sofka.software.utilities.MyPrintAbstract.*;

public class EstadosDelosCorreos {

  private final List<Email> list;

  public EstadosDelosCorreos(List<Email> list) {
    this.list = list;
  }

  public void controladorOperadorEstados() {

    String correo1 = "Se a enviado un correo a el email: esteban.ea145@gmail.com";
    String correo2 = "Se a enviado un correo a el email: JuanRamallo@hotmail.com";
    String correo3 = "Se a enviado un correo a el email: DuvanLeal@outlook.com";
    String correo4 = "Se a enviado un correo a el email: HernanVelasquez@gmail.com";
    String correo5 = "Se a enviado un correo a el email: santiago@outlook.com";

    List<Email> listCorreo= eliminarCorreosRepetidos(list);

    makeLog("Estado de los Correos: \n {0}", new Object[] {cadenaDeCorreos(listCorreo)});

    List<Email> actualizacionCorreos1 = enviarCorreo("esteban.ea145@gmail.com", listCorreo);
    List<Email> actualizacionCorreos2 = enviarCorreo("JuanRamallo@hotmail.com", actualizacionCorreos1);
    List<Email> actualizacionCorreos3 = enviarCorreo("DuvanLeal@outlook.com", actualizacionCorreos2);
    List<Email> actualizacionCorreos4 = enviarCorreo("HernanVelasquez@gmail.com", actualizacionCorreos3);
    List<Email> actualizacionCorreos5 = enviarCorreo("santiago@outlook.com", actualizacionCorreos4);

    makeLog(
        "\n\n{0} \n{1} \n{2} \n{3} \n{4} \nEstado Actual de los Correos: \n {5}",
        new Object[] {correo1, correo2, correo3, correo4, correo5, cadenaDeCorreos(actualizacionCorreos5)});
  }

  public List<Email> enviarCorreo(String email, List<Email> list) {
    return list.stream()
        .map(
            correo -> {
              if (correo.email().contains(email)) {
                correo.state(true);
              }
              return correo;
            })
        .toList();
  }

  public List<Email> eliminarCorreosRepetidos(List<Email> list){
    List<Email> listEmails = list.stream()
            .map(email -> email.email())
            .distinct()
            .map(email->  {
              return new Email(email, false);
            }).toList();
    return listEmails;
  }

}
