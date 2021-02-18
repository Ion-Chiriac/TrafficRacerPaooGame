package PaooGame.UserInteface;

import PaooGame.Input.MouseManager;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class UIManager {
    private ArrayList<UIObject> btn_objects;
    private MouseManager mouseManager;
    private RefLinks refLink;
    public UIManager(RefLinks refLink){
        btn_objects=new ArrayList<>();
        this.refLink=refLink;
        this.mouseManager=refLink.GetMouseManager();
    }

    /**
     * Updates the object.
     */
    public void Update(){
        for(UIObject obj:btn_objects){
            obj.Update();
        }
    }
    /**
     * { deseneaza obiectele ce reprezinta butoane }
     *
     * @param      g     { parameter_description }
     */
    public void Draw(Graphics g){
        for(UIObject obj:btn_objects){
            obj.Draw(g);
        }
    }
    /**
     * Called on mouse move.
     *
     * @param      mouseEvent  The mouse event
     */
    public void onMouseMove(MouseEvent mouseEvent){
        for(UIObject obj:btn_objects){
            obj.onMouseMove(mouseEvent);
        }
    }

    /**
     * Called on mouse release.
     *
     * @param      mouseEvent  The mouse event
     */
    public void onMouseRelease(MouseEvent mouseEvent)
    {
        for(UIObject obj : btn_objects)
        {
            obj.onMouseRelease(mouseEvent);
        }
    }

    /**
     * Adds an object.
     *
     * @param      obj   The object
     */
    public void addObject(UIObject obj)
    {
        btn_objects.add(obj);
    }

    /**
     * Removes an object.
     *
     * @param      obj   The object
     */
    public void removeObject(UIObject obj)
    {
        if(btn_objects.contains(obj))
        {
            btn_objects.remove(obj);
        }
    }

    /**
     * Gets the objects.
     *
     * @return     The objects.
     */
    public ArrayList<UIObject> getObjects()
    {
        return btn_objects;
    }
}
