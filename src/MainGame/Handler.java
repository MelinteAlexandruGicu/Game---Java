package MainGame;

import Graphics.GameCamera;
import Input.KeyManager;
import Input.MouseManager;
import Map.Map1;

import UI.UIManager;

/*! \class Handler
    \brief Clasa ce retine o serie de referinte ale unor elemente pentru a fi usor accesibile.

    Altfel ar trebui ca functiile respective sa aiba o serie intreaga de parametri si ar ingreuna programarea.
 */
public class Handler {

    private Game game; /*!< Referinta catre obiectul Game.*/
    private Map1 map1; /*!< Referinta catre harta 1.*/
    //private Map2 map2; /*!< Referinta catre harta 2.*/

    /*! \fn public Handler(Game game)
      \brief Constructor de initializare al clasei Handler.

      \param game Obiect de tip Game
   */
    public Handler(Game game) {
        this.game = game;
    }

    /*! \fn public KeyManager getKeyManager()
        \brief Returneaza referinta catre managerul evenimentelor de tastatura.
     */
    public KeyManager getKeyManager() {
        return game.getKeyManager();
    }

    /*! \fn public int getWidth()
       \brief Returneaza latimea ferestrei jocului.
    */
    public int getWidth() {
        return game.getWidth();
    }

    /*! \fn public int getHeight()
        \brief Returneaza inaltimea ferestrei jocului.
     */
    public int getHeight() {
        return game.getHeight();
    }

    /*! \fn public Game getGame()
        \brief Intoarce referinta catre obiectul Game.
     */
    public Game getGame() {
        return game;
    }

    /*! \fn public void setGame(Game game)
        \brief Seteaza referinta catre un obiect Game.

        \param game Referinta obiectului Game.
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /*! \fn public Map1 getMap1()
        \brief Intoarce referinta catre harta 1.
     */
    public Map1 getMap1() {
        return map1;
    }

   /* *//*! \fn public Map2 getMap2()
        \brief Intoarce referinta catre harta 2.
     *//*
    public Map2 getMap2() {
        return map2;
    }
*/
    /*! \fn public void setMap1(Map1 map1)
        \brief Seteaza referinta catre harta 1.

        \param map Referinta catre harta 1.
     */
    public void setMap1(Map1 map1) {
        this.map1 = map1;
    }

    /*! \fn public void setMap2(Map2 map2)
        \brief Seteaza referinta catre harta 2.

        \param map Referinta catre harta 2.
     *//*
    public void setMap2(Map2 map2) {
        this.map2 = map2;
    }
*/
    /*! \fn public GameCamera getGameCamera()
      \brief Metoda returneaza un obiect de tip Camera specific membrului game.
   */
    public GameCamera getGameCamera() {
        return game.getGameCamera();
    }

    /*! \fn public MouseManager getMouseManager()
       \brief Returneaza referinta catre managerul evenimentelor de mouse.
    */
    public MouseManager getMouseManager() {
        return game.getMouseManager();
    }

    /*! \fn public UIManager getUIManager()
      \brief Returneaza referinta catre Managerul de obiecte de la "User Interface".
   */
    public UIManager getUIManager() {
        return game.uiManager;
    }


}
