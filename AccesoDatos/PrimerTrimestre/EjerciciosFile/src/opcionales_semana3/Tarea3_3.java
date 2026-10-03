package opcionales_semana3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Tarea3_3 {

  private static final String EXIT = "salir";

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.print("¿En qué fichero ya existente quieres que se añada texto? ");
      Path p = Path.of(bR.readLine());

      if (!Files.isRegularFile(p)) {

        System.out.println("El fichero no existe o no es un fichero normal. ");
        return;

      }

      System.out.println("Introduce lo que quieras que se escriba en el fichero, escribe 'salir' para salir: ");
      String str;

      try (BufferedWriter bW = Files.newBufferedWriter(p, StandardOpenOption.APPEND)) {

        while ((str = bR.readLine()) != null && !str.equals(EXIT)) {

          bW.write(str);
          bW.newLine();

        }

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s%n", e.getMessage());
    }

  }

}
