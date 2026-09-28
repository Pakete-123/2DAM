package semana2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio6 {
  private static int d = 0, f = 0;

  public static void main(String[] args) throws IOException {

    Path p = Path.of("");

    Files.walk(p).forEach(pp -> {

      if (Files.isDirectory(pp)) {

        System.out.printf("[DIR] %s\n", pp.getFileName());
        d++;

      } else {

        System.out.printf("[FILE] %s\n", pp.getFileName());
        f++;

      }
    });

    System.out.printf("Directorios: %d,\nFicheros: %d", d, f);

  }

}
