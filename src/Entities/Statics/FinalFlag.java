package Entities.Statics;

import MainGame.Handler;
import Tiles.Tile;
import Graphics.Assets;

import java.awt.*;

/*! \class FinalFlag extends StaticEntity
    \brief Defineste notiunea abstracta de steag.
 */
public class FinalFlag extends StaticEntity {

    public int id = 3; /*!< Referinta catre id.*/
    public static float xB, yB; /*!< Referinta statica catre pozitia flagului.*/

    /* \fn  public EndLevel(Handler handler, float x, float y)
   \brief Constructor de initializare a unei entitati Statice de tip viata.

   \param handler Un obiect de tip Handler.
   \param x Coordonata pe orizontala.
   \param y Coordonata pe verticala.
*/
    public FinalFlag(Handler handler, float x, float y) {
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
        xB = x;
        yB = y;
    }

    /*! \fn public static Rectangle getBounds()
            \brief  Returneaza un dreptunghi static pentru colizunie.
         */
    public static Rectangle getBounds() {
        return new Rectangle((int) xB, (int) yB, 150, 150);
    }

    /*! \fn @Override
                    public void die()
             \brief  Metoda de colectare a flagului.
          */
    @Override
    public void die() {
        System.out.println("Ai terminat nivelul 1!");
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
        g.drawImage(Assets.finalFlag, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);

    }

    /*! \fn public int getId()
            \brief  Returneaza daca id-ul este fals(viata) sau adevarat(cheie, flag).
         */
    public int getId() {
        return id;
    }

    /* *//*! \fn public void setId(boolean id)
            \brief  Seteaza id-ul(fals(viata) sau adevarat(cheie flag)).
         *//*
    public void setId(boolean id) {
        this.id = id;
    }*/
}