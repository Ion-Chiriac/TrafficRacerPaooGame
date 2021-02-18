package PaooGame.Graphics;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    public static BufferedImage []Enemy;
    public static BufferedImage Player;
    public static BufferedImage Route;
    public static  BufferedImage buttonNewGame;
    public static  BufferedImage buttonResumeGame;
    public static  BufferedImage buttonSettings;
    public static  BufferedImage buttonAbout;
    public static  BufferedImage buttonExit;
    public static  BufferedImage buttonSummerRoad;
    public static  BufferedImage buttonWinterRoad;
    public static  BufferedImage buttonBack;
    public static  BufferedImage backgroundMenu;
    public static  BufferedImage backgroundAbout;
    public static  BufferedImage WinterRoad;
    public static  BufferedImage SummerRoad;
    public static  BufferedImage buttonLevel1;
    public static  BufferedImage buttonLevel2;
    public static  BufferedImage buttonLevel3;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/Enemy.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.
        Enemy=new BufferedImage[9];
        for(int i=0;i<9;++i) {
            Enemy[i] = sheet.crop(i, 0);
        }
        //obtine imaginea drumului default
        Route=ImageLoader.LoadImage("/textures/WinterRoad.png");
        //obtine imaginea drumului de iarna si de vara
        SummerRoad=ImageLoader.LoadImage("/textures/SummerRoad.png");
        WinterRoad=ImageLoader.LoadImage("/textures/WinterRoad.png");
        //obtine imaginea jucatorului
        Player=ImageLoader.LoadImage("/textures/Player.png");
        //obtine imaginile butoanelor
        buttonAbout=ImageLoader.LoadImage("/textures/buttonAbout.png");
        buttonExit=ImageLoader.LoadImage("/textures/buttonExit.png");
        buttonResumeGame=ImageLoader.LoadImage("/textures/buttonResumeGame.png");
        buttonNewGame=ImageLoader.LoadImage("/textures/buttonNewGame.png");
        buttonSettings=ImageLoader.LoadImage("/textures/buttonSettings.png");
        buttonBack=ImageLoader.LoadImage("/textures/buttonBack.png");
        buttonSummerRoad=ImageLoader.LoadImage("/textures/buttonSummerRoad.png");
        buttonWinterRoad=ImageLoader.LoadImage("/textures/buttonWinterRoad.png");
        buttonLevel1=ImageLoader.LoadImage("/textures/buttonLevel1.png");
        buttonLevel2=ImageLoader.LoadImage("/textures/buttonLevel2.png");
        buttonLevel3=ImageLoader.LoadImage("/textures/buttonLevel3.png");
        
        backgroundMenu=ImageLoader.LoadImage("/textures/backgroundMenu.jpg");
        backgroundAbout=ImageLoader.LoadImage("/textures/backgroundAbout.png");
    }
}
