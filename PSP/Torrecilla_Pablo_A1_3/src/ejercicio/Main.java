package ejercicio;

import java.math.BigDecimal;
import java.util.Locale;

/**
 * Programa que lee dos números desde la entrada estándar (System.in), controla
 * que lo introducido sean realmente números y muestra su suma.
 * 
 * Método Main. Debe llamarse igual que el archivo. Puede llamarse de cualquier
 * manera, pero al contener el main() son buenas prácticas llamarla Main o App.
 *
 * Main Es la clase principal
 */
public class Main {

  /**
   * Posición del primer número introducido por argumentos
   */
  private static final int ARG1 = 0;
  /**
   * Posición del segundo número introducido por argumentos
   */
  private static final int ARG2 = 1;
  /**
   * Código de error para el System.exit() cuando los argumentos no son correctos
   */
  private static final int EXIT_ERROR = 2;

  /**
   * Método para verificar que el dato introducido es un número válido.
   * 
   * @param arg recoge un dato tipo String del main()
   * @return devuelve un booleano: true si se cumple la condición o salta la
   *         excepción y false si no
   */
  private static boolean isNaN(String arg) {
    try {
      return !Double.isFinite(new BigDecimal(arg).doubleValue());
    } catch (NumberFormatException e) {
      return true;
    }
  }

  /**
   * Este método sirve para sumar dos números tipo double recogidos por
   * argumentos. Con Locale.ROOT se formatea el número para que ponga un . y no
   * una , como separador de sus decimales
   * 
   * @param nums Recoge el array de números tipo double ya parseados con
   *             Double.parseDouble().
   * 
   */
  private static void sumarNumeros(double[] nums) {
    System.out.printf(Locale.ROOT, "Suma: %.2f%n", nums[ARG1] + nums[ARG2]);
  }

  /**
   * Clase main(). Aquí se ejecuta el código. Se hacen las llamadas a las
   * funciones, clases etc.
   *
   * @param args Recoge los argumentos por consola separados por espacios.
   */
  public static void main(String[] args) {

    if (args.length < 2) {
      System.err.println("Introduce dos argumentos");
      System.exit(2);
    }

    if (isNaN(args[ARG1]) || isNaN(args[ARG2])) {
      System.err.println("Error: Los parámetros introducidos no son números válidos.");
      System.exit(EXIT_ERROR);
    }

    double[] nums = { Double.parseDouble(args[ARG1]), Double.parseDouble(args[ARG2]) };

    sumarNumeros(nums);

  }
}
