package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class UIImageOptions
    \brief Implementeaza un obiect de tip UIImageOptions pentru "User Interface".

 */
public class UIImageOptions extends UIObject {

    private BufferedImage image; /*!< Referinta catre obiectul BufferedImage ce contine imaginea.*/

    /*! \fn public UIImageOptions(float x, float y, int width, int height, BufferedImage image)
        \brief Constructor, initializeaza un obiect-imagine pentru "User Interface".

        \param x Coordonata x a obiectului.
        \param y Coordonata y a obiectului.
        \param width Latimea obiectului.
        \param height Inaltimea obiectului.
        image un obiect BufferedImage valid.
     */
    public UIImageOptions(float x, float y, int width, int height, BufferedImage image) {
        super(x, y, width, height);
        this.image = image;

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
        \brief  Deseneaza obiectele.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void draw(Graphics g) {
        g.drawImage(image, (int) x, (int) y, width, height, null);

    }

    /*! \fn @Override
               public void onClick()
        \brief   Implementeaza notiunea de click pe obiect.
     */
    @Override
    public void onClick() {
    }
}
