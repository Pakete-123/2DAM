package semana4.ejercicio10;

import java.io.Serializable;

public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nombre;
  private String email;

  // Transient indica que NO forma parte del serializado.
  // Al serializar, este atributo se completa con su valor por defecto, en este
  // caso null porque es un String, ya que Java no encuentra un valor guardado
  // para el atributo, consiguiendo que la contraseña no llegue al fichero.
  private transient String password;

  public Usuario() {
  }

  public Usuario(String nombre, String email, String password) {
    this.nombre = nombre;
    this.email = email;
    this.password = password;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    String pass = (password != null) ? "*".repeat(password.length()) : "(No almacenada)";
    return String.format("Nombre: %s | Email: %s | Contraseña: %s", nombre, email, pass);
  }

}
