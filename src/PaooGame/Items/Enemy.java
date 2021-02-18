package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class describes an enemy.
 */
public class Enemy extends Car{
   
   /**
    * Constructs a new instance.
    *
    * @param      refLinks  The reference links
    * @param      x         { pozitia x pe drum}
    * @param      y         { pozitia y pe drum }
    */
    public Enemy(RefLinks refLinks,float x,float y){
       super(refLinks,x,y);
       image = Assets.Enemy[(int)(Math.random()*9)];
    }
    
    /**
     * Actualizeaza pozitia adversarului
     */
    public void MoveY() {
        y += yMove;
    }
    
    /**
     * Sets the image.
     */
    public void SetImage(){
        image=Assets.Enemy[(int)(Math.random()*9)];
    }

}
