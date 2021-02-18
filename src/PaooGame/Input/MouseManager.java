package PaooGame.Input;

import PaooGame.UserInteface.UIManager;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * This class describes a mouse manager.
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    private boolean leftPressed;
    private boolean rightPressed;
    private UIManager uiManager;
    private int mouseX;
    private int mouseY;

    /**
     * Sets the user interface manager.
     *
     * @param      uiManager  The manager
     */
    public void setUiManager(UIManager uiManager) {
        this.uiManager = uiManager;
    }
    /**
     * Determines if left pressed.
     *
     * @return     True if left pressed, False otherwise.
     */
    public boolean isLeftPressed(){
        return leftPressed;
    }

    /**
     * Determines if right pressed.
     *
     * @return     True if right pressed, False otherwise.
     */
    public boolean isRightPressed() {
        return rightPressed;
    }

    /**
     * Gets the mouse x.
     *
     * @return     The mouse x.
     */
    public int getMouseX() {
        return mouseX;
    }

    /**
     * Gets the mouse y.
     *
     * @return     The mouse y.
     */
    public int getMouseY() {
        return mouseY;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    /**
     * Functie ce va fi apelata atunci cand un eveniment de mouse apasat este generat.
     *
     * @param      mouseEvent  The mouse event
     */
    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        if(mouseEvent.getButton()==MouseEvent.BUTTON1){
            leftPressed=true;
        }
        if(mouseEvent.getButton()==MouseEvent.BUTTON3){
            rightPressed=true;
        }
    }

    /**
     * Functie ce va fi apelata atunci cand un eveniment de mouse eliberat este generat.
     *
     * @param      mouseEvent  The mouse event
     */
    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        if(mouseEvent.getButton()==MouseEvent.BUTTON1){
            leftPressed=false;
        }
        if(mouseEvent.getButton()==MouseEvent.BUTTON3){
            rightPressed=false;
        }
        if(uiManager!=null)
        {
            uiManager.onMouseRelease(mouseEvent);
        }
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {

    }

    /**
     * Functie ce va fi apelata atunci cand un eveniment de mouse miscat este generat.
     *
     * @param      mouseEvent  The mouse event
     */
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        mouseX=mouseEvent.getX();
        mouseY=mouseEvent.getY();
        if(uiManager!=null)
        {
            uiManager.onMouseMove(mouseEvent);
        }
    }
}
