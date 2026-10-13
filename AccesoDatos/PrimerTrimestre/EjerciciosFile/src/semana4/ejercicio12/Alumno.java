package semana4.ejercicio12;

import java.io.Serializable;

public class Alumno implements Serializable {

  private static final long serialVersionUID = 1L;

  private int numeroExpediente;
  private String nombre;
  private String apellido;
  private String ciclo;
  private double notaMedia;

  public Alumno() {
  }

  public Alumno(int numeroExpediente, String nombre, String apellido, String ciclo, double notaMedia) {
    this.numeroExpediente = numeroExpediente;
    this.nombre = nombre;
    this.apellido = apellido;
    this.ciclo = ciclo;
    this.notaMedia = notaMedia;
  }

  public int getNumeroExpediente() {
    return numeroExpediente;
  }

  public void setNumeroExpediente(int numeroExpediente) {
    this.numeroExpediente = numeroExpediente;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getCiclo() {
    return ciclo;
  }

  public void setCiclo(String ciclo) {
    this.ciclo = ciclo;
  }

  public double getNotaMedia() {
    return notaMedia;
  }

  public void setNotaMedia(double notaMedia) {
    this.notaMedia = notaMedia;
  }

  @Override
  public String toString() {
    return String.format("Número de Expediente: %d | Nombre: %s | Apellidos: %s | Ciclo: %s | Nota Media: %.2f %n",
        numeroExpediente, nombre, apellido, ciclo, notaMedia);
  }

}
