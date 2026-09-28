package semana2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Ejercicio9 {

  public static void main(String[] args) {

    Path p = Path.of("datos/alumnos.txt");
    Path copyD = Path.of("copias");
    Path copyF = copyD.resolve("alumnos_backup.txt");

    try {
      Files.createDirectories(copyD);

      Files.copy(p, copyF, StandardCopyOption.REPLACE_EXISTING);

      System.out.printf("Fichero copiado a %s", copyD.toAbsolutePath());

    } catch (IOException e) {
      e.printStackTrace();
    } catch (Exception e) {
      System.out.printf("Error genérico no contemplado individualmente");
    }

  }

}
