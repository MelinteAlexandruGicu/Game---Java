package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class GrassRockTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip iarba pe piatra.
 */
public class GrassRockTile extends Tile {

    /*! \fn public GrassRockTile(int id)
        \brief Constructorul de initializare al clasei.

        \param id Id-ul dalei util in desenarea hartii.
     */
    public GrassRockTile(int id) {
        super(Assets.tile_grass_rock, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda isSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean isSolid() {
        return true;
    }
}
