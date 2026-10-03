package opcionales_semana3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Tarea2_1_b {

  public static void main(String[] args) {

    try (BufferedReader bRI = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.print("¿Donde quiere que esté el archivo? ");
      String dir = bRI.readLine();

      System.out.print("¿Cómo quiere que se llame el archivo (con extensión)? ");
      dir = dir.concat("/" + bRI.readLine());

      Path p = Path.of(dir);
      try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

        String str;
        while ((str = bR.readLine()) != null) {

          System.out.println(str);

        }

      } catch (IOException e) {
        System.err.printf("Error de entrada/salida: %s", e.getMessage());
      }
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }

  }

}
