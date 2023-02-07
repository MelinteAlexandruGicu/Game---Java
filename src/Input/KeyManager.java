package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*! \class KeyManager implements KeyListener
    \brief Gestioneaza intrarea (input-ul) de tastatura.

    Clasa citeste daca au fost apasata o tasta, stabiliteste ce tasta a fost actionata si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent tastei de interes. Daca flagul respectiv este true inseamna
    ca tasta respectiva a fost apasata si false nu a fost apasata.
 */
public class KeyManager implements KeyListener {

    private boolean[] keys; /*!< Vector de flaguri pentru toate tastele. Tastele vor fi regasite dupa cod [0 - 255]*/
    public boolean up, down, left, right, space, z; /*!< Flag-uri pentru sus, jos, stanga, dreapta, space si z apasate*/

    /*! \fn public KeyManager()
        \brief Constructorul clasei.
     */
    public KeyManager() {
        keys = new boolean[256];
    }

    /*! \fn public void update()
        \brief Acutalizeaza apasarea tastelor.
     */
    public void update() {
        up = keys[KeyEvent.VK_UP];
        //down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        space = keys[KeyEvent.VK_SPACE];
        z = keys[KeyEvent.VK_Z];
    }

    /*! \fn public void keyPressed(KeyEvent e)
       \brief Functie ce va fi apelata atunci cand un un eveniment de tasta apasata este generat.

        \param e obiectul eveniment de tastatura.
    */
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = true;
        System.out.println("Pressed!");
    }

    /*! \fn public void keyReleased(KeyEvent e)
        \brief Functie ce va fi apelata atunci cand un un eveniment de tasta eliberata este generat.

         \param e obiectul eveniment de tastatura.
     */
    @Override
    public void keyReleased(KeyEvent keyEvent) {
        keys[keyEvent.getKeyCode()] = false;
    }

    /*! \fn public void keyTyped(KeyEvent e)
            \brief Functie ce va fi apelata atunci cand o tasta a fost apasata si eliberata.
            Momentan aceasta functie nu este utila in program.
         */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }
}
