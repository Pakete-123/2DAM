package semana4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Tarea2_1_a {

  private static final Path PATH = Path.of("src/semana4/fichero.txt");

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new FileReader(PATH.toFile()))) {

      String str;
      while ((str = bR.readLine()) != null) {

        System.out.println(str);

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

  }

}
