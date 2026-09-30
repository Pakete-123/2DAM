package semana3.ejercicio11_12;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio12 {

  public static void main(String[] args) {

    Path p = Path.of("src/salida_alumnos.csv");
    List<Alumno> l = new ArrayList<>();
    try (BufferedWriter bR = new BufferedWriter(new FileWriter(p.toFile()))) {

      Alumno a1 = new Alumno(1, "Ana Lopez", 21, "2DAM");
      Alumno a2 = new Alumno(2, "Carlos Gomez", 19, "1DAM");
      Alumno a3 = new Alumno(3, "Marta Sanchez", 22, "2DAM");
      Alumno a4 = new Alumno(4, "Lucas Fernandez", 20, "1DAM");
      Alumno a5 = new Alumno(5, "Sofia Ruiz", 23, "2DAM");

      l.add(a1);
      l.add(a2);
      l.add(a3);
      l.add(a4);
      l.add(a5);

      bR.write("id;nombre;edad;curso");
      bR.newLine();

      for (Alumno alumno : l) {

        bR.write(String.format("%d;%s;%d;%s", alumno.getId(), alumno.getName(), alumno.getAge(), alumno.getCourse()));
        bR.newLine();

      }

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }
  }

}