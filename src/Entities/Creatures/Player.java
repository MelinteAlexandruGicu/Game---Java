package Entities.Creatures;

import Entities.Entity;
import Entities.Statics.EndLevel;
import Graphics.*;
import MainGame.Game;
import MainGame.Handler;
import States.GameState;
import States.State;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class Player
    \brief Implementeaza notiunea de jucator.
 */
public class Player extends Creature {


    private Animations left, right, jump, down, basic; /*!< Obiect de tip Animation pentru tastele de miscare.*/

    private float startY, startX;/*!< Pozitie inițiala(coordonate x si y)*/

    /*! \fn public Player(Handler handler, float x, float y)
      \brief Constructor de initializare al clasei Player.

      Acest constructor primeste ca parametrii un obiect de tip Handler, coordonatele x si y.

      \param handler  Obiect de tip Handler
      \param x Coordonata x unde este plasat jucatorul.
      \param y Coordonata y unde este plasat jucatorul.
     */
    public Player(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
        startX = x;
        startY = y;

        bounds.x = 21;
        bounds.y = 30;
        bounds.width = 30;
        bounds.height = 35;//coliziuni

        right = new Animations(500, Assets.player_right);
        left = new Animations(500, Assets.player_left);
        jump = new Animations(500, Assets.player_jump);
        //down = new Animations(500, Assets.player_fall);
        basic = new Animations(500, Assets.player_basic);
    }

    /*! \fn @Override
            public void update()
     \brief  Actualizeaza starea elementelor din joc.
  */
    @Override
    public void update() {

        getInput();
        jumpUpdate();
        move();

        handler.getGameCamera().centerOnEntity(this);

        checkCollect1();

        checkOffScreen();

        //checkEndLevel();


    }

    /*! \fn public void runRight()
     \brief  Implementeaza miscarea la dreapta, facand si actualizare.
  */
    public void runRight(){
        right.update();
        xMove = speedX;
    }

    /*! \fn public void runLeft()
     \brief  Implementeaza miscarea la stanga, facand si actualizare.
  */
    public void runLeft(){
        left.update();
        xMove = -speedX;
    }

    /*! \fn public void jumpUpdate()
     \brief  Implementeaza saritura, facand si actualizare.
  */
    public void jumpUpdate(){
        if(!isOnFloor() && !isOnTop()){

               y -= gravity ;
               gravity -= 0.1;

        }
        else
            gravity = 0;
        jump.update();

}

    /*! \fn public void checkCollect1()
         \brief  Implementeaza colectarea obiectelor de pe mapa, verificand atat tastarea lui SPACE cat si coliziunile.
      */
private void checkCollect1(){
        Rectangle cb = getCollisionBounds(0,0);
        Rectangle cr = new Rectangle();
        int crSize = 20;
        cr.width = crSize;
        cr.height = crSize;

        if(handler.getKeyManager().space){
            cr.x = cb.x + cb.width / 2 - crSize / 2;
            cr.y = cb.y + cb.height;
        }
        else
            return;

        switch(Game.level) {
            case 1:
                for (Entity e : handler.getMap1().getEntityManager1().getEntities()) {
                    if (e.equals(this))
                        continue;
                    if (e.getCollisionBounds(0, 0).intersects(cr)) {
                        if (e.getId() == 1) {
                            e.hurt(1);
                            GameState.keys++;
                            GameState.score += 2500;
                        } else if (e.getId() == 2 && GameState.keys >= 8) {
                            Game.level ++;
                            if (State.getCurrentState() == handler.getGame().getGameState()) {
                                State.setCurrentState(handler.getGame().getLevel2State());
                                handler.getMouseManager().setUiManager(handler.getGame().getLevel2State().getUIManager());
                                GameState.keys = 0;
                            }
                            return;
                        }
                        return;
                    }
                }
                break;
            case 2:
                for (Entity e : handler.getMap1().getEntityManager2().getEntities()) {
                    if (e.equals(this))
                        continue;
                    if (e.getCollisionBounds(0, 0).intersects(cr)) {
                        if (e.getId() == 1) {
                            e.hurt(1);
                            GameState.keys++;
                            GameState.score += 2500;
                        } else if (e.getId() == 3 && GameState.keys == 17) {

                            JOptionPane.showMessageDialog(null, "Well done CHAMPION! You won both worlds! See you next time!\n\t\tYour FINAL score is: " + GameState.score);
                            System.exit(1);
                                GameState.keys = 0;
                                GameState.lifes = 3;
                                Game.level = 1;

                        }
                        return;
                    }
                }
                break;

        }
}

    /*! \fn public void checkOffScreen()
             \brief  Implementeaza posibilitatea de pierde un numar de vieti din joc, la depasirea coordonatei y cat si imposibilitatea de a merge spre o coordonata negativa a lui x.
          */
public void checkOffScreen(){
        if(y >= 730) {
            if(GameState.lifes != 1){
                GameState.lifes--;
            }
            else{
                die();
                x = startX;
                y = startY;
            }
            x = startX;
            y = startY;

        }
        if(x < 0){
            x = 0;
        }

}

    /*! \fn public void checkEndLevel()
             \brief  Verifica daca nivelul s-a terminat.
          */
public void checkEndLevel(){
    Rectangle cb = EndLevel.getBounds();

    if(getBounds().intersects(cb)){
        JOptionPane.showMessageDialog(null, "You lost! Try harder next time!Score: " + GameState.score);
    }
}

    /*! \fn @Override
                public void die()
         \brief  Metoda de terminare a jocului.
      */
    @Override
    public void die(){
        JOptionPane.showMessageDialog(null, "You lost! Try harder next time!\n\t\tSCORE:" + GameState.score);
        GameState.lifes = 3;
        GameState.keys = 0;
        Game.level = 1;
        if (State.getCurrentState() == handler.getGame().getGameState() || State.getCurrentState() == handler.getGame().getLevel2State()) {
            State.setCurrentState(handler.getGame().getMenuState());
            handler.getMouseManager().setUiManager(handler.getGame().getMenuState().getUIManager());
        }


    }

    /*! \fn @Override
                public int getId()
         \brief  Metoda de generare ID.
      */
    @Override
    public int getId() {
        return 0;
    }

    /*! \fn public void getInput()
                 \brief  Verifica si actualizeaza apasarea tastelor de mișcare.
              */
    private void getInput() {
        xMove = 0;
        yMove = 1;

        if (handler.getKeyManager().up)
        {
            //down.update();
            //jump.update();
//            if(isOnTop())
                jump();
            /*else
                y -= gravity;*/

        }
                //yMove = -speed;
       /* if(handler.getKeyManager().down)
            yMove = speedY;*/
        if (handler.getKeyManager().left)
//            xMove = -speed;
            runLeft();
        if (handler.getKeyManager().right)
            //xMove = speed;
            runRight();
    }

    /*! \fn  @Override
                public void draw(Graphics g)
           \brief  Deseneaza elementele pe ecran.

           \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
        */
    @Override
    public void draw(Graphics g) {
        g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
        /*g.setColor(Color.red);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y - handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
    */}

    /*! \fn  private BufferedImage getCurrentAniFrame()
          \brief  Returneaza frame-ul curent in functie de tastele apasate.

   */
    private BufferedImage getCurrentAnimationFrame() {
        if (xMove < 0) {
            return left.getCurrentFrame();
        } else if (xMove > 0) {
            return right.getCurrentFrame();
        } else if (yMove < 0) {
            return jump.getCurrentFrame();
        }/*else if(yMove > 0){
            return down.getCurrentFrame();
        }*/
        return basic.getCurrentFrame();
    }

    /*! \fn  @Override
                public Rectangle getBounds()
           \brief  Returneaza un dreptunghi in functie de coordonatele pentru verificarea notiunii de coliziune.
        */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(bounds.x, bounds.y, bounds.width, bounds.height);
    }
}

