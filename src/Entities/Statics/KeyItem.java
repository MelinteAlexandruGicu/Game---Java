package Entities.Statics;

import MainGame.Handler;
import Tiles.Tile;
import Graphics.*;

import java.awt.*;

/*! \class KeyItem extends StaticEntity
    \brief Defineste notiunea abstracta de cheie.

 */
public class KeyItem extends StaticEntity {

    public int id = 1; /*!< Referinta catre id.*/

    /* \fn public KeyItem(Handler handler, float x, float y)
   \brief Constructor de initializare a unei entitati Statice de tip viata.

   \param handler Un obiect de tip Handler.
   \param x Coordonata pe orizontala.
   \param y Coordonata pe verticala.
*/
    public KeyItem(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    /*! \fn @Override
                    public void die()
             \brief  Metoda de colectare a cheii.
          */
    @Override
    public void die() {
        System.out.println("Key Colected!");
    }

    /*! \fn @Override
                    public void update()
        \brief Actualizeaza starea entitatii de tip cheie din joc.
     */
    @Override
    public void update() {

    }

    /*! \fn @Override
                  public void draw(Graphics g)
       \brief  Deseneaza cheia pe ecran.

          \param g Contextul grafic in care trebuie sa deseneze enitatea viata pe ecran.
    */
    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.key, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    /*! \fn public int getId()
            \brief  Returneaza id-ul
         */
    public int getId() {
        return id;
    }

    /*! \fn public void setId(int id)
            \brief  Seteaza id-ul.
         */
    public void setId(int id) {
        this.id = id;
    }
}
