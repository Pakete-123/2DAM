package semana4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {

  private static final String FILE = "src/semana4/productos.dat";

  public static void main(String[] args) {

    boolean found = false;

    try (DataInputStream dIS = new DataInputStream(new FileInputStream(FILE));
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.printf("Dame el código del producto del archivo %s.", FILE);
      int search = Integer.parseInt(bR.readLine());

      while (!found) {
        int code = dIS.readInt();
        String name = dIS.readUTF();
        double price = dIS.readDouble();
        int stock = dIS.readInt();

        if (search == code) {

          found = true;

        }

      }

    } catch (EOFException e) {
    } catch (FileNotFoundException e) {
      System.err.printf("No existe el fichero %s. Ejecuta el Ejercicio3.", FILE);
    } catch (IOException e) {
      System.err.printf("Error al leer el fichero: %s%n", e.getMessage());
    }

  }

}
