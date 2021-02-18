package PaooGame.States;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Enemy;
import PaooGame.Items.FactoryCars;
import PaooGame.Items.Player;
import PaooGame.RefLinks;
import PaooGame.Road.Road;
import PaooGame.UserInteface.UIImageButton;
import PaooGame.UserInteface.UIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.desktop.ScreenSleepEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Player player;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Road road;    /*!< Referinta catre harta curenta.*/
    private ArrayList<Enemy> enemies; // adversarii de joc
    private final FactoryCars factory=new FactoryCars();
    private final int []trafficLane={84,184,284,384,484};
    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
        // adauga butonul back
        uiManager=new UIManager(refLink);
        uiManager.addObject(new UIImageButton(Assets.buttonBack, 500, 704, 64, 64) {
            @Override
            public void onClick() {
                System.out.println("Click Back");
                State.SetState(refLink.GetGame().getMenuState());
            }
        });
        //creeaza joc nou
        NewState();
    }
    /**
     * fn controleaza coliziunile
     */
    public void Collision(){
        CollisionWithPlayer();
        CollisionWithOtherEnemies();
    }

    /**
     * fn controleaza coliziunea jucatorului cu celelate masini
     */
    public void CollisionWithPlayer(){
        for(Enemy enemy : enemies)
        {
            if(player.GetRectangle().intersects(enemy.GetRectangle())){
                System.out.println("Game finished");
                System.out.println("Score: "+player.GetScore());
                player.setMAX_SCORE(player.GetScore());
                State.SetState(refLink.GetGame().getMenuState());
            }
        }
    }

    /**
     * fn controleaza coliziunea intre masinile adversare
     */
    public void CollisionWithOtherEnemies(){
        for(int i=0;i<enemies.size();++i){
            for(int j=0;j<enemies.size();++j){
                if(i!=j){
                    Enemy e1=enemies.get(i);
                    Enemy e2=enemies.get(j);
                    if(e1.GetRectangle().intersects(e2.GetRectangle())){
                        Respawn(e2);
                    }
                }
            }
        }
    }

    /**
     * Respawn enemy
     *
     * @param      e     { enemy}
     */
    public void Respawn(Enemy e){
         e.SetX(trafficLane[(int)(Math.random()*5)]);
         e.SetY(-200-(float) Math.random() * 800);
         e.SetImage();
    }

    /**
     * Creeaza joc nou
     */
    public void newGame(){
        player= (Player) factory.Generate(refLink,"player",284,600);
        ///Construieste harta jocului
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        ///Construieste eroul
        road=new Road(refLink,0,0);
        enemies = new ArrayList<Enemy>(3 + player.GetLevel());
        for(int i=0;i<3+player.GetLevel();++i) {
            enemies.add((Enemy) factory.Generate(refLink,"enemy", trafficLane[(int)(Math.random()*5)], -200-(float) Math.random() * 800));
            CollisionWithOtherEnemies();
        }
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update() {
        road.Update((int)player.GetSpeed());
        player.Update();
        for(Enemy enemy : enemies) {
            enemy.SetY(enemy.GetY()+player.GetSpeed()-enemy.GetSpeed()-1);
            enemy.Update();
            if(enemy.GetY()>800 || enemy.GetY()<-2500){
                Respawn(enemy);
                player.SetScore(10);
            }
        }
        Collision();
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        road.Draw(g);
        player.Draw(g);
        for(Enemy enemy : enemies)
        {
            enemy.Draw(g);
        }
        player.DrawInfo(g);
        uiManager.Draw(g);
    }
    /**
     * se creeaza joc nou
     */
    public void NewState(){newGame();}
}
