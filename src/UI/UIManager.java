package UI;

import MainGame.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/*! \class UIManager
    \brief Implementeaza notiunea manager de obiecte pentru "User Interface".

 */
public class UIManager {

    private Handler handler; /*!< Variabila de tip Handler.*/
    private ArrayList<UIObject> objects; /*!< Lista de obiecte, implemanta cu notiunea de vector.*/

    /*! \fn public UIManager(Handler handler)
               \brief Constructor de initializare al clasei UIManager.

               Acest constructor primeste ca parametri un handler.

               \param handler Un obiect de tip Handler.
            */
    public UIManager(Handler handler) {
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    /*! \fn public void update()
              \brief Actualizeaza obiectele de tip UIObject
           */
    public void update() {
        for (UIObject o : objects)
            o.update();

    }

    /*! \fn public void draw(Graphics g)
              \brief Deseneaza obiectele de tip UIObject.

              \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
           */
    public void draw(Graphics g) {
        for (UIObject o : objects)
            o.draw(g);
    }

    /*! \fn public Handler getHandler()
              \brief Returneaza variabila handler.
           */
    public Handler getHandler() {
        return handler;
    }

    /*! \fn public void setHandler(Handler handler
              \brief Seteaza variabila handler.
           */
    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    /*! \fn public ArrayList<UIObject> getObjects()
              \brief Returneaza vectorul de obiecte.
           */
    public ArrayList<UIObject> getObjects() {
        return objects;
    }

    /*! \fn public void setObjects(ArrayList<UIObject> objects)
              \brief Seteaza vectorul de obiecte.
           */
    public void setObjects(ArrayList<UIObject> objects) {
        this.objects = objects;
    }

    /*! \fn public  void onMouseMove(MouseEvent mouseEvent)
       \brief  Verifica miscarea cursorului printre obiecte.
    */
    public void onMouseMove(MouseEvent mouseEvent) {
        for (UIObject o : objects)
            o.onMouseMove(mouseEvent);
    }

    /*! \fn   public void onMouseRelease(MouseEvent mouseEvent)
       \brief  Verifica apasarea cursorului pe obiecte.
    */
    public void onMouseRelease(MouseEvent mouseEvent) {
        for (UIObject o : objects)
            o.onMouseRelease(mouseEvent);
    }

    /*! \fn   public void addObject(UIObject o)
      \brief  Adauga un obiect.
   */
    public void addObject(UIObject o) {
        objects.add(o);
    }

    /*! \fn   public void removeObject(UIObject o)
     \brief  Elimina un obiect.
  */
    public void removeObject(UIObject o) {
        objects.remove(o);
    }
}
