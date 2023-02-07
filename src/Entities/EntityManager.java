package Entities;

import Entities.Creatures.Player;
import MainGame.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

/*! \class EntityManager
    \brief Manager de entitati prezente in joc.

 */
public class EntityManager {

    private Handler handler; /*!< Referinta la un obiect de tip Handler.*/
    private Player player; /*!< Referinta la un obiect dec tip Player.*/
    private ArrayList<Entity> entities; /*!< Lista de entitati, alocate static.*/
    private Comparator<Entity> comparator = new Comparator<Entity>() {
        @Override
        public int compare(Entity e1, Entity e2) {
            if (e1.getY() + e1.getHeight() < e2.getY() + e2.getHeight())
                return -1;
            return 1;
        }
    }; /*!< Variabila de tip Comparator.*/

    /*! \fn public EntityManager(Handler handler, Player player)
          \brief Constructor de initializare al clasei ManagerEntity.

          Adauga player-ul in lista de entitati.

          \param handler Obiect de tip Handler.
          \param player Obiect de tip Player.
    */
    public EntityManager(Handler handler, Player player) {
        this.handler = handler;
        this.player = player;
        entities = new ArrayList<Entity>();
        addEntity(player);

    }

    /*! \fn public void update()
       \brief Actualizeaza starea enitatilor din joc, sortandu-le si elimnandu-le daca active este setat pe adevarat.
    */
    public void update() {
        for (int i = 0; i < entities.size(); i++) {
            Entity e = entities.get(i);
            e.update();
            if (!e.isActive()) {
                entities.remove(e);
            }
        }
        entities.sort(comparator);
    }

    /*! \fn public void draw(Graphics g)
           \brief Metoda ce deseneaza entitatile pe parcursul jocului pentru a le afisa pe ecran.
        */
    public void draw(Graphics g) {
        for (Entity e : entities) {
            e.draw(g);
        }
    }

    /*! \fn public void addEntity(Entity e)
       \brief Metoda ce adauga o entitate in lista entities.

       \param e Entitate ce urmeaza a fi adaugata.
    */
    public void addEntity(Entity e) {
        entities.add(e);
    }

    /*! \fn  public void removeEntity()
       \brief Metoda reinitializeaza lista entities.
    */
    public void removeEntity() {
        /*entities.clear();
        entities = new ArrayList<Entity>();
        addEntity(player);*/
        for (int i = 0; i < entities.size(); i++){
            entities.remove(i);
        }
        addEntity(player);
        player.setSpeed(4.0f);
    }

    /*! \fn public Handler getHandler()
              \brief Metoda returneaza un obiect de tip Handler.
           */
    public Handler getHandler() {
        return handler;
    }

    /*! \fn public void setHandler(Handler handler)
              \brief Metoda seteaza membrul handler al clasei cu un nou obiect de tip Handler.
           */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /*! \fn public Player getPlayer()
          \brief Metoda returneaza un obiect de tip Player.
       */
    public Player getPlayer() {
        return player;
    }

    /*! \fn public void setPlayer(Player player)
          \brief Metoda seteaza membrul player a clasei cu un nou obiect de tip Player.
       */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /*! \fn public ArrayList<Entity> getEntities()
              \brief Metoda returneaza o lista de entitati.
           */
    public ArrayList<Entity> getEntities() {
        return entities;
    }

    /*! \fn public void setEntities(ArrayList<Entity> entities)
              \brief Metoda seteaza lista alocata static cu o noua lista.
           */
    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }


}
