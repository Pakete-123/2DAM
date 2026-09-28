package semana2;

import java.io.File;
import java.io.IOException;

public class Ejercicio2 {

  public static void main(String[] args) {

    File f = new File("datos.txt");

    try {
      f.createNewFile();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    System.out.printf(
        "Nombre: %s,\n ruta absoluta: %s,\n ¿existe?: %s,\n ¿es un fichero?: %s,\n ¿es un directorio?: %s,\n tamaño: %s B",
        f.getName(), f.getAbsolutePath(), f.exists() ? "Si" : "No", f.isFile() ? "Si" : "No",
        f.isDirectory() ? "Si" : "No", f.length());

    f.delete();

    

  }

}
