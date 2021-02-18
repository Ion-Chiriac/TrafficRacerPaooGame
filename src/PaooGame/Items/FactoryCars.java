package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.Settings.Level;
import PaooGame.States.PlayState;

/**
 * This class describes factory cars.
*/
public class FactoryCars {
    
    /**
     * Generate new car
     *
     * @param      refLinks  The reference links
     * @param      car       The car
     * @param      x         { pozitia x pe drum}
     * @param      y         { pozitia y pe drum }
     *
     * @return     { description_of_the_return_value }
     */
    public Car Generate(RefLinks refLinks,String car,float x,float y){
        if(car.equalsIgnoreCase("player")){
            return new Player(refLinks, x,y);
        }
        if(car.equalsIgnoreCase("enemy")){
            return new Enemy(refLinks,x,y);
        }
        return null;
    }
}
