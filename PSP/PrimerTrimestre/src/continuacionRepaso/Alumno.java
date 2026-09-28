package continuacionRepaso;

public class Alumno {

  private double nota;
  private String nombre;

  public Alumno(double nota, String nombre) {
    this.nota = nota;
    this.nombre = nombre;
  }

  public double getNota() {
    return nota;
  }

  public void setNota(double nota) {
    this.nota = nota;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

}
