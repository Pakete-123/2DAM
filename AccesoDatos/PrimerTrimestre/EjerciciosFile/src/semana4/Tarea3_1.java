package semana4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Tarea3_1 {

  public static void main(String[] args) {

    try (BufferedReader bRI = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.print("Dame la ruta al fichero que tengo que leer: ");
      Path origin = Path.of(bRI.readLine());

      System.out.print("Ahora dime donde tengo que escribirlo: ");
      Path destiny = Path.of(bRI.readLine());

      try (BufferedReader bRF = Files.newBufferedReader(origin);
          BufferedWriter bWF = Files.newBufferedWriter(destiny, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

        String reader;
        while ((reader = bRF.readLine()) != null) {

          bWF.write(reader);
          bWF.newLine();

        }

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s%n", e.getMessage());
    }

  }

}
