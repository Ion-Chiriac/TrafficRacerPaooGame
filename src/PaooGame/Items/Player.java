package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Settings.Level;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;


/**
 * This class describes a player.
 */
public class Player extends Car {
    private final float acceleration=0.05f;
    private int score;
    private Level level=Level.LEVEL1;
    private int MAX_SCORE;
    public Player(RefLinks refLinks, float x, float y){
        super(refLinks,x,y);
        this.score=0;
        level=refLinks.getLevel();
        image= Assets.Player;
        // citeste scorul maxim din fisier
        File file=new File("RecordScore.txt");
        try {
            BufferedReader r = new BufferedReader(new FileReader(file));
            MAX_SCORE = Integer.parseInt(r.readLine().replaceAll("\\D+", ""));
            r.close();
        }//daca nu exista nimic in fisier seteaza MAX_SCORE pe 0
        catch (Exception e){
            System.out.println("File not found!");
            System.out.println("Record Score is set to 0!");
            MAX_SCORE=0;
        }
    }
    /**
     * Verifica apasarea unei taste
     */
    public void GetInput(){
        xMove = 0;
        //yMove = DEFAULT_SPEED;
        ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            if(speed+acceleration>DEFAULT_MAX_SPEED)
                speed=DEFAULT_MAX_SPEED;
            speed+=acceleration;
            yMove = -speed;
        }else{
            speed-=acceleration;
            if(speed<DEFAULT_SPEED)
                speed=DEFAULT_SPEED;
        }
        if(refLink.GetKeyManager().left) {
            if(speed>DEFAULT_MAX_SPEED/2){
                xMove=-DEFAULT_MAX_SPEED/2;
            }
            else{
                xMove=-speed;
            }
        }
        if(refLink.GetKeyManager().right) {
            if(speed>DEFAULT_MAX_SPEED/2){
                xMove=DEFAULT_MAX_SPEED/2;
            }
            else {
                xMove=speed;
            }
        }
        if(refLink.GetKeyManager().down){
            if(speed-10*acceleration<DEFAULT_SPEED){
                speed=DEFAULT_SPEED;
            }
            speed-=10*acceleration;
            yMove = speed;
        }
    }
    /**
     * Actualizeaza pozitia jucatorului
     */
    public void MoveX(){
        x += xMove;
        if(x<68)
            x=68;
        if(x>632-68-64)
            x=632-68-64;
    }
    /**
     * Afiseaza informatiile cu referire la joc: nivel, scor
     *
     * @param      g     { parameter_description }
     */
    public void DrawInfo(Graphics g){
        g.setColor(Color.CYAN);
        Font font=new Font("Arial",Font.BOLD,20);
        g.setFont(font);
        g.drawString(level+"",68,718);
        g.drawString("Current  Score: "+score,68,738);
        g.drawString("Record   Score: "+MAX_SCORE,68,758);
    }

    /**
     * Gets the score.
     *
     * @return     The score.
     */
    public int GetScore(){return score;}

    /**
     * Gets the level.
     *
     * @return     The level.
     */
    public int GetLevel(){
        switch (level){
            case LEVEL1:
                return 1;
            case LEVEL2:
                return 2;
            case LEVEL3:
                return 3;
            default:
                return 0;
        }
    }
    /**
     * Sets the level.
     *
     * @param      level  The level
     */
    public void SetLevel(Level level){
        this.level=level;
    }
    /**
     * Sets the score.
     *
     * @param      s     Valoare ce va fi adunata ca scorul curent
     */
    public void SetScore(int s){
        s*=GetLevel();
        s/=2;
        if (this.speed>=DEFAULT_MAX_SPEED){
                this.score+=2*s;
        }else{
            this.score+=s;
        }
    }

    /**
     * Sets the max score and write in file RecordScore.txt
     *
     * @param      MAX_SCORE  The max score
     */
    public void setMAX_SCORE(int MAX_SCORE) {
        if(MAX_SCORE>this.MAX_SCORE) {
            this.MAX_SCORE = MAX_SCORE;
            File file=new File("RecordScore.txt");
            try {
                BufferedWriter writer=new BufferedWriter(new FileWriter(file));
                writer.write(String.valueOf(this.MAX_SCORE));
                writer.close();
            }
            catch (Exception e){
                System.out.println("Error: "+e.getMessage());
            }

        }
    }
    /**
     * Gets the max score.
     *
     * @return     The max score.
     */
    public int getMAX_SCORE(){
        return MAX_SCORE;
    }
}
