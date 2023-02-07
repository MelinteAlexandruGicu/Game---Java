package Graphics;

import java.awt.image.BufferedImage;

/*! \class SpriteSheet
    \brief Clasa retine o referinta catre o imagine formata din dale (sprite sheet)

    Metoda crop() returneaza o dala de dimensiuni fixe (o subimagine) din sprite sheet
    de la adresa (x * latimeDala, y * inaltimeDala)
 */
public class SpriteSheet {
    private BufferedImage sheet; /*!< Referinta catre obiectul BufferedImage ce contine sprite sheet-ul.*/
    private static final int tileWidth = 64; /*!< Latimeaa unei dale din sprite sheet.*/
    private static final int tileHeight = 64;  /*!< Inaltimea unei dale din sprite sheet.*/

    /*! \fn public SpriteSheet(BufferedImage sheet)
            \brief Constructor, initializeaza spriteSheet.

            \param buffImg Un obiect BufferedImage valid.
         */
    public SpriteSheet(BufferedImage sheet) {
        this.sheet = sheet;
    }

    /*! \fn public BufferedImage crop(int x, int y)
        \brief Returneaza un obiect BufferedImage ce contine o subimage (dala).

        Subimaginea este localizata avand ca referinta punctul din stanga sus.

        \param x numarul dalei din sprite sheet pe axa x.
        \param y numarul dalei din sprite sheet pe axa y.
     */
    public BufferedImage crop(int x, int y) {
        return sheet.getSubimage(x * tileWidth, y * tileHeight, tileWidth, tileHeight);
    }
}
