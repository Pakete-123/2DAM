package semana2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Ejercicio12 {

  public static void main(String[] args) {

    Path p = Path.of("no_existe/boleto_ganador.bin");

    try {
      Files.createFile(p);
    } catch (IOException e) {
      System.err.println("Error capturado.");
      e.printStackTrace();
    }

  }

}
