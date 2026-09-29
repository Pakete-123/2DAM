package semana3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Ejercicio2 {

  public static void main(String[] args) {

    Path p = Path.of("./src/mensaje.txt");

    String nuevo = "Nueva línea 4" + System.lineSeparator();

    try {

      Files.writeString(p, nuevo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
      System.out.printf("Línea añadida a %s.", p.toAbsolutePath());

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

  }

}
