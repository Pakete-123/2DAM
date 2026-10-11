package semana4.ejercicio9;

import java.io.Serializable;

public class Profesor implements Serializable {

  private static final long serialVersionUID = 1L;

  private String nombre;
  private String email;

  public Profesor() {
  }

  public Profesor(String nombre, String email) {
    this.nombre = nombre;
    this.email = email;
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

  @Override
  public String toString() {
    return String.format("Profesor [Nombre: %s | Email: %s]", nombre, email);
  }

}
