package opcionales_semana3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Tarea3_2 {

  public static void main(String[] args) {

    try (BufferedReader bRI = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.print(
          "Este programa lee dos ficheros y los escribe de forma alterna en otro.\nDame la ubicación del primer fichero de lectura: ");
      Path lect1 = Path.of(bRI.readLine());

      System.out.print("Dame el segundo fichero de lectura: ");
      Path lect2 = Path.of(bRI.readLine());

      System.out.print("Por último dame dónde quieres que los imprima: ");
      Path wr = Path.of(bRI.readLine());

      try (BufferedReader bRF1 = Files.newBufferedReader(lect1);
          BufferedReader bRF2 = Files.newBufferedReader(lect2);
          BufferedWriter bW = Files.newBufferedWriter(wr, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

        String line1 = bRF1.readLine();
        String line2 = bRF2.readLine();

        while (line1 != null || line2 != null) {

          if (line1 != null) {

            bW.write(line1);
            bW.newLine();
            line1 = bRF1.readLine();

          }

          if (line2 != null) {

            bW.write(line2);
            bW.newLine();
            line2 = bRF2.readLine();

          }

        }

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s%n", e.getMessage());
    }

  }

}
