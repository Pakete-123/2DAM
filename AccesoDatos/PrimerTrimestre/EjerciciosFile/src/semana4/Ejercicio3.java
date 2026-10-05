package semana4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {

  private static final String FILE = "src/semana4/productos.dat";

  public static void main(String[] args) {

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dOS = new DataOutputStream(new FileOutputStream(FILE))) {

      while (true) {

        System.out.print("Código de producto. Introduce 0 para salir.");
        int code = Integer.parseInt(bR.readLine());
        if (code == 0)
          break;

        dOS.writeInt(code);

        System.out.print("Nombre : ");
        dOS.writeUTF(bR.readLine());

        System.out.print("Precio: ");
        dOS.writeDouble(Double.parseDouble(bR.readLine()));

        System.out.print("Nº unidades disponibles: ");
        dOS.writeInt(Integer.parseInt(bR.readLine()));

      }

    } catch (IOException e) {
      System.err.printf("Error de escritura en el fichero %s: %s%n", FILE, e.getMessage());
      return;
    }

    int all = 0, totalValue = 0;
    try (DataInputStream dIS = new DataInputStream(new FileInputStream(FILE))) {

      while (true) {

        int code = dIS.readInt();
        String name = dIS.readUTF();
        double price = dIS.readDouble();
        int units = dIS.readInt();
        all++;
        totalValue += (price * units);
        System.out.printf("Código: %d, Nombre: %s, Precio: %.2f, Unidades disponibles: %d%n", code, name, price, units);

      }

    } catch (EOFException e) {
      System.out.printf(" - Total de productos diferentes: %d%n - Valor total del almacén: %.2f%n", all, totalValue);
    } catch (IOException e) {
      System.err.printf("Error de lectura en el fichero %s: %s%n", FILE, e.getMessage());
    }

  }

}
