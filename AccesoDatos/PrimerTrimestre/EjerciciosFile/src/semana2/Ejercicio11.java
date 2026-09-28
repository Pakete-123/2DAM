package semana2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio11 {

  public static void main(String[] args) {

    Path p = Path.of("datos/alumnos_2026.txt");

    try {
      if (Files.exists(p)) {

        Files.delete(p);
        System.out.printf("Fichero %s ha sido eliminado", p);

      } else {

        System.out.printf("El fichero %s no existe", p);

      }
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
