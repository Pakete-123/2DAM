package ejercicio;

import java.util.Locale;

/**
 * Método Main. Debe llamarse igual que el archivo. Puede llamarse de cualquier
 * manera, pero al contener el main() son buenas prácticas llamarla Main o App.
 *
 * Main Es la clase principal
 */
public class Main {

  private static final int ARG1 = 0;
  private static final int ARG2 = 1;

  /**
   * Método para verificar que el dato introducido es un número válido.
   * 
   * @param arg recoge un dato tipo String del main()
   * @return devuelve un booleano: true si se cumple la condición y false si no
   */
  private static boolean isNaN(String arg) {
    try {
      double val = Double.parseDouble(arg);
      return Double.isInfinite(val) && Double.isNaN(val);
    } catch (NumberFormatException e) {
      System.err.printf("Introduce un formato válido: %s%n", e.getMessage());
      System.exit(2);
      return false;
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
      System.exit(2);
    }

    double[] nums = { Double.parseDouble(args[ARG1]), Double.parseDouble(args[ARG2]) };

    sumarNumeros(nums);

  }
}
