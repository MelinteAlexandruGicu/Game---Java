package Graphics;

import Entities.Entity;
import MainGame.Handler;
import Tiles.Tile;

/*! \class GameCamera
    \brief Clasa ce implementeaza notiunea de camera.

 */
public class GameCamera {

    private Handler handler; /*!< Referinta catre un obiect de tip Handler*/
    private float xOffset, yOffset; /*!< Referinta catre pozitia camerei(deplasament).*/

    /*! \fn   public GameCamera(Handler handler, float xOffset, float yOffset)
        \brief Constructor de initializare

        \param handler Un obiect de tip Handler
        \param xOffset deplasament pe x
        \param yOffset deplasament pe y
     */
    public GameCamera(Handler handler, float xOffset, float yOffset) {
        this.handler = handler;
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    /*! \fn  public void checkBlankSpace()
            \brief Metoda de verificare a spatiului alb, in momentul deplasarii camerii impreuna cu jucatorul.
         */
    public void checkBlankSpace() {
        if (xOffset < 0) {
            xOffset = 0;
        } else if (xOffset > handler.getMap1().getWidth() * Tile.TILEWIDTH - handler.getWidth()) {
            xOffset = handler.getMap1().getWidth() * Tile.TILEWIDTH - handler.getWidth();
        }

        if (yOffset < 0) {
            yOffset = 0;
        } else if (yOffset > handler.getMap1().getHeight() * Tile.TILEHEIGHT - handler.getHeight()) {
            yOffset = handler.getMap1().getHeight() * Tile.TILEHEIGHT - handler.getHeight();
        }
    }

    /*! \fn  public void centerOnEntity(Entity e)
                \brief Metoda de centrare a camerei pe entitate(jucator).
             */
    public void centerOnEntity(Entity e) {
        xOffset = e.getX() - handler.getWidth() / 2 + e.getWidth() / 2;
        yOffset = e.getY() - handler.getHeight() / 2 + e.getHeight() / 2;
        checkBlankSpace();
    }

    /*! \fn  public void move(float xAmt, float yAmt)
                \brief Metoda de miscare a camerei cu delay.
             */
    public void move(float xAmt, float yAmt) {
        xOffset += xAmt;
        yOffset += yAmt;
        checkBlankSpace();
    }

    /*! \fn   public float getxOffset()
                \brief Returneaza membrul xOffset al clasei.
             */
    public float getxOffset() {
        return xOffset;
    }

    /*! \fn   public void setxOffset(float xOffset)
                \brief Seteaza membrul xOffset al clasei.
             */
    public void setxOffset(float xOffset) {
        this.xOffset = xOffset;
    }

    /*! \fn   public float getyOffset()
                \brief Returneaza membrul yOffset al clasei.
             */
    public float getyOffset() {
        return yOffset;
    }

    /*! \fn   public void setyOffset(float yOffset)
                \brief Seteaza membrul yOffset al clasei.
             */
    public void setyOffset(float yOffset) {
        this.yOffset = yOffset;
    }

}