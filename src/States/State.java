package States;

import MainGame.Game;
import MainGame.Handler;
import UI.UIManager;

import java.awt.*;
import java.io.PipedOutputStream;

/*! \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.

    Un joc odata ce este lansat in executie nu trebuie "sa arunce jucatorul direct in lupta", este nevoie de
    un meniu care sa contine optiuni: New Game, Load Game, Settings, About etc. Toate aceste optiuni nu sunt altceva
    decat stari ale programului (jocului) ce trebuiesc incarcate si afisate functie de starea curenta.
 */
public abstract class State {
    private static State currentState = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    public static boolean menustate = false; /*!< Membru static cu valoare de adevar pentru menuState.*/

    /*! \fn ublic static void setMenustate(boolean menustate)
                  \brief Seteaza menustate.
            */
    public static void setMenustate(boolean menustate) {
        State.menustate = menustate;
    }

    //CLASS
    protected Handler handler; /*!< Referinta catreun obiect de tip Handler*/

    /*! \fn public State(Handler handler)
           \brief Constructor de initializare al clasei State.

           Acest constructor primeste ca parametru un obiect de tip Handler .

           \param handler Obiect de tip Handler

     */
    public State(Handler handler) {
        this.handler = handler;
    }

    /*! \fn public abstract void update();
              \brief Metoda de actualizare si este implementata de clasele ce o extind.
        */
    public abstract void update();

    /*! \fn public abstract void render(Graphics g);
              \brief Metoda de randare si este implementata de clasele ce o extind.
        */
    public abstract void draw(Graphics g);

    /*! \fn public static void setCurrentState(State state)
       \brief Seteaza starea curenta a jocului.

       \param state Noua stare a programului (jocului).
    */
    public static void setCurrentState(State state) {
        currentState = state;
    }

    /*! \fn  public static State getCurrentState())
           \brief Returneaza starea curenta a jocului.
        */
    public static State getCurrentState() {
        return currentState;
    }

    /*! \fn public abstract UIManager getUIManager()
                  \brief Metoda abstracta ce va fi implementata de clasele ce o extind.
            */
    public abstract UIManager getUIManager();
}
