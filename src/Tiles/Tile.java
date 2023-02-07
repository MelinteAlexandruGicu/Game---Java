package Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class Tile
    \brief Retine toate dalele intr-un vector si ofera posibilitatea regasirii dupa un id.
 */
public class Tile {

    private static final int NO_TILES = 32; /*!< Variabila statica constanta ce retine numarul de id-uri de dale*/

    public static Tile[] tiles = new Tile[NO_TILES]; /*!< Vector de referinte de tipuri de dale.*/
    public static Tile grassRockTile = new GrassRockTile(0);  /*!< Dala de tip iarba pe piatra.*/
    public static Tile rockTile = new RockTile(1);  /*!< Dala de tip piatra.*/
    public static Tile brownTile = new BrownTile(2);  /*!< Dala de tip nisip.*/
    public static Tile blueBlockTile = new BlueBlockTile(3);  /*!< Dala de tip cutie albastra.*/
    public static Tile yellowBlockTile = new YellowBlockTile(9);  /*!< Dala de tip cutie galbena.*/
    public static Tile skyTile = new Sky(4);  /*!< Dala de tip apa cu pesti.*/
    public static Tile skyDrop = new SkyDrop(10);  /*!< Dala de tip cer-ploaie*/
    public static Tile skyCloud = new SkyCloud(11);  /*!< Dala de tip cer-nor*/
    public static Tile skyColor = new SkyColor(5);  /*!< Dala de tip cer-culoare*/
    public static Tile skyColor2 = new SkyColor2(6); /*!< Dala de tip cer-culoare2*/
    public static Tile skyColor3 = new SkyColor3(7); /*!< Dala de tip cer-culoare3*/
    public static Tile snowbronwTile = new SnowBrownTile(8); /*!< Dala de tip zapada-nisip*/

    public static final int TILEWIDTH = 48;  /*!< Latimea unei dale.*/
    public static final int TILEHEIGHT = 48;  /*!< Inaltimea unei dale.*/

    protected BufferedImage texture; /*!< Imaginea aferenta tipului de dala.*/
    protected final int id;   /*!< Id-ul unic aferent tipului de dala.*/

    /*! \fn public Tile(BufferedImage texture, int id)
        \brief Constructorul aferent clasei.

        \param image Imaginea corespunzatoare dalei.
        \param id Id-ul dalei.
     */
    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id] = this;
    }

    /*! \fn public void update()
        \brief Actualizeaza proprietatile dalei.
     */
    public void update() {

    }

    /*! \fn public void draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void draw(Graphics g, int x, int y) {
        g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
    }

    /*! \fn public boolean isSolid()
        \brief Returneaza proprietatea de dala solida (supusa coliziunilor) sau nu.
     */
    public boolean isSolid() {
        return false;
    }

    /*! \fn public int getId()
       \brief Returneaza id-ul dalei.
    */
    public int getId() {
        return id;
    }
}
