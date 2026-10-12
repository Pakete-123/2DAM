package ejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

/**
 * Ejecuta el programa de la suma {link @Main} y le envía los datos por un
 * stream
 * Launcher
 */
public class Launcher {

  /**
   * Posición del primer número introducido por argumentos
   */
  private static final int ARG1 = 0;
  /**
   * Posición del segundo número introducido por argumentos
   */
  private static final int ARG2 = 1;
  /**
   * Código de error para el System.exit() cuando los argumentos no son correctos
   */
  private static final int EXIT_ERROR = 2;
  /**
   * Nombre completo de la clase hija
   */
  private static final String HIJA = Main.class.getName();

  /**
   * Se construye el proceso hijo. Se fuerza UTF-8 en la salida del hijo
   * (-Dst....encoding=UTF-8) para poder leerla siempre con la misma codificación.
   * pb.redirectErrorStream(true) para redirigir los mensajes de error del hijo al
   * stream del padre
   * 
   * @param arg1 Primer número
   * @param arg2 Segundo número
   * @return devuelve el ProcessBuilder configurado
   */
  private static ProcessBuilder crearProceso(String arg1, String arg2) {
    /**
     * Busca el ejecutable java (System.getProperty("java.home")) y se unen las
     * partes (bin y java). Se convierte en String para que se ejecute con la misma
     * instalación que el padre, evitando errores de version.
     */
    String java = Path.of(System.getProperty("java.home"), "bin", "java").toString();

    /**
     * Se recoge el java.class.path para encontrar el hijo
     */
    String classPath = System.getProperty("java.class.path");

    /**
     * Construye la lista de comando con new ProcessBuilder(...). Se construye de la
     * siguiente manera: programa -> argumentos, como codificaciones, paths y
     * números
     */
    ProcessBuilder pb = new ProcessBuilder(java, "-Dstdout.encoding=UTF-8", "-Dstderr.encoding=UTF-8", "-cp", classPath,
        HIJA, arg1, arg2);

    /**
     * Redirige los errores del hijo por el mismo stream que el padre
     */
    pb.redirectErrorStream(true);

    /**
     * Devuelve el ProcessBuilder ya construido
     */
    return pb;
  }

  /**
   * Muestra por pantalla lo que el proceso hijo escribe por su salida
   * 
   * @param p proceso hijo iniciado
   * @throws IOException si falla al lectura del Stream
   */
  private static void salida(Process p) throws IOException {
    try (BufferedReader bR = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8))) {

      String line;
      while ((line = bR.readLine()) != null) {
        System.out.printf("[Main] %s%n", line);
      }
    }
  }

  public static void main(String[] args) {

    if (args.length < 2) {
      System.err.println("Uso: java ejercicio.Launcher <número1> <número2>");
      System.exit(EXIT_ERROR);
    }

    try {
      Process p = crearProceso(args[ARG1], args[ARG2]).start();

      salida(p);

      int code = p.waitFor();
      System.out.printf("El programa de suma ha terminado con código de salida %d%n", code);

    } catch (IOException e) {
      System.err.printf("Error de entrada/salida con el proceso hijo: %s%n", e.getMessage());
      System.exit(EXIT_ERROR);
    } catch (InterruptedException e) {
      /**
       * Thread.currentThread().interrupt() -> Esto hace que el hilo restaure la
       * marca de Interrumpido, que la excepción borra. Así, si otro código pregunta
       * si se ha interrumpido devolvería true y no se perdería es información
       */
      Thread.currentThread().interrupt();

      System.err.println("Se ha interrumpido la espera del proceso hijo.");
      System.exit(EXIT_ERROR);
    }

  }

}
