package semana2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio7 {

  public static void main(String[] args) throws IOException {

    Path p = Path.of("datos/alumnos.txt");

    if (!Files.exists(p.getParent())) {
      Files.createDirectories(p.getParent());
    }

    if (!Files.exists(p)) {
      Files.createFile(p);
    }

    System.out.printf("Ruta Original: %s\nRuta Absoluta: %s\nNombre del Fichero: %s\nDirectorio Padre: %s", p,
        p.toAbsolutePath(), p.getFileName(), p.getParent());

  }

}
