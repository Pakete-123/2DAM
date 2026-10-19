package ejercicio1;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
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

    } catch (SAXException e) {
      System.err.println("Error: el XML no tiene un formato válido");
      System.exit(ERR_GRAL);
    } catch (IOException e) {
      System.err.println("Error de entrada/salida");
      System.exit(ERR_GRAL);
    } catch (ParserConfigurationException e) {
      System.err.printf("Error ");
    }

  }

}
