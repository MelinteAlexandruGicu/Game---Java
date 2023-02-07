package Entities.Statics;

import MainGame.Handler;
import Tiles.Tile;
import Graphics.*;

import java.awt.*;

/*! \class Life extends StaticEntity
    \brief Defineste notiunea abstracta de viata
 */
public class Life extends StaticEntity {

    /* \fn public Life(Handler handler, float x, float y)
    \brief Constructor de initializare a unei entitati Statice de tip viata.

    \param handler Un obiect de tip Handler.
    \param x Coordonata pe orizontala.
    \param y Coordonata pe verticala.
 */
    public Life(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    /*! \fn @Override
                    public void die()
             \brief  Metoda de terminare a jocului.
          */
    @Override
    public void die() {
        System.out.println("GAME OVER");
    }

    /*! \fn @Override
                    public void update()
        \brief Actualizeaza starea entitatii de tip viata din joc.
     */
    @Override
    public void update() {

    }

    /*! \fn @Override
                   public void draw(Graphics g)
        \brief  Deseneaza viata pe ecran.

           \param g Contextul grafic in care trebuie sa deseneze enitatea viata pe ecran.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(Assets.life_full, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    /*! \fn @Override
                public int getId()
            \brief  Returneaza id-ul.

         */
    @Override
    public int getId() {
        return 0;
    }
}
