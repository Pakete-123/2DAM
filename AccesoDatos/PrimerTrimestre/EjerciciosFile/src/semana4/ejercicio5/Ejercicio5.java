package semana4.ejercicio5;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio5 {

  private static final String FILE = "src/semana4/ejercicio5/personas.dat";

  public static void main(String[] args) {

    Persona[] ps = {
        new Persona("Juan", "Atahona", 22, "123456789J"),
        new Persona("Yesenia", "Toro", 22, "123456789Y"),
        new Persona("Pablo", "Torrecilla", 21, "123456789P"),
    };

    try (ObjectOutputStream oIS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      for (Persona p : ps) {
        oIS.writeObject(p);
      }
      System.out.printf("Fichero %s creado correctamente.%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error de Escritura en el archivo %s%n.", e.getMessage());
      return;
    }

    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      while (true) {

        Persona p = (Persona) oIS.readObject();
        System.out.println(p);

      }

    } catch (EOFException e) {
      System.out.printf("Fichero leído correctamente.");
    } catch (IOException e) {
      System.err.printf("Error de Lectura en el archivo %s%n.");
    } catch (ClassNotFoundException e) {
      System.err.println("Error: Clase no encontrada.");
    }

  }

}
