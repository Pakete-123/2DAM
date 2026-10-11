package semana4.ejercicio7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio7 {
  private static boolean menu = true;
  private static final String FILE = "src/semana4/ejercicio7/biblioteca.dat";

  private static void menu() {
    System.out.println();
    System.out.println("===== MENÚ =====");
    System.out.println("1. Añadir Libro");
    System.out.println("2. Mostrar Libros");
    System.out.println("3. Guardar Catálogo");
    System.out.println("4. Cargar Catálogo");
    System.out.println("0. Salir");
    System.out.print("Introduce una opción: ");
  }

  public static void aniadirLibro(ArrayList<Libro> aL, BufferedReader bR) throws IOException {

    System.out.print("ISBN: ");
    String isbn = bR.readLine();

    for (Libro l : aL) {
      if (l.getIsbn().equals(isbn)) {
        System.out.println("Ya existe ese libro.");
        return;
      }
    }

    System.out.print("Titulo: ");
    String titulo = bR.readLine();
    System.out.print("Autor: ");
    String autor = bR.readLine();
    System.out.print("Año de publicación: ");
    int anio = Integer.parseInt(bR.readLine());
    System.out.print("¿Está prestado? (s/n): ");
    char sn = bR.readLine().charAt(0);
    boolean p;
    if (Character.toLowerCase(sn) == "s".charAt(0))
      p = true;
    else if (Character.toLowerCase(sn) == "n".charAt(0))
      p = false;
    else {
      System.out.println("Dato no válido para 'Prestado'. Introduce s/n.");
      return;
    }

    aL.add(new Libro(isbn, titulo, autor, anio, p));
    System.out.println("Libro añadido.");

  }

  private static void mostrarLibros(ArrayList<Libro> aL) {

    if (aL.isEmpty()) {
      System.out.println("El catálogo está vacío.");
      return;
    }

    System.out.println("----> Libros en el catálogo <---- ");
    for (Libro l : aL) {
      System.out.println(l);
    }

  }

  private static void guardarCatalogo(ArrayList<Libro> aL) {

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(aL);
      System.out.printf("Catálogo guardado correctamente en: %s (%d libros)%n", FILE, aL.size());

    } catch (IOException e) {
      System.err.printf("Error al guardar el catálogo %s: %s%n", FILE, e.getMessage());
    }

  }

  private static void cargarCatalogo(ArrayList<Libro> aL) {

    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Libro> loader = (ArrayList<Libro>) oIS.readObject();
      aL.clear();
      aL.addAll(loader);
      System.out.printf("Catálogo cargado correctamente (%d libros)%n", loader.size());

    } catch (FileNotFoundException e) {
      System.err.printf("El archivo %s no ha sido creado aún: %n", FILE, e.getMessage());

    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error al cargar el catálogo %s: %s%n", FILE, e.getMessage());
    }

  }

  public static void main(String[] args) {

    ArrayList<Libro> aL = new ArrayList<>();
    int input;

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

      do {
        menu();
        input = Integer.parseInt(bR.readLine());

        switch (input) {

          case 1 -> aniadirLibro(aL, bR);

          case 2 -> mostrarLibros(aL);

          case 3 -> guardarCatalogo(aL);

          case 4 -> cargarCatalogo(aL);

          case 0 -> menu = !menu;

          default -> {
            System.out.println("Introduce un valor correcto");
            return;
          }
        }

      } while (menu);

    } catch (IOException e) {
      System.err.printf("Error de Entrada/Salida: %s", e.getMessage());
      return;
    }

    System.out.println("Ha salido del programa.");

  }

}
