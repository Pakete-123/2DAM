package ejercicio1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Ejercicio1 {

  private static final File FILE = new File("catalogo_libros.xml");
  private static final int ERR_GRAL = 1;

  public static void main(String[] args) {

    if (!FILE.isFile()) {
      System.err.printf("No existe el archivo %s", FILE);
      System.exit(ERR_GRAL);
    }

    if (!FILE.canRead()) {
      System.err.printf("No se puede leer el archivo %s", FILE);
      System.exit(ERR_GRAL);
    }

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(FILE);

      NodeList lista = doc.getElementsByTagName("libro");

      for (int i = 0; i < lista.getLength(); i++) {
        Element element = (Element) lista.item(i);

        String id = element.getAttribute("id");
        String titulo = element.getElementsByTagName("titulo").item(0).getTextContent();
        String autor = element.getElementsByTagName("autor").item(0).getTextContent();
        double precio = Double.parseDouble(element.getElementsByTagName("precio").item(0).getTextContent());

        System.out.printf("ID: %s | Título: %s | Autor: %s | Precio: %.2f %n", id, titulo, autor, precio);
      }

    } catch (SAXException e) {
      System.err.println("Error: el XML no tiene un formato válido");
      System.exit(ERR_GRAL);
    } catch (IOException e) {
      System.err.println("Error de entrada/salida");
      System.exit(ERR_GRAL);
    } catch (ParserConfigurationException e) {
      System.err.printf("Error de lectura del fichero XML.");
      System.exit(ERR_GRAL);
    }

  }

}
