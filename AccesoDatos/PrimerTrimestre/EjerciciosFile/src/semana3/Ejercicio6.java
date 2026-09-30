package semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Ejercicio6 {

  private static int contarLineas(Path p, String str) {

    int contador = 0;

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String linea;
      while ((linea = bR.readLine()) != null) {

        if (linea.toLowerCase().contains(str.toLowerCase())) {
          contador++;
        }

      }

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());
    }

    return contador;
  }

  public static void main(String[] args) {

    Path p = Path.of("src/mensaje.txt");

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.print("Palabra a buscar: ");
      String str = bR.readLine();

      if (str.isBlank()) {
        System.out.println("Palabra no válida");
        return;
      }

      int contador = contarLineas(p, str);
      System.out.printf("líneas que contienen %s: %d", str, contador);

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());
    }

  }

}
