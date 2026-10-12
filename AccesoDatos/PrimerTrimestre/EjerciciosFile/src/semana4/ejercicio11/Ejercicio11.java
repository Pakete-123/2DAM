package semana4.ejercicio11;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio11 {

  private static final String FILE = "src/semana4/ejercicio11/clientes_backup.dat";
  private static final ArrayList<Cliente> AL = new ArrayList<>();

  private static boolean menu = true;

  private static void menu() {
    System.out.println("\n===== MENÚ =====");
    System.out.println("1. Añadir Cliente.");
    System.out.println("2. Mostrar Clientes.");
    System.out.println("3. Buscar Cliente.");
    System.out.println("4. Eliminar Cliente.");
    System.out.println("5. Guardar Copia de Seguridad.");
    System.out.println("6. Cargar Copia de Seguridad.");
    System.out.println("0. Salir.");
    System.out.print("Introduce una opción: ");
  }

  private static void aniadirCliente(BufferedReader bR) throws IOException {

    System.out.println("\n----- Creación de un Cliente -----");
    System.out.print("- Introduce el código: ");
    int code = Integer.parseInt(bR.readLine());

    for (Cliente cl : AL) {
      if (cl.getCodigo() == code) {
        System.out.printf("El cliente ya está guardado: %s%n", cl);
        return;
      }
    }

    System.out.print("- Introduce el nombre: ");
    String name = bR.readLine();

    System.out.print("- Introduce el número de teléfono: ");
    int tlf = Integer.parseInt(bR.readLine());

    System.out.print("- Introduce el email: ");
    String email = bR.readLine();

    System.out.print("- Introduce el saldo pendiente: ");
    double currency = Double.parseDouble(bR.readLine());

    AL.add(new Cliente(code, name, tlf, email, currency));
    System.out.println("Cliente añadido.");
  }

  private static void mostrarClientes() {

    if (AL.isEmpty()) {
      System.out.println("No hay ningún cliente almacenado.");
      return;
    }

    System.out.println("\n----- Clientes Guardados -----");
    for (Cliente cl : AL) {
      System.out.println(cl);
    }
  }

  private static void buscarCliente(BufferedReader bR) throws IOException {

    System.out.println("----- Buscar Cliente -----");
    System.out.print("Introduce el código del cliente: ");
    int code = Integer.parseInt(bR.readLine());

    for (Cliente cl : AL) {
      if (cl.getCodigo() == code) {
        System.out.println(cl);
        return;
      }
    }

    System.out.printf("No se ha encontrado un cliente con el código %d.%n", code);
  }

  private static void eliminarCliente(BufferedReader bR) throws IOException {

    System.out.println("\n----- Eliminar Cliente -----");
    System.out.print("Introduce el código del cliente: ");
    int code = Integer.parseInt(bR.readLine());

    for (Cliente cl : AL) {
      if (cl.getCodigo() == code) {
        AL.remove(cl);
        System.out.printf("Se ha eliminado el cliente con el código %d.%n", code);
        return;
      }
    }

    System.out.printf("No se ha encontrado un cliente con el código %d.%n", code);
  }

  private static void guardarCopia() {

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(AL);
      System.out.printf("Fichero %s creado y escrito correctamente.%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error de escritura en el archivo %s: %s%n", FILE, e.getMessage());
    }
  }

  private static void cargarCopia() {

    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Cliente> load = (ArrayList<Cliente>) oIS.readObject();
      AL.clear();
      AL.addAll(load);
      System.out.println("Se ha cargado la copia de seguridad.");

    } catch (FileNotFoundException e) {
      System.err.printf("No se ha encontrado el archivo %s: %s.%n", FILE, e.getMessage());
    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura en el archivo %s: %s.%n", FILE, e.getMessage());
    }
  }

  public static void main(String[] args) {

    int input;

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
      do {

        menu();
        input = Integer.parseInt(bR.readLine());

        switch (input) {

          case 1 -> aniadirCliente(bR);

          case 2 -> mostrarClientes();

          case 3 -> buscarCliente(bR);

          case 4 -> eliminarCliente(bR);

          case 5 -> guardarCopia();

          case 6 -> cargarCopia();

          case 0 -> menu = !menu;

          default -> System.out.println("Introduce un valor válido.");
        }

      } while (menu);

    } catch (IOException e) {
      System.err.printf("Error de Entrada/Salida: %s", e.getMessage());
      return;
    }

    System.out.println("Ha salido del programa.");

  }

}
