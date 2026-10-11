package semana4.ejercicio9;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio9 {

  private static final String FILE = "src/semana4/ejercicio9/cursos.dat";

  public static void main(String[] args) {

    Profesor p1 = new Profesor("Victor", "victor@email.com");
    Profesor p2 = new Profesor("Mabel", "mabel@email.com");

    ArrayList<Curso> cursos = new ArrayList<>();
    cursos.add(new Curso("Acceso a Datos", 90, p1));
    cursos.add(new Curso("Programación", 80, p2));
    cursos.add(new Curso("Seguridad en la Red", 60, p1));
    cursos.add(new Curso("Despliegue de Aplicaciones", 70, p2));

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(cursos);
      System.out.printf("Fichero %s creado y escrito correctamente%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error de escritura en el archivo %s: %s", FILE, e.getMessage());
      return;
    }

    ArrayList<Curso> loader;
    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Curso> load = (ArrayList<Curso>) oIS.readObject();
      loader = load;

    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura en el archivo %s: %s", FILE, e.getMessage());
      return;
    }

    System.out.println("------- Lista de Cursos y Profesores -------");
    for (Curso c : loader) {
      System.out.println(c);
    }

  }

}
