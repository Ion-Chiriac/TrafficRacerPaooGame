package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UserInteface.UIImageButton;
import PaooGame.UserInteface.UIManager;

import java.awt.*;
import PaooGame.Settings.Level;

/*! \class public class SettingsState extends State
    \brief Implementeaza notiunea de settings pentru joc.

    Aici setarile vor trebui salvate/incarcate intr-un/dintr-un fisier/baza de date sqlite.
 */
public class SettingsState extends State
{
    /*! \fn public SettingsState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.
        \fn agauba toate obiectele ce reprezinta setarile jocului
        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public SettingsState(RefLinks refLink)
    {
            ///Apel al construcotrului clasei de baza.
        super(refLink);
        uiManager=new UIManager(refLink);
        uiManager.addObject(new UIImageButton(Assets.buttonBack, 500, 704, 64, 64) {
            @Override
            public void onClick() {
                System.out.println("Click Back");
                State.SetState(refLink.GetGame().getMenuState());
            }
        });
        uiManager.addObject(new UIImageButton(Assets.buttonWinterRoad, 50, 350, 250, 50) {
            @Override
            public void onClick() {
                System.out.println("Click buttonWinterRoad");
                //State.SetState(refLink.GetGame().getMenuState());
                Assets.Route=Assets.WinterRoad;
            }
        });
        uiManager.addObject(new UIImageButton(Assets.buttonSummerRoad, 332, 350, 250, 50)  {
            @Override
            public void onClick() {
                System.out.println("Click buttonSummerRoad");
                Assets.Route=Assets.SummerRoad;
            }
        });
        ///////
        uiManager.addObject(new UIImageButton(Assets.buttonLevel1, 8, 500, 200, 200)  {
            @Override
            public void onClick() {
                System.out.println("Click buttonLevel1");
                refLink.setLevel(Level.LEVEL1);
            }
        });
        uiManager.addObject(new UIImageButton(Assets.buttonLevel2, 216, 500, 200, 200)  {
            @Override
            public void onClick() {
                System.out.println("Click buttonLevel2");
                refLink.setLevel(Level.LEVEL2);
            }
        });
        uiManager.addObject(new UIImageButton(Assets.buttonLevel3, 424, 500, 200, 200)  {
            @Override
            public void onClick() {
                System.out.println("Click buttonLevel3");
                refLink.setLevel(Level.LEVEL3);
            }
        });
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea setarilor.
     */
    @Override
    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran setarile.

        \param g Contextul grafic in care trebuie sa deseneze starea setarilor pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0,0,refLink.GetWidth(),refLink.GetHeight());
        g.setColor(Color.BLACK);
        Font font=new Font("Arial",Font.BOLD,40);
        g.setFont(font);
        g.drawString("Please choose the game map",50,70);
        g.drawImage(Assets.WinterRoad,50,100,250,250,null);
        g.drawImage(Assets.SummerRoad,332,100,250,250,null);
        g.drawString("      Please choose level",50,480);


        uiManager.Draw(g);
    }
    public void NewState(){

    };
}
