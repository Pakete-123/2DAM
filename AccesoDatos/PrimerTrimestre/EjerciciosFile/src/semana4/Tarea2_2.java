package semana4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Tarea2_2 {

  private static final Path PATH = Path.of("src/semana4/fichero2.txt");
  private static final String EXIT = "exit";

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bW = Files.newBufferedWriter(PATH, StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {

      System.out.println("Introduce lo que quieras que se escriba en el fichero, escribe 'exit' para salir: ");
      String str;

      while ((str = bR.readLine()) != null && str.equals(EXIT)) {

        bW.write(str);
        bW.newLine();

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s%n", e.getMessage());
    }

  }

}
