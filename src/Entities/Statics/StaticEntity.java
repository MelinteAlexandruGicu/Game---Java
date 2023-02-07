package Entities.Statics;

import Entities.Entity;
import MainGame.Handler;

/*! \class StaticEntity extends Entity
    \brief Defineste notiunea abstracta de cheie/viata/steag din joc.
 */
public abstract class StaticEntity extends Entity {
    /* \fn public StaticEntity(Handler handler, float x, float y, int width, int height)
    \brief Constructor de initializare a unei entitati Statice(care nu are miscare).

    \param handler Un obiect de tip Handler.
    \param x Coordonata pe orizontala.
    \param y Coordonata pe verticala.
    \param width Latimea entitatii.
    \param height Inaltimea entitatii
 */
    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }
}
