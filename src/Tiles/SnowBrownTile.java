package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class SnowBrownTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip zapada-nisip.
 */
public class SnowBrownTile extends Tile {

    /*! \fn public SnowBrownTile(int id)
        \brief Constructorul de initializare al clasei.

        \param id Id-ul dalei util in desenarea hartii.
     */
    public SnowBrownTile(int id) {
        super(Assets.tile_snow_brown, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda isSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean isSolid() {
        return true;
    }
}
