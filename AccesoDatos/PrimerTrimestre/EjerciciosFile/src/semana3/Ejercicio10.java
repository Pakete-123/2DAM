package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio10 {

  public static void main(String[] args) {

    Path p = Path.of("src/alumnos.csv");
    int sum = 0, cantidad = 0;

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String str = bR.readLine();
      while ((str = bR.readLine()) != null) {

        if (str.isBlank()) {
          continue;
        }

        String[] palabras = str.split(";");

        int ed = Integer.parseInt(palabras[2].trim());
        sum += ed;
        cantidad++;

      }

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());
    }

    double media = (double) sum / cantidad;
    System.out.printf("Media de edad: %.2f", media);

  }

}
