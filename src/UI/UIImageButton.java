package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class UIImageButton
    \brief Implementeaza un obiect de tip UIImageButton pentru "User Interface".

 */
public class UIImageButton extends UIObject {

    private BufferedImage[] images; /*!< Vector de obiecte BufferedImage ce contine imagini.*/
    private ClickListener clicker; /*!< Referinta catre obiectul ClickListener.*/

    /*! \fn  public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker)
        \brief Constructor, initializeaza un obiect de tip UIImageButton pentru "User Interface".

        \param x Coordonata x a obiectului.
        \param y Coordonata y a obiectului.
        \param width Latimea obiectului.
        \param height Inaltimea obiectului.
        images vector de obiecte BufferedImage valid.
        clicker obiect de tip ClickListener valid.
     */
    public UIImageButton(float x, float y, int width, int height, BufferedImage[] images, ClickListener clicker) {
        super(x, y, width, height);
        this.images = images;
        this.clicker = clicker;
    }

    /*! \fn @Override
               public void update()
        \brief  Actualizeaza obiectele.
     */
    @Override
    public void update() {

    }

    /*! \fn @Override
               public void draw(Graphics g)
        \brief  Deseneaza obiectele atata timp cat valoarea de adevar a variabelei hovering este setata pe valoarea de adevarat.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void draw(Graphics g) {
        if (hovering) {
            g.drawImage(images[1], (int) x, (int) y, width, height, null);
        } else {
            g.drawImage(images[0], (int) x, (int) y, width, height, null);
        }
    }

    /*! \fn @Override
               public void onClick()
        \brief   Implementeaza notiunea de click pe obiect afisand un mesaj.
     */
    @Override
    public void onClick() {

        System.out.println("S-a apasat!");
        clicker.onClick();
    }
}
