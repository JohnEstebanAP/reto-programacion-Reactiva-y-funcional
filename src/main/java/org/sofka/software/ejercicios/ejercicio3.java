package org.sofka.software.ejercicios;

import org.sofka.software.utilities.Start;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * [Clase controladora del ejercicio 3.]
 * Esta clase extiende de Start para ser iniciada desde el menu principal.
 *
 * Calculadora derivación e integración de una función matemática con el X en el denominador
 *
 * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
 * @version 1.0.0
 * @since Esta presente desde la version 1.0.0
 */
public class ejercicio3 extends Start {

    /**
     * [Método Controlador llamado Start para ejecutar las operaciones a aplicar de la calculadora]
     *
     * @author John Esteban Alvarez Piedrahita - esteban.ea145@gmail.com
     * @since [1.0.0]
     */
    @Override
  public void start() {

    final String SEPARATOR =
        "--------------------------------------------------------------------------";
    String message1 = " **************** Calculadora de derivar y integrar ************** ";

    String imprimirResultados = "";

    String resultadoDerivada1 = derivarXenElDenominador(5.0, 3.0);
    String resultadoIntegral1 = integrarXenElDenominador(5.0, 3.0);

    String resultadoDerivada2 = derivarXenElDenominador(6.0, 1.0);
    String resultadoIntegral2 = integrarXenElDenominador(6.0, 1.0);

    String resultadoDerivada3 = derivarXenElDenominador(4.0, 0.0);
    String resultadoIntegral3 = integrarXenElDenominador(4.0, 0.0);

    imprimirResultados += resultadoDerivada1;
    imprimirResultados += resultadoIntegral1;
    imprimirResultados += "\n\n****************";
    imprimirResultados += resultadoDerivada2;
    imprimirResultados += resultadoIntegral2;
    imprimirResultados += "\n\n****************";
    imprimirResultados += resultadoDerivada3;
    imprimirResultados += resultadoIntegral3;

    makeLog("\n{0} \n{1} {2} \n{0}", new Object[] {SEPARATOR, message1, imprimirResultados});
  }

    /**
     * [Método para derivar cuando X se encuentra en el denominador]
     * @param coeficiente Double
     * @param exponente Double
     * @return String
     */
    public String derivarXenElDenominador(Double coeficiente, Double exponente) {

    BiFunction<Double, Double, Double> coeficienteMultiplicado =
        (coeficientefun, exponentefun) -> {
          return coeficiente * exponente * -1;
        };

      Function<Double, String> exponenteRestado =
              (exponenteFun) -> {
                  if (exponenteFun.equals(0.0)) {
                     return "0";
                  }
                  String resultado = String.valueOf(Math.abs((-1 * exponenteFun) - 1));
                  return "/ (x^" + resultado + ")";
      };

      return ("\n\nDerivada de: f(x)= ")
        .concat(coeficiente.toString())
        .concat("/(x^")
        .concat(exponente.toString())
        .concat(")")
        .concat("\nLa derivada y`= ")
        .concat(coeficienteMultiplicado.apply(coeficiente, exponente).toString())
        .concat(exponenteRestado.apply(exponente).toString());
  }


    /**
     * [Método para Integrar cuando X se encuentra en el denominador]
     * @param coeficiente Double
     * @param exponente Double
     * @return String
     */
  public String integrarXenElDenominador(Double coeficiente, Double exponente) {

    Function<Double, Double> coeficienteMultiplicado =
        (coeficienteFun) -> {
          return (coeficienteFun.equals(0.0)) ? (coeficienteFun * -1) : (coeficienteFun);
        };

    Function<Double, String> exponenteSumadoFormatiado =
        (exponenteFun) -> {
          if (exponenteFun.equals(0.0)) {
            return "x";
          }
          if (exponenteFun.equals(1.0)) {
            return " Ln|x|";
          }
          String resultado = String.valueOf(Math.abs((-1 * exponenteFun) + 1));
          return "/ (" + resultado + " x^" + resultado + ")";
        };

    return ("\n\nIntegral de: ∫ ")
        .concat(coeficiente.toString())
        .concat("/(x^")
        .concat(exponente.toString())
        .concat(") dx")
        .concat("\nLa Integral f(x)= ")
        .concat(coeficienteMultiplicado.apply(coeficiente).toString())
        .concat(exponenteSumadoFormatiado.apply(exponente).toString())
        .concat(" + C");
  }
}
