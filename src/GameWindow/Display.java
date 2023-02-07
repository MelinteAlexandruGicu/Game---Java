package GameWindow;

import javax.swing.*;
import java.awt.*;

/*! \class Display
    \brief Implementează noțiunea de fereastră a jocului.

    Membrul wndFrame este un obiect de tip JFrame care va avea utilitatea unei
    ferestre grafice si totodata si cea a unui container (toate elementele
    grafice vor fi continute de fereastra).
 */
public class Display {
    private JFrame frame; /*!< Fereastra principala a jocului.*/

    private String title; /*!< Titlul ferestrei.*/

    private int width, height;  /*!< Latimea si inaltimea ferestrei in pixeli.*/

    private Canvas canvas;  /*!< "Panza/tablou" in care se poate desena*/

    /*! \fn public Display(String title, int width, int height)
            \brief Constructorul cu parametri al clasei Display.

            Retine proprietatile ferestrei proprietatile (titlu, latime, inaltime)
            in variabilele membre deoarece vor fi necesare pe parcursul jocului.
            Crearea obiectului va trebui urmata de crearea ferestrei propriuzise
            prin apelul metodei createDisplay().

            \param title Titlul ferestrei.
            \param width Latimea ferestrei in pixeli.
            \param height Inaltimea ferestrei in pixeli.
         */
    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        frame = null;
        createDisplay();
    }

    /*! \fn private void createDisplay()
        \brief Construieste/creaza fereastra si seteaza toate proprietatile
        necesare: dimensiuni, pozitionare in centrul ecranului, operatia de
        inchidere, invalideaza redimensionarea ferestrei, afiseaza fereastra.

     */
    private void createDisplay() {
        if (frame != null) {
            return;
        }

        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    /*! \fn public int getCanvas()
            \brief Returneaza referinta catre canvas-ul din fereastra pe care se poate desena.
         */
    public Canvas getCanvas() {
        return canvas;
    }

    /*! \fn  public int getHeight()
            \brief Returneaza inaltimea ferestrei.
         */
    public int getHeight() {
        return height;
    }

    /*! \fn public int getWidth()
        \brief Returneaza latimea ferestrei.
     */
    public int getWidth() {
        return width;
    }

    /*! \fn public int GetCanvas()
        \brief Returneaza referinta catre fereastra frame.
     */
    public JFrame getFrame() {
        return frame;
    }
}
