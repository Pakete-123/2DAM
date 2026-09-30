package semana3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio14 {

  public static void main(String[] args) {

    Path p = Path.of("src/fichero_especial2.txt");

    try {

      Files.writeString(p,
          "Hola, soy un fichero con ñ, tildes como esdrújula o tío y con signos ortográficos como () ¿? !¡",
          StandardCharsets.UTF_8);

      System.out.print(Files.readString(p));

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

  }

}
