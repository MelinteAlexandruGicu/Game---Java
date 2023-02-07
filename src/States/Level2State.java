package States;

import Graphics.*;
import MainGame.Game;
import MainGame.Handler;
import Map.Map1;
import UI.UIImageButton;
import UI.UIImageOptions;
import UI.UIManager;

import java.awt.*;

/*! \class Level2State extends State
    \brief Implementeaza/controleaza jocul(nivelul 2).
 */
public class Level2State extends State {

    private Map1 map1; /*!< Referinta catre harta 2.*/
    private UIManager uiManager; /*!< Referinta catre un obiect de tip UIManager.*/

    /*! \fn public Level2State(Handler handler)
         \brief Constructorul de initializare al clasei

         \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
      */
    public Level2State(Handler handler) {
        super(handler);
        map1 = new Map1(handler, "res/maps/map2.txt");
        handler.setMap1(map1);
        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);
        uiManager.addObject(new UIImageButton(823, 0, 40, 40, Assets.back_button, () -> {
            if (State.getCurrentState() == handler.getGame().getLevel2State()) {
                State.setCurrentState(handler.getGame().getMenuState());
                handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
            }
        }));
    }



    /*! \fn @Override
               public void update()
       \brief Actualizeaza starea curenta a meniului.
    */
    @Override
    public void update() {
        map1.update();
        //handler.getMap1().getEntityManager().removeEntity();
        handler.setMap1(this.map1);
        uiManager.update();

        }
    //System.out.println(handler.getMouseManager().getMouseX() + "    " + handler.getMouseManager().getMouseY());

    /*! \fn @Override
               public void draw(Graphics g)
             \brief Deseneaza pe ecran starea curenta a meniului.

       \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
       */
    @Override
    public void draw(Graphics g) {
        //g.clearRect(0, 0, 900,900);
        g.drawImage(Assets.bkggame,0,0, 1500, 900, null);
        map1.draw(g);
        uiManager.draw(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 823, 40);


        g.setColor(Color.red);
        g.setFont(new Font("Script", Font.BOLD, 20));
        g.drawString("Hearts: " + GameState.lifes, 0, 30);
        g.drawImage(Assets.life_full, 80, 0, 48, 48, null);


        g.setColor(Color.blue);

        g.setFont(new Font("Script", Font.BOLD, 20));
        //g.drawImage(Assets.key,0,25,48,48,null);
        g.drawString("Keys: " + GameState.keys + " / 17", 150, 30);
        g.drawImage(Assets.key, 265, 0, 48, 48, null);

        g.setColor(Color.orange);
        g.drawString("Score -> " + GameState.score + " POINTS", 400, 30);

        g.setColor(Color.black);

        g.setFont(new Font("Script", Font.BOLD, 20));
        g.drawString("L E V E L " + Game.level, 680, 30);
    }

    /*! \fn @Override
                 public UIManager getUIManager()
              \brief Returneaza obiectul de tip UIManager.
        */
    @Override
    public UIManager getUIManager() {
        return uiManager;
    }

}
