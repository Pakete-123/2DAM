package semana4.ejercicio8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio8 {

  private static final String FILE = "src/semana4/ejercicio8/vehiculos.dat";
  private static final int KM_LIMIT = 100000;

  public static void main(String[] args) {

    ArrayList<Vehiculo> vehicles = new ArrayList<>();
    boolean neu = true;

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
      do {

        System.out.printf("===> Nuevo vehículo %d%n", vehicles.size() + 1);
        System.out.print("Introduce la matrícula: ");
        String matricula = bR.readLine();

        System.out.print("Introduce la marca: ");
        String marca = bR.readLine();

        System.out.print("Introduce el modelo: ");
        String modelo = bR.readLine();

        System.out.print("Introduce el kilometraje: ");
        int km = Integer.parseInt(bR.readLine());

        System.out.print("Introduce el coste de reparación: ");
        double coste = Double.parseDouble(bR.readLine());

        vehicles.add(new Vehiculo(matricula, marca, modelo, km, coste));

        System.out.print("¿Quiere introducir otro vehículo? (s/n): ");
        char sn;

        do {
          sn = bR.readLine().charAt(0);
          if (Character.toLowerCase(sn) == "s".charAt(0))
            neu = true;
          else if (Character.toLowerCase(sn) == "n".charAt(0))
            neu = false;
          else {
            System.out.println("Introduce un valor válido (s/n).");
          }
        } while (sn != "s".charAt(0) && sn != "n".charAt(0));

      } while (neu);

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida: %s", e.getMessage());
    }

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(vehicles);
      System.out.println("Fichero creado correctamente.");

    } catch (IOException e) {
      System.err.printf("Error de escritura en el archivo %s: %s", FILE, e.getMessage());
      return;
    }

    ArrayList<Vehiculo> loader;
    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Vehiculo> load = (ArrayList<Vehiculo>) oIS.readObject();
      loader = load;

    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura en el archivo %s: %s", FILE, e.getMessage());
      return;
    }

    System.out.println("\n------ Todos los vehículos registrados ------");
    double total = 0;
    Vehiculo masCaro = loader.get(0);
    for (Vehiculo v : loader) {

      System.out.println(v);
      total += v.getCosteReparacion();

      if (v.getCosteReparacion() > masCaro.getCosteReparacion()) {
        masCaro = v;
      }
    }

    System.out.printf("%n------ Vehículos con más de %d km ------%n", KM_LIMIT);
    boolean any = false;
    for (Vehiculo v : loader) {

      if (v.getKilometros() > KM_LIMIT) {

        System.out.println(v);
        any = true;
      }
    }
    if (!any) {
      System.out.println("Ninguno.");
    }

    System.out.printf("%nVehículo con la reparación más cara: %s%n", masCaro);
    System.out.printf("Importe total facturado en reparaciones: %.2f%n", total);
  }

}
