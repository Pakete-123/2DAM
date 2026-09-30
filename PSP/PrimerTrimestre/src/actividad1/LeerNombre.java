package actividad1;

public class LeerNombre {

  public static void main(String[] args) {

    if (args.length > 0) {
      System.out.printf("Este es el argumento: %s", args[args.length - 1]);
      System.exit(0);
    }

    System.out.println("No hay argumentos");
    System.exit(-1);

  }

}
