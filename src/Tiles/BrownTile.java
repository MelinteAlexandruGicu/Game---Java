package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class BrownTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip nisip.
 */
public class BrownTile extends Tile {

    /*! \fn public BrownTile(int id)
        \brief Constructorul de initializare al clasei.

        \param id Id-ul dalei util in desenarea hartii.
     */
    public BrownTile(int id) {
        super(Assets.tile_brown, id);
    }

    /*! \fn public boolean IsSolid()
       \brief Suprascrie metoda isSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
    */
    @Override
    public boolean isSolid() {
        return true;
    }

}
