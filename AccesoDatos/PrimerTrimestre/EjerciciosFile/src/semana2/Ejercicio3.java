package semana2;

import java.io.File;

public class Ejercicio3 {

  public static void main(String[] args) {

    File f = new File("EjerciciosFile\\src\\semana2\\documentos");

    if (f.exists()) {

      System.out.printf("El directorio ya existe");

    } else {

      System.out.printf("El directorio no existe, creando...");

      try {

        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      f.mkdir();

    }

  }

}
