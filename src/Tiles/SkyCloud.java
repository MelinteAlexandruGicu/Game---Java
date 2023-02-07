package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class SkyCloud extends Tile
    \brief Abstractizeaza notiunea de dala de tip cer-picatura.
 */
public class SkyCloud extends Tile {

    /*! \fn public public Sky(int id)
       \brief Constructorul de initializare al clasei.

       \param id Id-ul dalei util in desenarea hartii.
    */
    public SkyCloud(int id) {
        super(Assets.skycloud, id);
    }

}
