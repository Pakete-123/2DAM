package ejerciciosPOO3;

public class Jugador {

  private String nombre;
  private String apellidos;
  private int dorsal;
  private int nGoles;

  public Jugador(String nombre, String apellidos, int dorsal, int nGoles) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.dorsal = dorsal;
    this.nGoles = nGoles;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getapellidos() {
    return apellidos;
  }

  public void setapellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public int getDorsal() {
    return dorsal;
  }

  public void setDorsal(int dorsal) {
    this.dorsal = dorsal;
  }

  public int getnGoles() {
    return nGoles;
  }

  public void setnGoles(int nGoles) {
    this.nGoles = nGoles;
  }

}
