package MainGame;

import GameWindow.Display;
import Graphics.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

import Input.KeyManager;
import Input.MouseManager;
import States.*;
import UI.UIManager;

/*! \class Game
    \brief Clasa principala a intregului proiect. Implementeaza Game - Loop (Update -> Draw)

                ------------
                |           |
                |     ------------
    60 times/s  |     |  Update  |  -->{ actualizeaza variabile, stari, pozitii ale elementelor grafice etc.
        =       |     ------------
     16.7 ms    |           |
                |     ------------
                |     |   Draw   |  -->{ deseneaza totul pe ecran
                |     ------------
                |           |
                -------------
    Implementeaza interfata Runnable:

        public interface Runnable {
            public void run();
        }

    Interfata este utilizata pentru a crea un nou fir de executie avand ca argument clasa Game.
    Clasa Game trebuie sa aiba definita metoda "public void run()", metoda ce va fi apelata
    in noul thread(fir de executie). Mai multe explicatii veti primi la curs.

    In mod obisnuit aceasta clasa trebuie sa contina urmatoarele:
        - public Game();            //constructor
        - private void init();      //metoda privata de initializare
        - private void update();    //metoda privata de actualizare a elementelor jocului
        - private void draw();      //metoda privata de desenare a tablei de joc
        - public run();             //metoda publica ce va fi apelata de noul fir de executie
        - public synchronized void start(); //metoda publica de pornire a jocului
        - public synchronized void stop()   //metoda publica de oprire a jocului
 */
public class Game implements Runnable {

    public static int level = 1; /*!<Variabila statica ce retine nivelul jocului, initializandu-l cu 1. */

    private static Game instance = null; /*!< Variabila statica de tip Game ce reprezinta SINGLETON.*/

    private Display display; /*!< Fereastra in care se va desena tabla jocului.*/
    private int width, height; /*!<Variabile ce retin latimea si inaltimea. */
    public String title;  /*!< variabila membra temporara. Este folosita in aceasta etapa doar pentru a desena pe ecran.*/

    private boolean running = false; /*!<Variabila boolean ce reprezinta starea de running. */
    private Thread thread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/

    private BufferStrategy bs; /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/
    private Graphics g; /*!< Referinta catre un context grafic.*/

    //States
    public State gameState; /*!< Referinta catre joc(nivel 1).*/
    public State menuState; /*!< Referinta catre meniu.*/
    public State optionsState; /*!< Referinta catre optiuni.*/
    public State level2State; /*!< Referinta catre nivel 2.*/

    //Input
    private KeyManager keyManager; /*!< Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului cu ajutorul tastaturii.*/
    private MouseManager mouseManager; /*!< Referinta catre obiectul care gestioneaza intrarile din partea utilizatorului cu ajutorul mouse-ului.*/

    //Camera
    private GameCamera gameCamera;  /*!< Referinta catre GameCamera.*/

    //Handler
    private Handler handler; /*!< Referinta catre un obiect de tip Handler.*/

    public UIManager uiManager;  /*!< Referinta catre un obiect de tip UIManager.*/

    /*! \fn public Game(String title, int width, int height)
            \brief Constructor de initializare al clasei Game.

            Acest constructor primeste ca parametri titlul ferestrei, latimea si inaltimea
            acesteia avand in vedere ca fereastra va fi construita/creata in cadrul clasei Game.

            \param title Titlul ferestrei.
            \param width Latimea ferestrei in pixeli.
            \param height Inaltimea ferestrei in pixeli.
         */
    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
        mouseManager = new MouseManager();
        instance = this;
        //music = new Music();
        // music.playMusic("res/Music/music.wav");


    }

    /*! \fn public static Game getInstance()
        \brief  Metoda returneaza un obiect de tip game(SINGLETON).
     */
    public static Game getInstance() {
        if (instance == null)
            instance = new Game("RobKeys", 864, 720);
        return instance;
    }

    /*! \fn public State newGame()
       \brief  Metoda returneaza o noua referinta catre joc.
    */
    public State newGame() {
        level2State = new Level2State(handler);
        gameState = new GameState(handler);

        Game.level = 1;
        GameState.keys = 0;
        GameState.lifes = 3;
        GameState.score = 0;
        return gameState;
    }


    /*! \fn private void init()
            \brief  Metoda construieste fereastra jocului, initializeaza aseturile, listenerul de tastatura etc.

            Fereastra jocului va fi construita prin apelul functiei BuildGameWindow();
            Sunt construite elementele grafice (assets): dale, player, elemente active si pasive.

         */
    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0, 0);


        gameState = new GameState(handler);
        level2State = new Level2State(handler);
        optionsState = new OptionsState(handler);
        menuState = new MenuState(handler);

        State.setCurrentState(menuState);

    }

    /*! \fn private void update()
        \brief Actualizeaza starea elementelor din joc.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */
    private void update() {
        keyManager.update();
        if (State.getCurrentState() != null) {
            State.getCurrentState().update();
        }
    }

    /*! \fn private void draw()
        \brief Deseneaza elementele grafice in fereastra coresponzator starilor actualizate ale elementelor.

        Metoda este declarata privat deoarece trebuie apelata doar in metoda run()
     */
    private void draw() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            try {
                display.getCanvas().createBufferStrategy(3);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, display.getWidth(), display.getHeight());
        //Draw
        if (State.getCurrentState() != null) {
            State.getCurrentState().draw(g);
        }
        //End Draw
        bs.show();
        g.dispose();

    }

    /*! \fn public void run()
        \brief Functia ce va rula in thread-ul creat.

        Aceasta functie va actualiza starea jocului si va redesena tabla de joc (va actualiza fereastra grafica)
     */
    public void run() {
        init();

        int fps = 60;
        double timePerUpgrade = 1000000000.00 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int upgrades = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerUpgrade;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                update();
                draw();
                upgrades++;
                delta--;
            }
            if (timer >= 1000000000) {
                System.out.println("Upgrades and Frames: " + upgrades);
                upgrades = 0;
                timer = 0;
            }
        }

        stop();
    }

    /*! \fn public KeyManager getKeyManager()
       \brief Returneaza obiectul care gestioneaza tastatura.
    */
    public KeyManager getKeyManager() {
        return keyManager;
    }

    /*! \fn public MouseManager getMouseManager()
      \brief Returneaza obiectul care gestioneaza mouseul.
   */
    public MouseManager getMouseManager() {
        return mouseManager;
    }

    /*! \fn public synchronized void start()
        \brief Creaza si starteaza firul separat de executie (thread).

        Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
     */
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /*! \fn public synchronized void stop()
        \brief Opreste executie thread-ului.

        Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
     */
    public synchronized void stop() {
        if (!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*! \fn p  public State getLevel2State()
       \brief Returneaza starea level 2 a jocului.
    */
    public State getLevel2State() {
        return level2State;
    }


    /*! \fn public GameCamera getGameCamera()
       \brief Returneaza camera jocului, posibilitatea camerei de a urmari jucatorul.
    */
    public GameCamera getGameCamera() {
        return gameCamera;
    }

    /*! \fn public int getWidth()
       \brief Returneaza latimea ferestrei.
    */
    public int getWidth() {
        return width;
    }

    /*! \fn public int getHeight()
        \brief Returneaza inaltimea ferestrei.
     */
    public int getHeight() {
        return height;
    }

    /*! \fn  public State getGameState()
        \brief Returneaza referinta care joc.
     */
    public State getGameState() {
        return gameState;
    }

    /*! \fn  public void setGameState(State gameState)
        \brief Seteaza o noua referinta care joc.
     */
    public void setGameState(State gameState) {
        this.gameState = gameState;
    }

    /*! \fn  public State getMenuState()
        \brief Returneaza referinta catre meniu.
     */
    public State getMenuState() {
        return menuState;
    }

    /*! \fn  public void setMenuState(State menuState)
        \brief Seteaza o noua referinta catre meniu.
     */
    public void setMenuState(State menuState) {
        this.menuState = menuState;
    }

    /*! \fn  public State getOptionsState()
        \brief Returneaza referinta catre optiuni.
     */
    public State getOptionsState() {
        return optionsState;
    }

    /*! \fn  public void setOptionsState(State optionsState)
        \brief Seteaza o noua referinta catre optiuni.
     */
    public void setOptionsState(State optionsState) {
        this.optionsState = optionsState;
    }
}
