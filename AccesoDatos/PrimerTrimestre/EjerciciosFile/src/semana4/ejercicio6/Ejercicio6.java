package semana4.ejercicio6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ejercicio6 {

  private static final String FILE = "src/semana4/ejercicio6/empleados.dat";

  public static void main(String[] args) {

    ArrayList<Empleado> aLEmpleados = new ArrayList<>();
    aLEmpleados.add(new Empleado(1, "Paloma", "Administración", 1962.53));
    aLEmpleados.add(new Empleado(2, "Pablo", "Hardware", 1835.21));
    aLEmpleados.add(new Empleado(3, "Yesenia", "Desarrollo", 2106.54));
    aLEmpleados.add(new Empleado(4, "Juan", "FullStack", 2386.15));
    aLEmpleados.add(new Empleado(5, "Rafael", "BigData", 3158.20));

    try (ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(FILE))) {

      oOS.writeObject(aLEmpleados);
      System.out.printf("Archivo %s creado correctamente.%n", FILE);

    } catch (IOException e) {
      System.err.printf("Error de escritura en el archivo %s: %s.%n", FILE, e.getMessage());
      return;
    }

    ArrayList<Empleado> aLW;

    try (ObjectInputStream oIS = new ObjectInputStream(new FileInputStream(FILE))) {

      @SuppressWarnings("unchecked")
      ArrayList<Empleado> aL = (ArrayList<Empleado>) oIS.readObject();
      aLW = aL;

    } catch (IOException | ClassNotFoundException e) {
      System.err.printf("Error de lectura en el archivo %s: %s", FILE, e.getMessage());
      return;
    }

    System.out.printf("------> Datos recuperados de %s <------%n", FILE);

    double totalSalario = 0;
    Empleado mejorSueldo = aLW.get(0);

    for (Empleado emp : aLW) {

      System.out.println(emp);
      totalSalario += emp.getSalario();

      if (emp.getSalario() > mejorSueldo.getSalario()) {
        mejorSueldo = emp;
      }
    }

    System.out.printf("Número total de empleados: %d.%n", aLW.size());
    System.out.printf("Salario medio: %.2f%n", totalSalario / aLW.size());
    System.out.printf("Empleado con mejor salario: %s.%n", mejorSueldo);

  }

}
