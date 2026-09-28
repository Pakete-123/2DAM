package semana2;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio8 {

  public static void main(String[] args) throws IOException {

    Path p = Path.of("datos/alumnos.txt");

    if (!Files.exists(p.getParent())) {
      Files.createDirectories(p.getParent());
      System.out.printf("Se ha creado el directorio\n");
    } else {
      System.out.printf("Ya existe el directorio\n");
    }

    if (!Files.exists(p)) {
      Files.createFile(p);
      System.out.printf("Se ha creado el fichero");
    } else {
      System.out.printf("Ya existe el fichero");
    }

  }

}
