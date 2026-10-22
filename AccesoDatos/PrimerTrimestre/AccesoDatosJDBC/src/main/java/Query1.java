import java.sql.Connection;
import java.sql.PreparedStatement;

public class Query1 {
  private static final String SQL = "SELECT id, nombre, edad FROM alumnos WHERE ciclo = ? AND edad >= ?";

  public static void main(String[] args) {

    Connection conn = ConnectionDB.getConnection();
    PreparedStatement query =

  }
}
