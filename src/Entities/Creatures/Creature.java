package Entities.Creatures;

import Entities.Entity;
import MainGame.Handler;
import Tiles.Tile;

import java.awt.*;

/*! \class Creature
    \brief Implementeaza notiunea creatura prezenta in joc.

 */
public abstract class Creature extends Entity {


    public static final float DEFAULT_SPEED = 4.0f; /*!< Variabila statica constanta ce retine viteza creaturii.*/
    public static final int DEFAULT_CREATURE_WIDTH = 64; /*!< Variabila statica constanta ce retine lațimea creaturii.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 64; /*!< Variabila statica constanta ce retine inaltimea creaturii.*/


    protected float speedX, speedY, speed; /*!< Variabila  ce retine viteza creaturii(atat pe orizontala cat ai pe verticala.*/
    protected float xMove, yMove; /*!< Variabile  ce retin coordonatele miscarilor.*/
    protected float gravity = 10f; /*!< Variabila  ce retine notiunea de gravitate(cadere).*/


    /*! \fn public Creature(Handler handler, float x, float y, int width, int height)
               \brief Constructor de initializare al clasei Creature.

               Acest constructor primeste ca parametri un handler, coordonatele x si y de la care se face afisarea,
               latimea si inaltimea imaginii creaturii.

               \param handler Un obiect de tip Handler.
               \param x Coordonata x
               \param y Coordonata y
               \param width Latimea creaturii
               \param height Inaltimea creaturii
            */
    public Creature(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);

        speedX = DEFAULT_SPEED;
        speedY = DEFAULT_SPEED;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    /*! \fn public abstract Rectangle getBounds()
        \brief  Metoda ce urmeaza a fi implementata.
     */
    public abstract Rectangle getBounds();

    /*! \fn private void jump()
        \brief  Metoda verifica coliziunile pentru a impiedica strapungerea dalei.
     */
    public void jump() {
        if (isOnFloor() && !isOnTop()) {
            gravity = 5.5f;
            y -= gravity;
            gravity -= 0.1f;
        }
    }

    /*! \fn private void move()
         \brief  Metoda verifica coliziunile pentru a modifica cele doua coordonate, x si y.
      */
    public void move() {

        moveX();

        moveY();
    }

    /*! \fn private void moveX()
        \brief  Metoda modifica coordonata x decremetand-o atunci cand creatura se deplaseaza la stanga,
                incremetand-o atunci cand creatura se deplaseaza la dreapta.
     */
    public void moveX() {
        if (xMove > 0) {//dreapta
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }

        } else if (xMove < 0) {//stanga
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;

            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) &&
                    !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT)) {
                x += xMove;
            } else {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }

        }
    }

    /*! \fn private void moveX()
        \brief  Metoda modifica coordonata x decremetand-o atunci cand creatura se deplaseaza in sus,
                incremetand-o atunci cand creatura se deplaseaza in jos.
     */
    public void moveY() {
        if (yMove < 0) {//sus
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
            }

        } else if (yMove > 0) {//jos
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)) {
                y += yMove;
            } else {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;
            }

        }
    }

    /*! \fn protected boolean collisionWithTile(int x, int y)
        \brief  Metoda returneaza valoarea de adevar a metodei "isSolid" corespunzatoare dalei de la coordonatele x si y.
    */
    protected boolean collisionWithTile(int x, int y) {
        return handler.getMap1().getTile(x, y).isSolid();
    }

    /*! \fn public float getSpeed()
            \brief  Metoda returneaza viteza.
        */
    public float getSpeed() {
        return speed;
    }

    /*! \fn public void setSpeed()
        \brief  Metoda seteaza viteza.
    */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public int getHealth()
        \brief  Metoda returneaza viata.
    */
    public int getHealth() {
        return health;
    }

    /*! \fn public void setHealth()
        \brief  Metoda seteaza viata.
    */
    public void setHealth(int health) {
        this.health = health;
    }

    /*! \fn public float getSpeedX()
            \brief  Metoda returneaza viteza pe verticala.
        */
    public float getSpeedX() {
        return speedX;
    }

    /*! \fn public void setSpeedX()
       \brief  Metoda seteaza viteza pe verticala.
   */
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    /*! \fn public float getSpeedY()
            \brief  Metoda returneaza viteza pe orizontala.
        */
    public float getSpeedY() {
        return speedY;
    }

    /*! \fn public void setSpeedY()
       \brief  Metoda seteaza viteza pe orizontala.
   */
    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    /*! \fn public int getxMove()
        \brief  Metoda returneaza valoarea variabilei "xMove".
    */
    public float getxMove() {
        return xMove;
    }

    /*! \fn public void setxMove()
        \brief  Metoda seteaza valoarea variabilei "xMove".
    */
    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    /*! \fn public int getyMove()
        \brief  Metoda returneaza valoarea variabilei "yMove".
    */
    public float getyMove() {
        return yMove;
    }

    /*! \fn public void setyMove()
        \brief  Metoda seteaza valoarea variabilei "yMove".
    */
    public void setyMove(float yMove) {
        this.yMove = yMove;
    }

}
