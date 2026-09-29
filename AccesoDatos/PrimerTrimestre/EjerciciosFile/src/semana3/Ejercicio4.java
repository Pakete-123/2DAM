package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio4 {

  public static void main(String[] args) {

    Path p = Path.of("src/mensaje.txt");

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String str;
      int contador = 0;

      while ((str = bR.readLine()) != null) {

        contador++;
        System.out.printf("%d: %s%n", contador, str);

      }

    } catch (IOException e) {
      System.err.printf("Error de Entrada/Salida: %s", e.getMessage());
    }

  }

}
