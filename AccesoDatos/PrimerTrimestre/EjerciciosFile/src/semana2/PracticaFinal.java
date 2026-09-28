package semana2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class PracticaFinal {

  private final static Path DIR = Path.of("almacen");

  public static void crearCarpeta(Path DIR) {

    try {

      if (!Files.exists(DIR)) {

        Files.createDirectories(DIR);
        System.out.printf("El directorio '%s' se ha creado correctamente", DIR);

      } else {

        System.out.printf("El directorio %s ya existe", DIR);

      }

    } catch (IOException e) {
      System.out.print("Error de entrada/salida");
      System.err.println(e.getMessage());
    }

  }

  public static void crearFichero(BufferedReader bR, Path DIR) {

    try {

      System.out.print("Dime como quieres que se llame el archivo (la extensión será .txt): ");
      String file = bR.readLine().concat(".txt");

      if (file.isBlank() || file == null) {

        System.out.print("Nombre no válido.");
        return;

      }

      Path p = DIR.resolve(file).normalize();

      if (!p.startsWith(DIR)) {

        System.out.print("El archivo debe estar dentro de 'almacén'.");
        return;

      } else {

        Files.createFile(p);

      }

    } catch (IOException e) {

      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());

    } catch (InvalidPathException e) {
      System.out.printf("Nombre de archivo con caracteres no válidos");
    }

  }

  public static void listar(Path DIR) {

    try (Stream<Path> p = Files.walk(DIR)) {

      p.skip(1).forEach(pp -> {

        if (Files.isDirectory(pp)) {

          System.out.printf("[DIR] %s\n", pp.getFileName());

        } else {

          System.out.printf("[FILE] %s\n", pp.getFileName());

        }
      });

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }

  }

  public static void info(BufferedReader bR, Path DIR) {

    try {

      System.out.print("Dime el fichero del que quiera información: ");
      String file = bR.readLine();
      Path p = DIR.resolve(file).normalize();

      System.out.printf("Ruta Original: %s\nRuta Absoluta: %s\nNombre del Fichero: %s\nDirectorio Padre: %s\n", p,
          p.toAbsolutePath(), p.getFileName(), p.getParent());

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }

  }

  public static void copiar(BufferedReader bR, Path DIR) {

    try {

      System.out.print("Nombre del archivo a copiar sin extensión: ");
      String copy = bR.readLine();

      if (copy == null || copy.isBlank()) {

        System.out.println("Nombre no válido");
        return;

      }

      Path origin = DIR.resolve(copy.concat(".txt")).normalize();
      Path dest = DIR.resolve(copy.concat("_copy.txt")).normalize();

      Files.copy(origin, dest);
      System.out.printf("Copia creada: %s", dest.getFileName());

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }

  }

  public static void renombrar(BufferedReader bR, Path DIR) {

    try {
      System.out.print("Dime que archivo quieres renombrar (sin extensión): ");
      String original = bR.readLine().concat(".txt");
      Path source = DIR.resolve(original).normalize();

      System.out.print("¿Cómo quieres que se llame? ");
      String rn = bR.readLine().concat(".txt");
      Path target = DIR.resolve(rn).normalize();

      Files.move(source, target);

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }
  }

  public static void eliminar(BufferedReader bR, Path DIR) {
    try {

      System.out.print("Dame el nombre del fichero que quieras eliminar sin la extensión: ");
      String name = bR.readLine().concat(".txt");

      if (name.isBlank() || name == null) {

        System.out.println("Nombre no válido.");
        return;

      }

      Path p = DIR.resolve(name).normalize();

      if (!Files.exists(p)) {

        System.out.println("No existe el fichero.");
        return;

      } else {

        Files.delete(p);

      }

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }

  }

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));) {

      int val = 0;

      do {

        System.out.println(
            "1. Crear carpeta 'almacen'.\n2. Crear un fichero vacío.\n3. Listar contenido.\n4. Mostrar información de un fichero.\n5. Copiar un fichero.\n6. Renombrar/mover un fichero.\n7. Eliminar un fichero.\n0. Salir");
        try {
          val = Integer.parseInt(bR.readLine());
        } catch (NumberFormatException e) {
          System.err.println("Error: introduce un número");
          e.getMessage();
          val = -1;
        }

        switch (val) {
          case 1:
            crearCarpeta(DIR);
            break;

          case 2:
            crearFichero(bR, DIR);
            break;

          case 3:
            listar(DIR);
            break;

          case 4:
            info(bR, DIR);
            break;

          case 5:
            copiar(bR, DIR);
            break;

          case 6:
            renombrar(bR, DIR);
            break;

          case 7:
            eliminar(bR, DIR);
            break;

          case 0:
            val = 0;
            System.out.println("Ha cerrado el programa.");
            break;

          default:
            System.out.println("Introduce un valor propuesto.");
            break;
        }

      } while (val != 0);

    } catch (IOException e) {
      System.out.println("Error de entrada/salida");
      System.err.println(e.getMessage());
    }
  }

}
