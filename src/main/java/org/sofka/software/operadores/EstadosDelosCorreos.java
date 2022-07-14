package org.sofka.software.operadores;

import org.sofka.software.utilities.Email;

import java.util.List;
import java.util.stream.Collectors;

import static org.sofka.software.operadores.ImprimirCorreos.cadenaDeCorreos;
import static org.sofka.software.utilities.MyPrintAbstract.*;

/**
 * [Clase de EstadoDeLosCorreos]
 * En la misma lista determinar si se envió un
 * correo o no a cada uno de los correos,
 * si se le envió cambiar el estado en la lista,
 * todo esto respetando la inmutabilidad.
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class EstadosDelosCorreos {

  private final List<Email> list;

  /**
   * [Método Constructor]
   * @param list Recibe como parámetro una Lista de Email de tipo List<Email>.
   */
  public EstadosDelosCorreos(List<Email> list) {
    this.list = list;
  }

  /**
   * [Método Controlador]
   * Encargado de gestionar la operación de cambiar estado
   * Imprime los correos enviados y nos muestra en la impresión
   * la lista detalla da de correos a los cuales se le
   * enviaron mensajes y tiene el estado activo y
   * cuáles coreos no han recibido mensaje.
   * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
   * @since [1.0.0]
   */
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

  /**
   * [Método representar el evento de enviar un correo]
   * cuando este evento acure el estado de la lisa de correos
   * debe cambiar y colocarse el correo en un estado activo
   * @param email String
   * @param list List<Email>
   * @return List<Email>
   * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
   * @since [1.0.0]
   */
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

  /**
   * [Método para eliminar los correos repetidos en la Lista de correos]
   * @param list List<Email>
   * @return List<Email>
   * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
   * @since [1.0.0]
   */
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
