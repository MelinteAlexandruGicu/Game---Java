package UI;

import java.awt.*;
import java.awt.event.MouseEvent;

/*! \class UIObject
    \brief Implementeaza notiunea Obiect pentru "User Interface".

 */
public abstract class UIObject {

    protected float x, y; /*!< Variabile ce retin coordonatele obiectului(x si y).*/
    protected int width, height; /*!< Variabile ce retin latimea si inaltimea obiectului.*/
    protected Rectangle bounds; /*!< Variabila de tip dreptunghi(va ajuta la notiunea de coliziune intre obiecte.*/
    protected boolean hovering = false; /*!< Variabila de tip adevarat/fals ce retine daca pozitia cursorului pe obiect(true pentru cursor pe obiect, false pentru cursor inafara obiectului.*/

    /*! \fn public UIObject(float x, float y, int width, int height)
    \brief Constructor de initializare al clasei UIObject.

    Acest constructor primeste ca parametrii coordonatele x si y, latimea si inaltimea obiectului.

    \param x Coordonata x unde este plasat obiectul.
    \param y Coordonata y unde este plasat obiectul.
    \param width Latimea obiectului.
    \param height Inaltimea obiectului.
   */
    public UIObject(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        bounds = new Rectangle((int) x, (int) y, width, height);
    }

    /*! \fn public abstract void update()
        \brief  Actualizeaza starea obiectului pe "User Interface".
     */
    public abstract void update();

    /*! \fn public abstract void draw(Graphics g)
        \brief  Deseneaza obiectul pe "User Interface".
     */
    public abstract void draw(Graphics g);

    /*! \fn public abstract void onClick
        \brief  Implementeaza notiunea de click pe obiect.
     */
    public abstract void onClick();

    /*! \fn public  void onMouseMove(MouseEvent mouseEvent)
        \brief  Verifica coliziunea cursorului cu obiectul si seteaza valoarea de adevar a variabilei hovering.
     */
    public void onMouseMove(MouseEvent mouseEvent) {
        if (bounds.contains(mouseEvent.getX(), mouseEvent.getY()))
            hovering = true;
        else
            hovering = false;

    }

    /*! \fn  public void onMouseRelease(MouseEvent mouseEvent)
        \brief  Verifica valoarea de adevar a variabelei hovering, efectuand functia onClick() pentru situatia in care avem adevarat.
     */
    public void onMouseRelease(MouseEvent mouseEvent) {
        if (hovering)
            onClick();
    }

    /*! \fn  public float getX()
        \brief Returneaza pozitia pe coordonata x a obiectului.
     */
    public float getX() {
        return x;
    }

    /*! \fn  public void setX(float x)
        \brief Seteaza pozitia pe coordonata x a obiectului.
     */
    public void setX(float x) {
        this.x = x;
    }

    /*! \fn  public float getY()
        \brief Returneaza pozitia pe coordonata y a obiectului.
     */
    public float getY() {
        return y;
    }

    /*! \fn  public void setY(float y)
        \brief Seteaza pozitia pe coordonata y a obiectului.
     */
    public void setY(float y) {
        this.y = y;
    }

    /*! \fn   public int getWidth()
        \brief Returneaza latimea obiectului.
     */
    public int getWidth() {
        return width;
    }

    /*! \fn  public void setWidth(int width)
       \brief Seteaza latimea obiectului.
    */
    public void setWidth(int width) {
        this.width = width;
    }

    /*! \fn   public int getHeight()
       \brief Returneaza inaltimea obiectului.
    */
    public int getHeight() {
        return height;
    }

    /*! \fn  public void setHeight(int height)
       \brief Seteaza inaltimea obiectului.
    */
    public void setHeight(int height) {
        this.height = height;
    }

    /*! \fn  public boolean isHovering()
       \brief Returneaza valoarea de adevar a variabilei hovering.
    */
    public boolean isHovering() {
        return hovering;
    }

    /*! \fn  public void setHovering(boolean hovering)
       \brief Seteaza valoarea de adevar a variabilei hovering.
    */
    public void setHovering(boolean hovering) {
        this.hovering = hovering;
    }

}
