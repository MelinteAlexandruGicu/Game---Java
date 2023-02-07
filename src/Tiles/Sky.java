package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class Sky extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer.
 */
public class Sky extends Tile {

    /*! \fn public public Sky(int id)
       \brief Constructorul de initializare al clasei.

       \param id Id-ul dalei util in desenarea hartii.
    */
    public Sky(int id) {
        super(Assets.tile_water, id);
    }

}
