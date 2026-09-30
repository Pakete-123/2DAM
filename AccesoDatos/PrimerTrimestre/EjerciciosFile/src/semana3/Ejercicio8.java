package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio8 {

  public static void main(String[] args) {

    Path p = Path.of("src/alumnos.csv");

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String str = bR.readLine();
      while ((str = bR.readLine()) != null) {

        if (str.isBlank()) {
          continue;
        }

        String[] palabras = str.split(";");

        String nom = palabras[1];
        int ed = Integer.parseInt(palabras[2]);
        String cur = palabras[3];

        System.out.printf("%s (%d años) - %s%n", nom, ed, cur);

      }

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());

    }

  }

}
