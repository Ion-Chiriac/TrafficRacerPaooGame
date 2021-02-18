package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class describes a car.
 */
public class Car extends Character {
    protected BufferedImage image;
    protected String car;
    public Car(RefLinks refLink, float x, float y){
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
    }
    @Override
    public void Update()
    {
        ///Verifica daca a fost apasata o tasta
        GetInput();
        ///Actualizeaza pozitia
        Move();
    }

    /**
     * Actualizeaza pozitia pe coordonata x
     */
    public void MoveX(){}
    
    /**
     * Actualizeaza pozitia pe coordonata x
     */
    public void MoveY(){}
    
    /**
     * Verifica apasarea unei tastw
     */
    public void GetInput(){}

    /**
     * Sets the image.
     *
     * @param      image  The image
     */
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    /**
     * Deseneaza masina
     *
     * @param      g     { parameter_description }
     */
    public void Draw(Graphics g){
        g.drawImage(image,(int)x,(int)y, Character.DEFAULT_CREATURE_WIDTH,Character.DEFAULT_CREATURE_HEIGHT,null);
    }

}
