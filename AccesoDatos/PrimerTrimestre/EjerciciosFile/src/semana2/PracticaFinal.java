package semana2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PracticaFinal {

  public static void crearCarpeta(Path dir) {

    try {

      if (!Files.exists(dir)) {

        Files.createDirectories(dir);
        System.out.printf("El directorio %s se ha creado correctamente", dir);

      } else {

        System.out.printf("El directorio %s ya existe", dir);

      }

    } catch (IOException e) {
      // TODO: handle exception
    }

  }

  public static void main(String[] args) {

    Path dir = Path.of("almacen");

    crearCarpeta(dir);

  }

}
