package semana2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * App
 */
public class RepasoFicheros {

    public static void main(String[] args) {

        File carpeta1 = new File("C:/Users/VIRUS");
        carpeta1.mkdir();

        File archivo1 = new File("../img1.png");
        try {
            if (!archivo1.exists()) {

                archivo1.createNewFile();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Path p = Path.of("PrimerTrimestre/pruebaPath", "path.txt");
        try {

            Files.createDirectories(p.getParent());
            Files.createFile(p);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}