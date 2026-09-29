package semana3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio1 {

  public static void main(String[] args) {

    Path p = Path.of("./src/mensaje.txt");
    List<String> lS = List.of(
        "Línea 1",
        "Línea 2",
        "Línea 3");

    try {
      Files.write(p, lS);
      System.out.printf("Fichero %s creado", p.toAbsolutePath());
    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

  }

}
