package com.magikvince;


/**
 *
 * Round of a fight opposing 2 characters in a game<BR>
 *
 * First active Character chooses an attack<BR>
 * then we calculate damage given to each characters and we update remaining life for both characters<BR>
 * if nobody is dead we continue the fight to next round<BR>
 * we change the activeCharacter for next round.<BR>
 *
 */
public class Round {

    private Character active_character;
    private Character enemy;
    private Game game;

    public Round(Game game, Character active_character, Character enemy) {
        this.game = game;
        this.active_character = active_character;
        this.enemy = enemy;
    }

    public Character getActive_character() {
        return active_character;
    }

    public Character getEnemy() {
        return enemy;
    }

    public void start()
    {
        Attack attack = this.active_character.chooseAttack();
        this.active_character.useAttack(attack, this.enemy);
    }

    public void stop()
    {
        if ( this.enemy.isDead() ) {
            game.setLoser(this.enemy);
            game.stop();
        }

        if ( this.active_character.isDead() )
        {
            game.setLoser(this.active_character);
            game.stop();
        }
    }



}
