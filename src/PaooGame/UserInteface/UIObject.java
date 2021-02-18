package PaooGame.UserInteface;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * This class describes an ui object.
 */
public abstract class UIObject {
    protected float x,y;
    protected int width,height;
    protected boolean press;
    protected Rectangle bounds;

    /**
     * Constructs a new instance.
     *
     * @param      x       { position x }
     * @param      y       { position y }
     * @param      width   The width
     * @param      height  The height
     */
    public UIObject(float x,float y,int width,int height){
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        bounds=new Rectangle((int)x,(int)y,width,height);
    }
    public abstract void Update();

    public abstract void Draw(Graphics g);

    public abstract void onClick();
    /**
     * Called on mouse move.
     *
     * @param      mouseEvent  The mouse event
     */
    public void onMouseMove(MouseEvent mouseEvent) {
        if(bounds.contains(mouseEvent.getX(), mouseEvent.getY())) {
            press=true;
        }
        else {
            press=false;
        }
    }

    /**
     * Called on mouse release.
     *
     * @param      mouseEvent  The mouse event
     */
    public void onMouseRelease(MouseEvent mouseEvent) {
        if(press) {
            onClick();
        }
    }
}

