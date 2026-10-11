package semana4.ejercicio10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Ejercicio10 {

  private static final String FILE = "src/semana4/ejercicio10/user.dat";

  public static void main(String[] args) {

    Usuario user = new Usuario("Pablo", "pablo@email.com", "pass1234");
    System.out.printf("Usuario antes de guardar: %s%n", user);
    System.out.printf("Contraseña del usuario antes de guardar: %s%n", user.getPassword());

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(user);
      System.out.printf("Fichero %s creado y escrito correctamente%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error de escritura en el fichero %s: %s", FILE, e.getMessage());
      return;
    }

    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      Usuario loader = (Usuario) oIS.readObject();
      System.out.printf("Usuario cargado: %s%n", loader);
      System.out.printf("Contraseña del usuario tras cargar: %s%n", loader.getPassword());

    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura en el fichero %s: %s", FILE, e.getMessage());
    }
  }
}
