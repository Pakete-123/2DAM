package semana4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio1 {

  private static final String FILE = "src/semana4/temperaturas.dat";

  public static void main(String[] args) {

    Double[] temperatures = { 18.5, 19.2, 21.7, 23.1, 22.8, 20.4 };

    double sum = 0;
    double max = temperatures[0];
    double min = temperatures[0];

    for (Double t : temperatures) {
      sum += t;
      max = Math.max(max, t);
      min = Math.min(min, t);

    }

    double media = sum / temperatures.length;

    try (DataOutputStream dOS = new DataOutputStream(new FileOutputStream(FILE))) {

      for (Double t : temperatures) {
        dOS.writeDouble(t);
      }

      dOS.writeDouble(media);
      dOS.writeDouble(max);
      dOS.writeDouble(min);

      System.out.printf("Fichero %s creado correctamente.%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error al escribir en el fichero: %s%n", e.getMessage());
      return;
    }

    System.out.printf("----> Contenido de %s:%n", FILE);
    int counter = 0;

    try (DataInputStream dIS = new DataInputStream(new FileInputStream(FILE))) {

      while (true) {
        double val = dIS.readDouble();
        counter++;

        String label = switch (counter) {
          case 7 -> "Media";
          case 8 -> "Máxima";
          case 9 -> "Mínima";
          default -> "Temperatura";
        };

        System.out.printf("%s: %.2f%n", label, val);
      }

    } catch (EOFException e) {
      System.out.printf("Fichero leído correctamente. Valores leídos: %d%n", counter);
    } catch (IOException e) {
      System.err.printf("Error al leer el fichero: %s%n", e.getMessage());
    }

  }

}
