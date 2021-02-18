package PaooGame.UserInteface;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class describes an ui image button.
 */
public abstract class UIImageButton extends UIObject{
    private BufferedImage image;
    public UIImageButton(BufferedImage image,int x,int y,int width,int height){
        super(x,y,width,height);
        this.image=image;
    }

    @Override
    public void Update() {

    }

    /**
     * fn deseanza imaginea botonului
     *
     * @param      g     { parameter_description }
     */
    @Override
    public void Draw(Graphics g) {
        g.drawImage(image,(int)x,(int)y,width,height,null);
    }
}
