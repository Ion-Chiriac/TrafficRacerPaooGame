package PaooGame.States;

import java.awt.*;
import PaooGame.RefLinks;
import PaooGame.UserInteface.UIManager;

/*! \class State
    \brief Implementeaza notiunea abstracta de stare a jocului/programului.

    Un joc odata ce este lansat in executie nu trebuie "sa arunce jucatorul direct in lupta", este nevoie de
    un meniu care sa contine optiuni: New Game, Load Game, Settings, About etc. Toate aceste optiuni nu sunt altceva
    decat stari ale programului (jocului) ce trebuiesc incarcate si afisate functie de starea curenta.
 */
public abstract class State
{
        ///Urmatoarele atribute sunt statice pentru a evita dealocarea spatiului de memorie la trecerea dintr-o stare in alta.
    private static State previousState  = null; /*!< Referinta catre starea anterioara a jocului.*/
    private static State currentState   = null; /*!< Referinta catre starea curenta a jocului: game, meniu, settings, about etc.*/
    protected UIManager uiManager;
    protected static RefLinks refLink;
    public State(RefLinks refLink)
    {
        this.refLink = refLink;
    }

    /*! \fn public static void SetState(State state)
        \brief Seteaza starea curenta a jocului.

        \param state Noua stare a programului (jocului).
     */
    public static void SetState(State state)
    {
        previousState = currentState;
        currentState = state;
        refLink.GetMouseManager().setUiManager(currentState.getUiManager());
    }

    /**
     * Gets the state.
     *
     * @return     The state.
     */
    public static State GetState()
    {
        return currentState;
    }
    /**
     * Gets the previous state.
     *
     * @return     The previous state.
     */
    public static State GetPreviousState(){ return previousState; }

        ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
        ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);
    /**
     * Gets the user interface manager.
     *
     * @return     The user interface manager.
     */
    public UIManager getUiManager() {
        return uiManager;
    }

    public abstract void NewState();
}
