package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.UserInteface.UIImageButton;
import PaooGame.UserInteface.UIManager;

import java.awt.*;

/*! \class public class MenuState extends State
    \brief Implementeaza notiunea de menu pentru joc.
 */
public class MenuState extends State
{
    /*! \fn public MenuState(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    //Graphics g;
    public MenuState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza.
        super(refLink);
        // se adauga toate obiectele pentru meniul jocului
        uiManager=new UIManager(refLink);
        uiManager.addObject(new UIImageButton(Assets.buttonNewGame, (refLink.GetWidth()-300)/2, 200, 300, 50) {
            @Override
            public void onClick() {
                System.out.println("Click NewGame");
                refLink.GetGame().getPlayState().NewState();
                State.SetState(refLink.GetGame().getPlayState());
            }
        });

        
        uiManager.addObject(new UIImageButton(Assets.buttonResumeGame, (refLink.GetWidth()-300)/2, 300, 300, 50) {
            @Override
            public void onClick() {
                System.out.println("Click ResumeGame");
                if(refLink.GetGame().getPlayState()!=null)
                    State.SetState(refLink.GetGame().getPlayState());
                else{
                    refLink.GetGame().getPlayState().NewState();
                    State.SetState(refLink.GetGame().getPlayState());
                }

            }

        });

        uiManager.addObject(new UIImageButton(Assets.buttonSettings, (refLink.GetWidth()-300)/2, 400, 300, 50) {
            @Override
            public void onClick() {
                System.out.println("Click Settings");
                State.SetState(refLink.GetGame().getSettingsState());
            }
        });

        uiManager.addObject(new UIImageButton(Assets.buttonAbout, (refLink.GetWidth()-300)/2, 500, 300, 50) {
            @Override
            public void onClick() {
                System.out.println("Click About");
                State.SetState(refLink.GetGame().getAboutState());
            }
        });

        uiManager.addObject(new UIImageButton(Assets.buttonExit, (refLink.GetWidth()-300)/2, 600, 300, 50) {
            @Override
            public void onClick() {
                System.out.println("Click Exit");
                refLink.GetGame().StopGame();
                System.exit(0);
            }
        });
    }
    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a meniului.
     */
    @Override
    public void Update()
    {
        uiManager.Update();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a meniului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        g.drawImage(Assets.backgroundMenu,0,0,refLink.GetWidth(),refLink.GetHeight(),null);
        uiManager.Draw(g);

    }
    public void NewState(){

    }

}
