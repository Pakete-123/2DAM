package semana4.ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio11 {

  private static final String FILE = "src/semana4/ejercicio11/clientes_backup.dat";

  public static void menu() {
    System.out.println("===== MENÚ =====");
    System.out.println("1. Añadir Cliente.");
    System.out.println("2. Mostrar Clientes.");
    System.out.println("3. Buscar Cliente.");
    System.out.println("4. Eliminar Cliente.");
    System.out.println("5. Guardar Copia de Seguridad.");
    System.out.println("6. Cargar Copia de Seguridad.");
    System.out.println("0. Salir.");
  }

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

    } catch (IOException e) {
      System.err.printf("Error de Entrada/Salida: %s", e.getMessage());
      return;
    }

    System.out.println("Ha salido del programa.");

  }

}
