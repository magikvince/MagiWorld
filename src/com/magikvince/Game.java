package com.magikvince;

import java.util.ArrayList;
import java.util.List;

/**
 * Simulate a game and a fight between two characters<BR>
 * a new round is started until one of the character has no remaining life.
 *
 */

public class Game
{
    private Character player1;
    private Character player2;
    private Character loser;
    private Character enemy;

    private List<Round> rounds;

    private Character active_character;

    public Game (Character player1 , Character player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = new ArrayList<Round>();
        this.active_character = this.player1;
        this.enemy = this.player2;
        this.loser = null;
    }

    public Character getplayer1() {
        return player1;
    }
    public Character getplayer2() {
        return player2;
    }

    public Character getActive_character() {
        return active_character;
    }

    public void setActive_character(Character active_character) {
        this.active_character = active_character;
    }

    public List<Round> getRounds() {
        return rounds;
    }
    /**
     *
     *  Start the fight round by round
     */

    public void start()
    {
        //System.out.println("Début de la partie , bonne chance !");
        //System.out.println("vie du joueur " + this.player1.getName() + " : " + this.player1.getRemaining_life());
        //System.out.println("vie du joueur " + this.player2.getName() + " : " + this.player2.getRemaining_life());

        while ( this.player1.getRemaining_life() > 0 && this.player2.getRemaining_life() > 0 )
        {
            Round round = new Round(this, this.active_character, this.enemy );
            this.rounds.add(round);

            //System.out.println("Creation de la ronde : " + this.rounds.size() );

            round.start();
            round.stop();
            this.switchPlayers();
        }
    }

    /**
     * alternates the active player to deal or receive damage round by round
     */
    public void switchPlayers()
    {
        Character temp;
        temp = this.enemy;
        this.enemy = this.active_character;
        this.active_character = temp;
    }

    public void setLoser(Character loser)
    {
        this.loser = loser;
    }

    /**
     * stops the game and declares who the loser is.
     */
    public void stop()
    {
        System.out.println(this.loser.getName() + " a perdu !");
        System.exit(0);
    }
}
