package com.magikvince;

/**
 * simule le déroulement d'une partie et les actions réalisées à chaque tour
 *
 */

public class Partie
{
    private Personnage joueur1;
    private Personnage joueur2;

    public Personnage getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Personnage joueur1) {
        this.joueur1 = joueur1;
    }

    public Personnage getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Personnage joueur2) {
        this.joueur2 = joueur2;
    }

    public Partie (Personnage joueur1 , Personnage joueur2)
    {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
    }

    /**4
     *
     * commence le tour par tour
     */

    public void start()
    {


    }
}
