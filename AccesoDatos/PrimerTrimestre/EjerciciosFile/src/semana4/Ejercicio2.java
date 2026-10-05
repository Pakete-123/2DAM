package semana4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

  private static final String FILE = "src/semana4/alumnos.dat";

  public static void main(String[] args) {

    System.out.print("Introduce 5 alumnos.\n");
    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        DataOutputStream dOS = new DataOutputStream(new FileOutputStream(FILE))) {

      for (int i = 0; i < 5; i++) {

        System.out.printf("Alumno %d: ", i + 1);

        System.out.print("Expediente: ");
        dOS.writeInt(Integer.parseInt(bR.readLine()));

        System.out.print("Nombre: ");
        dOS.writeUTF(bR.readLine());

        System.out.print("Edad: ");
        dOS.writeInt(Integer.parseInt(bR.readLine()));

        System.out.print("Nota media: ");
        dOS.writeDouble(Double.parseDouble(bR.readLine()));

      }

    } catch (IOException e) {
      System.err.printf("Error al escribir en el fichero %s: %s%n", FILE, e.getMessage());
      return;
    }

    try (DataInputStream dIS = new DataInputStream(new FileInputStream(FILE))) {

      while (true) {

        int exp = dIS.readInt();
        String name = dIS.readUTF();
        int age = dIS.readInt();
        double mMark = dIS.readDouble();
        System.out.printf("Expediente: %d%nNombre: %s%nEdad: %d%nNota media: %.2f%n-------------%n", exp, name, age,
            mMark);

      }
    } catch (EOFException e) {
      System.out.printf("Fin del fichero alcanzado.%n");
    } catch (IOException e) {
      System.err.printf("Error de lectura del fichero %s: %s%n", FILE, e.getMessage());
    }

  }

}
