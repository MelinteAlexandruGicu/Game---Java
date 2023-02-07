package Input;

import UI.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/*! \class MouseManager implements MouseListener, MouseMotionListener
    \brief Gestioneaza intrarea (input-ul) de la mouse.

    Clasa citeste daca au fost apasat un click, stabiliteste ce click a fost actionat si seteaza corespunzator un flag.
    In program trebuie sa se tina cont de flagul aferent click-ului de interes. Daca flagul respectiv este true inseamna
    ca click-ul respectiv a fost apasata si false nu a fost apasat.
 */
public class MouseManager implements MouseListener, MouseMotionListener {

    private boolean leftPressed, rightPressed; /*!< Flag-uri pentru click stanga/dreapta apasat.*/
    private int mouseX, mouseY; /*!< Pozitia cursorului pe orizontala si verticala.*/
    private UIManager uiManager; /*!< Referinta catre un obiect de tip UIManager.*/

    /*! \fn  public MouseManager()
        \brief Constructorul clasei.
     */
    public MouseManager() {
    }

    /*! \fn  public void setUiManager(UIManager uiManager)
       \brief Seteaza obiectul de tip UIManager.
    */
    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }

    /*! \fn  public boolean isLeftPressed()
       \brief Returneaza flag-ul de click stanga.
    */
    public boolean isLeftPressed() {
        return leftPressed;
    }

    /*! \fn  public boolean isRightPressed()
      \brief Returneaza flag-ul de click dreapta.
   */
    public boolean isRightPressed() {
        return rightPressed;
    }

    /*! \fn  public int getMouseX()
       \brief Returneaza pozitia x a cursorului.
    */
    public int getMouseX() {
        return mouseX;
    }

    /*! \fn  public int getMouseX()
      \brief Returneaza pozitia y a cursorului.
   */
    public int getMouseY() {
        return mouseY;
    }

    /*! \fn public void mousePressed(MouseEvent mouseEvent)
        \brief Functie ce va fi apelata atunci cand un un eveniment de mouse apasat este generat.

         \param mouseEvent obiectul eveniment de mouse.
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1)
            leftPressed = true;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3)
            rightPressed = true;
    }

    /*! \fn public void mouseReleased(MouseEvent mouseEvent)
        \brief Functie ce va fi apelata atunci cand un un eveniment de mouse eliberat este generat.

         \param mouseEvent obiectul eveniment de mouse.
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseEvent.BUTTON1)
            leftPressed = false;
        else if (mouseEvent.getButton() == MouseEvent.BUTTON3)
            rightPressed = false;

        if (uiManager != null)
            uiManager.onMouseRelease(mouseEvent);
    }

    /*! \fn public void mouseMoved(MouseEvent mouseEvent)
           \brief Functie ce va fi apelata atunci cand un un eveniment de mouse este mutat.

            \param mouseEvent obiectul eveniment de mouse.
        */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();
        mouseY = mouseEvent.getY();

        if (uiManager != null)
            uiManager.onMouseMove(mouseEvent);
    }

    /*! \fn public void mouseEntered(MouseEvent mouseEvent)
           \brief Functie ce va fi apelata atunci cand un un eveniment de mouse introdus.

            \param mouseEvent obiectul eveniment de mouse.
        */
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    /*! \fn public void mouseExited(MouseEvent mouseEvent)
           \brief Functie ce va fi apelata atunci cand un un eveniment de mouse isi termina executia.

            \param mouseEvent obiectul eveniment de mouse.
        */
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    /*! \fn public void mouseDragged(MouseEvent mouseEvent)
          \brief Functie ce va fi apelata atunci cand un un eveniment de mouse este apasat si mutat.

           \param mouseEvent obiectul eveniment de mouse.
       */
    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    /*! \fn public void mouseDragged(MouseEvent mouseEvent)
          \brief Functie ce va fi apelata atunci cand un un eveniment de mouse este apasat.

           \param mouseEvent obiectul eveniment de mouse.
       */
    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

}
