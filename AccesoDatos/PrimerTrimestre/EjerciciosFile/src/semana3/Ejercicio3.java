package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio3 {

  public static void main(String[] args) {

    Path p = Path.of("src/mensaje.txt");

    try (FileReader fR = new FileReader(p.toFile());
        BufferedReader bR = new BufferedReader(fR)) {

      String str;
      while ((str = bR.readLine()) != null) {

        System.out.println(str);

      }
    } catch (IOException e) {
      System.err.printf("Error de Entrada/Salida: %s", e.getMessage());
    }

  }

}
