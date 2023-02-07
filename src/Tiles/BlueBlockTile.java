package Tiles;

import Graphics.Assets;

import java.awt.image.BufferedImage;

/*! \class BlueBlockTile extends Tile
    \brief Abstractizeaza notiunea de dala de tip cutie albastra.
 */
public class BlueBlockTile extends Tile {

    /*! \fn public BlueBlockTile(int id)
        \brief Constructorul de initializare al clasei.

        \param id Id-ul dalei util in desenarea hartii.
     */
    public BlueBlockTile(int id) {
        super(Assets.blue_block, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda isSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean isSolid() {
        return true;
    }
}
