package continuacionRepaso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

  final static String[] NOMBRES = { "Alpha", "Beta", "Gamma", "Delta", "Epsilon", "Zeta", "Eta", "Theta", "Iota",
      "Kappa", "Lambda" };
  final static int SIZE = 6;

  public static int numeroI() {
    return (int) (Math.random() * NOMBRES.length);
  }

  public static double numeroD() {
    return (double) (Math.random() * 10);
  }

  public static void main(String[] args) {

    ArrayList<Alumno> aL = new ArrayList<>();

    try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

      System.out.printf("Cuántos alumnos generados aleatoriamente quieres? ");
      int n = Integer.parseInt(bR.readLine());

      for (int i = 0; i < n; i++) {
        aL.add(new Alumno(numeroD(), NOMBRES[numeroI()]));
      }

      double sumaNotas = 0;
      for (Alumno a : aL) {

        sumaNotas = sumaNotas + a.getNota();

      }

      double media = sumaNotas / aL.size();

      System.out.printf("La media de los %d alumnos es: %.2f.%nEl nombre de los alumnos analizados es: ", n, media);

      for (int i = 0; i < aL.size(); i++) {
        System.out.print(aL.get(i).getNombre() + (i < aL.size() - 1 ? ", " : ". "));

      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
