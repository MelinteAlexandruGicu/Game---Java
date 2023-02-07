package States;

import MainGame.Handler;

import java.awt.*;

import Graphics.*;
import UI.UIImageButton;
import UI.UIImageOptions;
import UI.UIManager;

/*! \class OptionsState extends State
    \brief Implementeaza ideea de optiuni prezente in joc.

*/
public class OptionsState extends State {

    private UIManager uiManager; /*!< Membru de tip UIManager*/

    /*! \fn public OptionsState(Handler handler)
               \brief Constructor de initializare a clasei OptionsState.

               \param handler Obiect de tip Handler

         */
    public OptionsState(Handler handler) {
        super(handler);
        uiManager = new UIManager(handler);
        uiManager.addObject(new UIImageOptions(0, 0, 865, 850, Assets.optionsMenu));
        uiManager.addObject(new UIImageButton(800, 0, 62, 62, Assets.back_button, () -> {
            if (State.getCurrentState() == handler.getGame().getOptionsState()) {
                State.setCurrentState(handler.getGame().getMenuState());
                handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
            }
        }));

        uiManager.addObject(new UIImageButton(650, 550, 200, 200, Assets.start_button, () -> {
            if (State.getCurrentState() == handler.getGame().getOptionsState()) {
                State.setCurrentState(handler.getGame().newGame());
                handler.getMouseManager().setUiManager(handler.getGame().getGameState().getUIManager());
            }
        }));
    }

    /*! \fn @Override
                public void update();
              \brief Actualizeaza starea curenta a meniului
        */
    @Override
    public void update() {
        uiManager.update();
    }

    /*! \fn @Override
                public void draw(Graphics g)
              \brief Deseneaza pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
        */
    @Override
    public void draw(Graphics g) {
        //g.drawImage(image, 20, 20, null);
        uiManager.draw(g);
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
