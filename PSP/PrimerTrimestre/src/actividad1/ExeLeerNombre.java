package actividad1;

import java.io.IOException;

public class ExeLeerNombre {

  public static void main(String[] args) {

    try {

      ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "actividad1.LeerNombre", args[args.length - 1]);
      pb.inheritIO();

      Process p = pb.start();

      int codigoSalida = p.waitFor();

      System.out.printf("El proceso terminó con el código: %d%n", codigoSalida);
      System.exit(0);

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s%n", e.getMessage());
    } catch (InterruptedException e) {
      System.err.printf("Error: se ha interrumpido el proceso: %s%n", e.getMessage());
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.printf("Error: índice negativo para el array (%s). Introduce un argumento.", e.getMessage());
    }

  }

}
