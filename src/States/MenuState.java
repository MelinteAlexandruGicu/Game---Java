package States;

import MainGame.Handler;
import UI.UIImageButton;
import UI.UIImageOptions;
import UI.UIManager;
import Graphics.*;

import java.awt.*;

/*! \class MenuState extends State
    \brief Implementeaza notiunea de meniu pentru joc.
 */
public class MenuState extends State {
    private UIManager uiManager; /*!< Referinta catre un obiect de tip UIManager.*/

    /*! \fn public MenuState(Handler handler)
        \brief Constructorul de initializare al clasei.

        \param handler O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public MenuState(Handler handler) {
        ///Apel al constructorului clasei de baza.
        super(handler);

        uiManager = new UIManager(handler);
        handler.getMouseManager().setUiManager(uiManager);

        uiManager.addObject(new UIImageOptions(0, 0, 890, 720, Assets.bkgMenu));

        uiManager.addObject(new UIImageButton(300, 100, 300, 250, Assets.start_button, () -> {
            if (State.getCurrentState() == handler.getGame().getMenuState()) {
                State.setCurrentState(handler.getGame().newGame());
                handler.getMouseManager().setUiManager(handler.getGame().getGameState().getUIManager());
            }
        }));

        uiManager.addObject(new UIImageButton(300, 300, 300, 250, Assets.options_button, () -> {
            if (State.getCurrentState() == handler.getGame().getMenuState()) {
                State.setCurrentState(handler.getGame().getOptionsState());
                handler.getMouseManager().setUiManager(handler.getGame().getOptionsState().getUIManager());
            }
        }));

        uiManager.addObject(new UIImageButton(300, 500, 300, 250, Assets.exit_button, () -> {
            if (State.getCurrentState() == handler.getGame().getMenuState()) {
                System.exit(1);
            }
        }));
    }

    /*! \fn @Override
                public void update()
        \brief Actualizeaza starea curenta a meniului.
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
        uiManager.draw(g);
    }

    /*! \fn @Override
                 public UIManager getUIManager()
              \brief Returneaza obiectul de tip UIManager.
        */
    @Override
    public UIManager getUIManager() {
        return this.uiManager;
    }

}
