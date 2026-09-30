package semana3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class Ejercicio13 {

  public static void main(String[] args) {

    Path p = Path.of("src/fichero_especial.txt");

    try (BufferedWriter bW = new BufferedWriter(new FileWriter(p.toFile(), StandardCharsets.UTF_8));
        BufferedReader bR = new BufferedReader(new FileReader(p.toFile(), StandardCharsets.UTF_8))) {

      bW.write("Este fichero es especial, ¡Tiene tildes, tío! Además puedo escribir la ñ e interrogaciones");
      bW.flush();

      String str;
      while ((str = bR.readLine()) != null) {

        System.out.println(str);

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

  }

}
