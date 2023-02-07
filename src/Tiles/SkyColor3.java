package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;


/*! \class Skycolor3 extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer-culoare3.
 */
public class SkyColor3 extends Tile {

    /*! \fn public public SkyColor3(int id)
      \brief Constructorul de initializare al clasei.

      \param id Id-ul dalei util in desenarea hartii.
   */
    public SkyColor3(int id) {
        super(Assets.skycolor3, id);
    }

}
