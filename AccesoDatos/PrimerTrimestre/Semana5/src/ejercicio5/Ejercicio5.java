package ejercicio5;

import java.io.File;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Ejercicio5 {

  private static final File XML = new File("catalogo_libros.xml");
  private static final File XSL = new File("src/ejercicio5/catalogo.xsl");
  private static final File HTML = new File("src/ejercicio5/catalogo.html");

  public static void main(String[] args) {

    try {
      TransformerFactory factory = TransformerFactory.newInstance();
      Transformer transformer = factory.newTransformer(new StreamSource(XSL));
      transformer.transform(new StreamSource(XML), new StreamResult(HTML));
      System.out.printf("HTML generado correctamente en %s", HTML.getAbsolutePath());

    } catch (TransformerException e) {
      System.err.printf("Error: %s", e.getMessage());
    }

  }

}
