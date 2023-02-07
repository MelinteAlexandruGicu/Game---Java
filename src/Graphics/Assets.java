package Graphics;

import java.awt.image.BufferedImage;

/*! \class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets {

    public static BufferedImage[] player_basic, player_jump, player_fall; /*!< Referinta catre elemente grafice de tip vector BufferedImage.*/
    public static BufferedImage green_block, orange_block, yellow_block, blue_block, silver_block, brown_block, brown_box;/*!< Referinta catre elemente grafice de tip BufferedImage.*/
    public static BufferedImage key; /*!< Referinta catre element grafic de tip BufferedImage.*/
    public static BufferedImage bkggame; /*!< Referinta catre element grafic de tip BufferedImage.*/
    public static BufferedImage endLevel; /*!< Referinta catre element grafic de tip BufferedImage.*/
    public static BufferedImage finalFlag; /*!< Referinta catre element grafic de tip BufferedImage.*/
    public static BufferedImage skycolor, skycolor2, skycolor3, skydrop, skycloud; /*!< Referinta catre elemente grafice de tip BufferedImage.*/
    public static BufferedImage life_half, life_full; /*!< Referinta catre elemente grafice de tip BufferedImage.*/
    public static BufferedImage tile_rock, tile_water, tile_sand, tile_brown, tile_grass_brown, tile_grass_rock, tile_snow_brown, tile_smt_brown, tile_smt_rock; /*!< Referinta catre elemente grafice de tip BufferedImage.*/
    public static BufferedImage[] player_left, player_right, start_button, options_button, back_button, exit_button; /*!< Referinta catre elemente grafice de tip vector BufferedImage.*/
    public static BufferedImage bkgMenu, optionsMenu; /*!< Referinta catre elemente grafice de tip BufferedImage.*/

    /*! \fn public static void init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void init(){

        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet2.png"));

        exit_button = new BufferedImage[2];

        player_left = new BufferedImage[3];
        player_right = new BufferedImage[3];
        player_basic = new BufferedImage[2];
        player_fall = new BufferedImage[2];
        player_jump = new BufferedImage[2];
        start_button = new BufferedImage[2];
        options_button = new BufferedImage[2];
        back_button = new BufferedImage[2];

        bkgMenu = ImageLoader.loadImage("/textures/menu.png");

        optionsMenu = ImageLoader.loadImage("/textures/OptionsMenu.png");

        bkggame = ImageLoader.loadImage("/textures/background.jpg");

        endLevel = ImageLoader.loadImage("/textures/endLevel.png");

        finalFlag = ImageLoader.loadImage("/textures/finalFlag.png");



        exit_button[0] = ImageLoader.loadImage("/textures/xexitnormal.png");
        exit_button[1] = ImageLoader.loadImage("/textures/xexithov.png");


        start_button[0] = sheet.crop(3, 0);
        start_button[1] = sheet.crop(1, 0);

        options_button[0] = sheet.crop(2, 0);
        options_button[1] = sheet.crop(0, 0);

        back_button[0] = ImageLoader.loadImage("/textures/backbutton.png");
        back_button[1] = ImageLoader.loadImage("/textures/backbuttonhov.png");

        player_left[0] = sheet.crop(0,1);
        player_left[1] = sheet.crop(1,1);
        player_left[2] = sheet.crop(2,1);

        player_right[0] = sheet.crop(3,1);
        player_right[1] = sheet.crop(4,1);
        player_right[2] = sheet.crop(5,1);

        player_basic[0] = sheet.crop(4,0);
        player_basic[1] = sheet.crop(4,0);
        player_jump[0] = sheet.crop(6,0);
        player_jump[1] = sheet.crop(6,0);
        player_fall[0] = sheet.crop(5, 0);
        player_fall[1] = sheet.crop(5, 0);

        green_block = sheet.crop(4,2);
        orange_block = sheet.crop(5,2);
        yellow_block = sheet.crop(6,2);
        brown_block = sheet.crop(0,3);
        silver_block= sheet.crop(1,3);
        blue_block = sheet.crop(2,4);
        brown_box = sheet.crop(2,3);

        key = sheet.crop(2,5);


        life_full = sheet.crop(1,5);
        life_half = sheet.crop(0,5);

        tile_rock = sheet.crop(1,2);
        tile_water = sheet.crop(0,4 );
        tile_sand = sheet.crop(0,3);
        tile_brown = sheet.crop(6,3);
        tile_grass_brown = sheet.crop(3,3);
        tile_grass_rock = sheet.crop(4,4);
        tile_snow_brown = sheet.crop(5,3);
        tile_smt_brown = sheet.crop(4,3);
        tile_smt_rock = sheet.crop(5,4);

        skycolor = ImageLoader.loadImage("/textures/skycolo2.png");
        skydrop = ImageLoader.loadImage("/textures/skycolor3.png");
        skycloud = ImageLoader.loadImage("/textures/skycolor4.png");
        skycolor3 = sheet.crop(0,2);
        skycolor2 = sheet.crop(6,1);



    }
}
