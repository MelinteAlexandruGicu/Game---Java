package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class SkyDrop extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer-picatura.
 */
public class SkyDrop extends Tile {

    /*! \fn public public Sky(int id)
       \brief Constructorul de initializare al clasei.

       \param id Id-ul dalei util in desenarea hartii.
    */
    public SkyDrop(int id) {
        super(Assets.skydrop, id);
    }

}
