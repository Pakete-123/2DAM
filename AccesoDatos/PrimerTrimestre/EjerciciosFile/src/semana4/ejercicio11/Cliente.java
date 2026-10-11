package semana4.ejercicio11;

import java.io.Serializable;

public class Cliente implements Serializable {

  private static final long serialVersionUID = 1L;

  private int codigo;
  private String nombre;
  private int telefono;
  private String email;
  private double saldoPendiente;

  public Cliente() {
  }

  public Cliente(int codigo, String nombre, int telefono, String email, double saldoPendiente) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.telefono = telefono;
    this.email = email;
    this.saldoPendiente = saldoPendiente;
  }

  public int getCodigo() {
    return codigo;
  }

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getTelefono() {
    return telefono;
  }

  public void setTelefono(int telefono) {
    this.telefono = telefono;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public double getSaldoPendiente() {
    return saldoPendiente;
  }

  public void setSaldoPendiente(double saldoPendiente) {
    this.saldoPendiente = saldoPendiente;
  }

  @Override
  public String toString() {
    return String.format("Cliente: Código: %d | Nombre: %s | Teléfono: %d | Email: %s | Saldo Pendiente: %.2f", codigo,
        nombre, telefono, email, saldoPendiente);
  }

}
