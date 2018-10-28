package com.magikvince;

/**
 * simule le déroulement d'une partie et les actions réalisées à chaque tour
 *
 */

public class Game
{
    private Character player1;
    private Character player2;

    public Character getplayer1() {
        return player1;
    }

    public void setplayer1(Character player1) {
        this.player1 = player1;
    }

    public Character getplayer2() {
        return player2;
    }

    public void setplayer2(Character player2) {
        this.player2 = player2;
    }

    public Partie (Character player1 , Character player2)
    {
        this.player1 = player1;
        this.player2 = player2;
    }

    /**4
     *
     * commence le tour par tour
     */

    public void start()
    {


    }
}
