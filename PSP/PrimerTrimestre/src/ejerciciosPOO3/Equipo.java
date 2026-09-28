package ejerciciosPOO3;

import java.util.ArrayList;

public class Equipo {

  private String nombre;
  private String ciudad;
  private ArrayList<Jugador> jugador = new ArrayList<>();

  public Equipo(String nombre, String ciudad, ArrayList<Jugador> jugador) {
    this.nombre = nombre;
    this.ciudad = ciudad;
    this.jugador = jugador;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public ArrayList<Jugador> getJugador() {
    return jugador;
  }

  public void setJugador(ArrayList<Jugador> jugador) {
    this.jugador = jugador;
  }

  public ArrayList<Jugador> addJugador(ArrayList<Jugador> eq, Jugador j) {

    for (Jugador jI : eq) {

      if (jI.getNombre() != j.getNombre()) {
        
      }

    }
    eq.add(j);

    return eq;
  }

}
