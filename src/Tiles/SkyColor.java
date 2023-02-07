package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Skycolor extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer-culoare.
 */
public class SkyColor extends Tile {

    /*! \fn public public SkyColor(int id)
       \brief Constructorul de initializare al clasei.

       \param id Id-ul dalei util in desenarea hartii.
    */
    public SkyColor(int id) {
        super(Assets.skycolor, id);
    }

}
