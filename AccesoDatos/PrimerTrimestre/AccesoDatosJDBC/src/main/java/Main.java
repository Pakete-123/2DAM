import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Main {
  public static void main(String[] args) {
    String url = "jdbc:mysql://192.168.56.10:3306/instituto";
      String usuario = System.getenv("DB_USER");
      String password = System.getenv("DB_PASSWORD");
      try (Connection conexion =
        DriverManager.getConnection(url, usuario, password)) {
        System.out.println("Conexión correcta con MySQL");
        System.out.println("Base de datos: " + conexion.getCatalog());
      } catch (SQLException e) {
        System.err.printf("Error de conexión: %s%n", e.getMessage());
    }
  }
}
