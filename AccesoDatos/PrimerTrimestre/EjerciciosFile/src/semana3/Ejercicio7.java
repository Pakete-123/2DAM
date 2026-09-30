package semana3;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ejercicio7 {

  public static void main(String[] args) {

    Path p = Path.of("src/alumnos.csv");
    List<String> lS = List.of(
        "id;nombre;edad;ciclo",
        "1;Víctor González;21;TEGU 2",
        "2;Iván Robles;21;SEA 2",
        "3;Paloma Aguilar;21;AFF 2",
        "4;Juan Atahona;22;DAM 2",
        "5;Yesenia Toro;22;DAM 2",
        "6;Pablo Torrecilla;21;DAM 2");

    try {

      Files.write(p, lS, StandardCharsets.UTF_8);
      System.out.printf("Archivo CSV creado: %s", p.toAbsolutePath());

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());

    }

  }

}
