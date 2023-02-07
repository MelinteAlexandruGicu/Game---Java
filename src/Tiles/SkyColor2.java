package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Skycolor2 extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer-culoare2.
 */
public class SkyColor2 extends Tile {

    /*! \fn public public SkyColor2(int id)
       \brief Constructorul de initializare al clasei.

       \param id Id-ul dalei util in desenarea hartii.
    */
    public SkyColor2(int id) {
        super(Assets.skycolor2, id);
    }

}
