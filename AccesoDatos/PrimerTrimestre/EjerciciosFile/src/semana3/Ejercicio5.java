package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Ejercicio5 {

  public static void main(String[] args) {

    Path p = Path.of("src/mensaje.txt");

    int nL, nC, nLV;
    nL = nC = nLV = 0;

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String str;
      while ((str = bR.readLine()) != null) {

        nL++;
        nC += str.length();

        if (str.isEmpty()) {
          nLV++;
        }

      }

      System.out.printf("Nº de líneas: %d%nNº de caracteres: %d%nNº de líneas vacías: %d", nL, nC, nLV);

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());
    }

  }

}
