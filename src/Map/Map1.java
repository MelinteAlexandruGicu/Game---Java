package Map;

import Entities.Creatures.Player;
import Entities.EntityManager;
import Entities.Statics.EndLevel;
import Entities.Statics.FinalFlag;
import Entities.Statics.KeyItem;
import Graphics.Assets;
import MainGame.Game;
import MainGame.Handler;
import Tiles.Tile;
import UI.UIManager;
import Utils.Utils;

import java.awt.*;

/*! \class Map1
    \brief Implementeaza notiunea de harta 1 a jocului.
 */
public class Map1 /*extends Map*/ {

    private Handler handler; /*!< O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width, height; /*!< Latimea si inaltimea hartii in numar de dale.*/
    private int spawnX, spawnY;  /*!< Referinta catre pozitia de start a jucatorului.*/
    private int[][] tiles;  /*!< Referinta catre o matrice cu codurile dalelor ce vor construi harta.*/
    private UIManager uiManager;  /*!< Referinta catre un obiect de tip UIManager*/

    private EntityManager entityManager1, entityManager2;  /*!< Referinta catre un obiect de tip EntityManager*/

    /*! \fn public Map1(Handler handler, String path)
        \brief Constructorul de initializare al clasei.

        \param handler O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
        \param hpath cale de citire a hartii.
     */
    public Map1(Handler handler, String path) {
        this.handler = handler;

        entityManager1 = new EntityManager(handler, new Player(handler, 0, 270));
        entityManager1.addEntity(new KeyItem(handler, 92, 150)); // prima cheie
        entityManager1.addEntity(new KeyItem(handler, 188, 296)); // a doua cheie
        entityManager1.addEntity(new KeyItem(handler, 480, 482)); // a treia  cheie
        entityManager1.addEntity(new KeyItem(handler, 600, 195)); // a patra cheie
        entityManager1.addEntity(new KeyItem(handler, 893, 103)); // a cincea cheie
        entityManager1.addEntity(new KeyItem(handler, 780, 579)); // a sasea cheie
        entityManager1.addEntity(new KeyItem(handler, 1294, 252)); // a saptea cheie
        entityManager1.addEntity(new KeyItem(handler, 1390, 579)); // a opta cheie



        entityManager2 = new EntityManager(handler, new Player(handler, 0, 270));
        entityManager2.addEntity(new KeyItem(handler, 336, 532)); // prima cheie
        entityManager2.addEntity(new KeyItem(handler, 95, 390)); // a doua cheie
        entityManager2.addEntity(new KeyItem(handler, 290, 150)); // a treia cheie
        entityManager2.addEntity(new KeyItem(handler, 336, 290)); // a patra cheie
        entityManager2.addEntity(new KeyItem(handler, 48, 250)); // a cincea cheie
        entityManager2.addEntity(new KeyItem(handler, 530, 440)); // a sasea cheie
        entityManager2.addEntity(new KeyItem(handler, 560, 250)); // a saptea cheie
        entityManager2.addEntity(new KeyItem(handler, 670, 150)); // a opta cheie
        entityManager2.addEntity(new KeyItem(handler, 820, 150)); // a noua cheie
        entityManager2.addEntity(new KeyItem(handler, 768, 345)); // a zecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1100, 150)); // a unsprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1100, 345)); // a douasprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 860, 440)); // a treisprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1550, 102)); // a paisprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1632, 390)); // a cincisprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1530, 198)); // a saisprezecea cheie
        entityManager2.addEntity(new KeyItem(handler, 1345, 345)); // a saptesprezecea  cheie


        entityManager1.addEntity(new EndLevel(handler, 1640, 579));

        entityManager2.addEntity(new FinalFlag(handler, 1600, 579));

        loadMap1(path);

        entityManager1.getPlayer().setX(spawnX);
        entityManager1.getPlayer().setY(spawnY);

        entityManager2.getPlayer().setX(spawnX);
        entityManager2.getPlayer().setY(spawnY);

    }

    /*! \fn public  void update()
        \brief Actualizarea hartii in functie de evenimente.
     */
    public void update() {
    switch(Game.level){
        case 1:
            entityManager1.update();
            break;
        case 2:
            entityManager2.update();
            break;
    }

    }

    /*! \fn public void draw(Graphics g)
        \brief Functia de desenare a hartii.

        \param g Contextul grafic in care se realizeaza desenarea.
     */
    public void draw(Graphics g) {
        g.drawImage(Assets.bkggame, 0, 0, null);
        int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
        int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
        int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
        int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

        for (int y = yStart; y < yEnd; y++) {
            for (int x = xStart; x < xEnd; x++) {
                getTile(x, y).draw(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
                        (int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
            }
        }

        switch(Game.level) {
            case 1:
                entityManager1.draw(g);
                break;
            case 2:
                entityManager2.draw(g);
                break;
            //uiManager.draw(g);
        }

    }

    /*! \fn public Tile getTile(int x, int y)
            \brief Intoarce o referinta catre dala aferenta codului din matrice de dale.

            In situatia in care dala nu este gasita datorita unei erori ce tine de cod dala, coordonate gresite etc se
            intoarce o dala predefinita.
         */
    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return Tile.skyColor;

        Tile t = Tile.tiles[tiles[x][y]];
        if (t == null)
            return Tile.skyColor;
        return t;
    }

    /*! \fn public EntityManager getEntityManager1()
            \brief Returneaza un obiect de tip EntityManager.
         */
    public EntityManager getEntityManager1() {
        return entityManager1;
    }

    /*! \fn  public void setEntityManager1(EntityManager entityManager)
            \brief Seteaza un obiect de tip EntityManager.
         */
    public void setEntityManager1(EntityManager entityManager) {
        this.entityManager1 = entityManager;
    }

    /*! \fn public EntityManager getEntityManager1()
            \brief Returneaza un obiect de tip EntityManager.
         */
    public EntityManager getEntityManager2() {
        return entityManager2;
    }

    /*! \fn  public void setEntityManager2(EntityManager entityManager)
            \brief Seteaza un obiect de tip EntityManager.
         */
    public void setEntityManager2(EntityManager entityManager) {
        this.entityManager2 = entityManager;
    }

    /*! \fn  private void loadMap1(String path){
        \brief Functie de incarcare a hartii jocului.
        Aici se poate genera sau incarca din fisier harta.
     */
    private void loadMap1(String path) {
        String file = Utils.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Utils.parseInt(tokens[0]);
        height = Utils.parseInt(tokens[1]);
        spawnX = Utils.parseInt(tokens[2]);
        spawnY = Utils.parseInt(tokens[3]);

        tiles = new int[width][height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
            }
        }
    }

    /*! \fn  public int getWidth()
       \brief Returneaza variabila width.
    */
    public int getWidth() {
        return width;
    }

    /*! \fn  public int geHeight()
       \brief Returneaza variabila height.
    */
    public int getHeight() {
        return height;
    }

    /*! \fn  public Rectangle getBounds(int x, int y)
       \brief Returneaza un dreptunghi de coliziune.
    */
    public Rectangle getBounds(int x, int y) {
        return new Rectangle(x, y, Tile.TILEWIDTH, Tile.TILEWIDTH);
    }

    public void clearTiles() {

    }
}

