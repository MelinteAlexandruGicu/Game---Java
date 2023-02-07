package Graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/*! \class ImageLoader
    \brief Clasa ce contine o metoda statica pentru incarcarea unei imagini in memorie.
 */
public class ImageLoader {

    /*! \fn  public static BufferedImage loadImage(String path)
       \brief Incarca o imagine intr-un obiect BufferedImage si returneaza o referinta catre acesta.

       \param path Calea relativa pentru localizarea fisierul imagine.
    */
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
