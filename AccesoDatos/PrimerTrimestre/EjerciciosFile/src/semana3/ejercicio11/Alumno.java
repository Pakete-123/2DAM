package semana3.ejercicio11;

public class Alumno {

  private int id;
  private String name;
  private int age;
  private String course;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCourse() {
    return course;
  }

  public void setCourse(String course) {
    this.course = course;
  }

  @Override
  public String toString() {
    return "Alumno [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + "]";
  }

}
