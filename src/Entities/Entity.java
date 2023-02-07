package Entities;

import MainGame.Handler;
import Tiles.Tile;
import java.awt.*;
import Map.*;

/*! \class Entity
    \brief Implementeaza notiunea de entitate.
 */
public abstract class Entity {
    protected Handler handler;  /*!< Referinta catre Handler.*/
    protected float x, y; /*!< Variabile ce retin coordonatele.*/
    protected int width, height; /*!< Variabile ce retin latimea si inaltimea entitatii.*/
    protected Rectangle bounds; /*!< Variabila ce retine un dreptunghi de coliziune.*/
    protected boolean active = true; /*!< Variabila ce retine valoarea de adevar a variabilei active folosita la coliziune.*/
    protected  int health; /*!< Retine viata caracterului.*/
    public static final int DEFAULT_HEALTH = 100; /*!< Retine o variabila statica si constanta a viatii caracterului.*/

    /*! \fn public Entity(Handler handler, float x, float y, int w, int h)
               \brief Constructor de initializare al clasei Entity.

               Acest constructor primeste ca parametri un handler, coordonatele x si y de la care se face afisarea,
               latimea si inaltimea imaginii creaturii.

               \param handler Un obiect de tip Handler.
               \param x Coordonata x.
               \param y Coordonata y.
               \param width Latimea creaturii.
               \param height Inaltimea creaturii.
            */
    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        health = DEFAULT_HEALTH;

        bounds = new Rectangle(0, 0, width, height);
    }

    /*! \fn public abstract void update()
        \brief Metoda este implementata de clasele ce o extind.
     */
    public abstract void update();

    /*! \fn public abstract void draw(Graphics g)
        \brief Metoda este implementata de clasele ce o extind.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    public abstract void draw(Graphics g);

    /*! \fn public abstract void die()
              \brief Metoda va fi implementata de clasele ce o vor extinde.
           */
    public abstract void die();

    /*! \fn public void hurt(int tmp)
           \brief Metoda de distrugere element static

          Aceasta metoda va detecta daca elementul colectat trebuie sau nu distrus,
          conditia fiind ca health <= 0 si va apela metoda die pentru a-l face nevazut.

           \param tmp Variabila ce retine numarul de distrugere.

    */
    public void hurt(int tmp){
        health -= 100;

        if(health <= 0){
            active = false;
            die();
        }


    }

    /*! \fn public boolean checkEntityCollisions(float xOffset, float yOffset)
       \brief public boolean checkCollesionEntity(float xOffset, float yOffset)

      Aceasta metoda parcurge fiecare entitate si daca una dintre ele se intersecteaza cu o alta entitate, aceasta returneaza 1, altfel 0.

       \param xOffset coordonata x
       \param yOffset coordonata y.
    */
    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getMap1().getEntityManager1().getEntities()){
            if(e.equals(this))
                continue;
            if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
                return true;
            }
        }
        return false;
    }

    /*! \fn public Rectangle getCollisionBounds(float xOffset, float yOffset)
      \brief Metoda de creare a unui dreptunghi de coliziune.

      Metoda creaza un dreptunghi pentru a putea detecta coleziunile cu dalele solide

   */
    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);

    }

    /*! \fn protected  boolean isOnFloor()
      \brief Metoda de verificare a asezarii, pe partea superioara a dalei, jucatorului.
   */
    protected  boolean isOnFloor()
    {
        Map1 m = handler.getMap1();
        return m.getTile((int) ((x + bounds.width / 2 + 22) / Tile.TILEWIDTH), (int) ((y + bounds.y + 40) / Tile.TILEHEIGHT)).isSolid() &&
                m.getBounds((int) ((x + bounds.width / 2 + 22) / Tile.TILEWIDTH), (int) ((y + bounds.y + 40 ) / Tile.TILEHEIGHT)).intersects(bounds.getBounds());
    }

    /*! \fn protected  boolean isOnTop()
      \brief Metoda de verificare a coliziunii cu partea inferioara a dalei a jucatorului.
   */
    protected boolean isOnTop(){
        Map1 m = handler.getMap1();
        return m.getTile((int) ((x + bounds.width / 2 + 22) / Tile.TILEWIDTH), (int) ((y + 15) / Tile.TILEHEIGHT)).isSolid() &&
                m.getBounds((int) ((x + bounds.width / 2 + 22) / Tile.TILEWIDTH), (int) ((y + 15 ) / Tile.TILEHEIGHT)).intersects(bounds.getBounds());
    }

    /*! \fn public float getX()
        \brief Metoda returneaza valoarea membrului x al clasei.
     */
    public float getX() {
        return x;
    }

    /*! \fn public void setX(float x)
        \brief Metoda seteaza valoarea membrului x al clasei cu o noua valoare.
     */
    public void setX(float x) {
        this.x = x;
    }

    /*! \fn public float getY()
        \brief Metoda returneaza valoarea membrului y al clasei.
     */
    public float getY() {
        return y;
    }

    /*! \fn public void setY(float y)
        \brief Metoda seteazavaloarea membrului y al clasei cu o noua valoare.
     */
    public void setY(float y) {
        this.y = y;
    }

    /*! \fn public int getWidth()
        \brief Metoda returneaza valoarea membrului width al clasei.
     */
    public int getWidth() {
        return width;
    }

    /*! \fn public void setWidth(int width)
        \brief Metoda seteaza valoarea membrului width al clasei cu o noua valoare.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /*! \fn public int getHeight()
        \brief Metoda returneaza valoarea membrului height al clasei.
     */
    public int getHeight() {
        return height;
    }

    /*! \fn public void setHeight(int height)
        \brief Metoda returneaza valoarea membrului height al clasei.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /*! \fn public boolean isActive()
          \brief Metoda returneaza valoarea membrului active al clasei.
       */
    public boolean isActive() {
        return active;
    }

    /*! \fn public void setActive(boolean active)
              \brief Metoda seteaza membrul active cu o noua valoare.
           */
    public void setActive(boolean active) {
        this.active = active;
    }

    /*! \fn public static int getHealth()
          \brief Metoda returneaza valoarea membrului health al clasei.
       */
    public int getHealth() {
        return health;
    }

    /*! \fn public void setHealth(int health)
         \brief Metoda seteaza valoare membrului health cu o noua valoare.
      */
    public void setHealth(int health) {
        this.health = health;
    }

    /*! \fn public abstract boolean getId()
              \brief Metoda va fi implementata de clasele ce o vor extinde.
           */
    public abstract int getId();
}
