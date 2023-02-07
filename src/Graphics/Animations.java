package Graphics;

import java.awt.image.BufferedImage;

/*! \class Animations
    \brief Clasa incarca animatiile(frame-urile) jucatorului.

 */
public class Animations {
    private int speed, index;  /*!< Referinte catre viteza si index.*/
    private long lastTime, timer; /*!< Referinte catre timpul precedent si timpul actual.*/
    private BufferedImage[] frames; /*!< Referinta catre vector de frame-uri de tip BufferedImage*/

    /*! \fn  public Animations(int speed, BufferedImage[] frames)
        \brief Constructor, initializeaza Animatiile..

        \param speed Viteza.
        \param frames Vector de BufferdImage.
     */
    public Animations(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        timer = 0;
        lastTime = System.currentTimeMillis();
    }

    /*! \fn  public void update())
          \brief Acutalizeaza animatiile.
       */
    public void update(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if(timer > speed){
            index++;
            timer = 0;
            if(index >= frames.length)
                index = 0;
        }
    }

    /*! \fn  public BufferedImage getCurrentFrame()
          \brief Returneaza frame-ul curent.
       */
    public BufferedImage getCurrentFrame(){
        return frames[index];
    }
}
