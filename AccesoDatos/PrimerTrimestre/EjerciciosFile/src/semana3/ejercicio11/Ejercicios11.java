package semana3.ejercicio11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Ejercicios11 {

  public static void main(String[] args) {

    Path p = Path.of("src/alumnos.csv");
    ArrayList<Alumno> aL = new ArrayList<>();

    try (BufferedReader bR = new BufferedReader(new FileReader(p.toFile()))) {

      String str = bR.readLine();
      while ((str = bR.readLine()) != null) {

        Alumno al = new Alumno();

        if (str.isBlank()) {
          continue;
        }

        String[] palabras = str.split(";");

        int id = Integer.parseInt(palabras[0]);
        String name = palabras[1];
        int age = Integer.parseInt(palabras[2]);
        String course = palabras[3];

        al.setId(id);
        al.setName(name);
        al.setAge(age);
        al.setCourse(course);

        aL.add(al);

      }

    } catch (IOException e) {
      System.err.printf("Error de I/O: %s", e.getMessage());
    }

    int i = 1;
    for (Alumno alumno : aL) {

      System.out.printf("Nº: %d %s%n", i, alumno);
      i++;

    }

  }

}
