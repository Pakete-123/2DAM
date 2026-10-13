package semana4.ejercicio12;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio12 {

  private static final String FILE = "src/semana4/ejercicio12/alumnos_serializados.dat";
  private static final ArrayList<Alumno> ALUMNOS = new ArrayList<>();
  private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

  private static boolean active = true;

  private static void menu() {
    System.out.println("==== MENU ====");
    System.out.println("1. Añadir Alumno");
    System.out.println("2. Mostrar Todos los Alumnos");
    System.out.println("3. Buscar Alumno por Expediente");
    System.out.println("4. Mostrar Alumnos Aprobados");
    System.out.println("5. Mostrar Alumno con Mayor Nota Media");
    System.out.println("6. Eliminar Alumno");
    System.out.println("7. Guardar Datos");
    System.out.println("8. Cargar Datos");
    System.out.println("0. Salir");
    System.out.print("Introduce una opción: ");
  }

  private static boolean estaVacio() {
    if (ALUMNOS.isEmpty()) {
      System.out.println("No hay ningún alumno almacenado aún.");
      return true;
    }

    return false;
  }

  private static void anadirAlumno() throws IOException {

    System.out.println("---- Nuevo Alumno ----");
    System.out.print("Introduce el número de expediente del alumno nuevo: ");
    int exp = Integer.parseInt(BR.readLine());

    if (!ALUMNOS.isEmpty()) {
      for (Alumno al : ALUMNOS) {
        if (al.getNumeroExpediente() == exp) {
          System.out.printf("Ya existe un alumno con ese número de expediente: %s", al);
          return;
        }
      }
    }

    System.out.print("Introduce el nombre: ");
    String name = BR.readLine();

    System.out.print("Introduce los apellidos: ");
    String lName = BR.readLine();

    System.out.print("Introduce el ciclo: ");
    String cycle = BR.readLine();

    System.out.print("Introduce la nota media: ");
    double mGrade = Double.parseDouble(BR.readLine());

    ALUMNOS.add(new Alumno(exp, name, lName, cycle, mGrade));
    System.out.println("Alumno añadido correctamente");
  }

  private static void mostrarAlumnos() {

    if (estaVacio())
      return;

    for (Alumno al : ALUMNOS) {
      System.out.println(al);
    }
  }

  private static void buscarAlumno() throws IOException {

    if (estaVacio())
      return;

    System.out.print("Introduce el expediente a buscar: ");
    int search = Integer.parseInt(BR.readLine());

    for (Alumno al : ALUMNOS) {
      if (al.getNumeroExpediente() == search) {
        System.out.println("---- Alumno Buscado ----");
        System.out.println(al);
        return;
      }
    }

    System.out.println("No hay ningún alumno con ese número de expediente.");
  }

  private static void mostrarAprobados() {

    if (estaVacio())
      return;

    System.out.println("---- Alumnos Aprobados ----");
    for (Alumno al : ALUMNOS) {
      if (al.getNotaMedia() >= 5) {
        System.out.println(al);
      }
    }
  }

  private static void mayorNota() {

    if (estaVacio())
      return;

    System.out.println("---- Mayor Nota ----");
    Alumno mayorNota = ALUMNOS.get(0);
    for (Alumno al : ALUMNOS) {
      if (al.getNotaMedia() > mayorNota.getNotaMedia()) {
        mayorNota = al;
      }
    }

    System.out.printf("El alumno con mayor nota media es: %s%n", mayorNota);
  }

  private static void eliminar() throws IOException {

    if (estaVacio()) {
      return;
    }

    System.out.println("---- Eliminar Alumno ----");
    System.out.print("Introduce el número de expediente: ");
    int exp = Integer.parseInt(BR.readLine());

    for (Alumno al : ALUMNOS) {
      if (al.getNumeroExpediente() == exp) {
        ALUMNOS.remove(al);
        System.out.println("Se ha eliminado correctamente el alumno.");
        return;
      }
    }

    System.out.println("No se ha encontrado ningún alumno con ese número de expediente.");
  }

  private static void guardar() {

    System.out.println("---- Guardar Datos ----");
    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(ALUMNOS);
      System.out.println("Fichero creado y escrito correctamente");
    } catch (IOException e) {
      System.err.printf("Error de escritura del fichero: %s%n", e.getMessage());
    }

  }

  private static void cargar() {

    System.out.println("---- Cargar Datos ----");
    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Alumno> load = (ArrayList<Alumno>) oIS.readObject();
      ALUMNOS.clear();
      ALUMNOS.addAll(load);
      System.out.println("Se han cargado los datos correctamente.");
    } catch (FileNotFoundException e) {
      System.err.printf("No se encontró el archivo: %s%n", e.getMessage());
    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura del fichero: %s%n", e.getMessage());
    }

  }

  public static void main(String[] args) {

    int opt;

    do {
      try (BR) {
        menu();
        opt = Integer.parseInt(BR.readLine());

        switch (opt) {
          case 1 -> anadirAlumno();
          case 2 -> mostrarAlumnos();
          case 3 -> buscarAlumno();
          case 4 -> mostrarAprobados();
          case 5 -> mayorNota();
          case 6 -> eliminar();
          case 7 -> guardar();
          case 8 -> cargar();
          case 0 -> active = !active;
          default -> System.out.println("Introduce un valor válido.");
        }

      } catch (NumberFormatException | IOException e) {
        System.err.printf("Error: introduce un número válido (%s).%n", e.getMessage());
      }
    } while (active);

    System.out.println("Ha salido del programa.");
  }

}
