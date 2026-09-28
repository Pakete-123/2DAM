package semana2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio10 {

  public static void main(String[] args) {

    Path p = Path.of("datos/alumnos.txt");
    Path copy = Path.of("datos/alumnos_2026.txt");

    try {
      Files.move(p, copy);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
