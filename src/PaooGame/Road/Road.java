package PaooGame.Road;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Player;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * This class describes a road.
 */
public class Road {
    private RefLinks refLinks;
    private BufferedImage RoadLayer1;
    private BufferedImage RoadLayer2;
    private final int WidthRoad=632;
    private final int HeightRoad=768;
    private int width;
    private int height;
    private int layer1;
    private int layer2;

    /**
     * Constructs a new instance.
     *
     * @param      refLinks  The reference links
     * @param      x         { pozitia x}
     * @param      y         { pozitia y}
     */
    public Road(RefLinks refLinks,int x,int y){
        this.refLinks=refLinks;
        this.width=x;
        this.height=y;
        RoadLayer1= Assets.Route;
        RoadLayer2= Assets.Route;
        layer1=0;
        layer2=-HeightRoad;
    }
    /**
     * fn Actualizeaza starea drumului
     *
     * @param      speed  The speed
     */
    public void Update(int speed){
        if(layer2+speed>=0){
            layer2=-HeightRoad;
            layer1=0;
        }
        else {
            layer1+=speed;
            layer2+=speed;
        }
    }

    /**
     * Deseneaza drumul
     *
     * @param      g     { parameter_description }
     */
    public void Draw(Graphics g){
        g.drawImage(RoadLayer1, 0, layer1, WidthRoad, HeightRoad, null);
        g.drawImage(RoadLayer2, 0, layer2, WidthRoad, HeightRoad, null);
    }
}
