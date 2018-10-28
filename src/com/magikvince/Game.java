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

    private List<Round> rounds;

    private Character active_character;

    public Game (Character player1 , Character player2)
    {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = new ArrayList<Round>();
        this.active_character = this.player1;

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

        while ( player1.getRemaining_life() > 0 && player2.getRemaining_life() > 0 )
        {
            Round round = new Round();
            this.rounds.add(round);
        }

    }
}
