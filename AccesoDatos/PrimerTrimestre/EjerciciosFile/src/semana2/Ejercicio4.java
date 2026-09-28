package semana2;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio4 {

  public static void main(String[] args) throws IOException {

    String father = "proyecto";
    String[] directories = { "datos", "copias", "informes" };

    for (String carpeta : directories) {
      File f = new File(father, carpeta);
      f.mkdirs();
    }

    for (String carpeta : directories) {

      Path p = Path.of(father, carpeta);
      Files.createDirectories(p);

    }

  }

}
