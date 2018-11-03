package com.magikvince;

/***
 * starts the game MagiWorld
 */
public class MagiWorld
{

    public static void main(String[] args)
    {
        CharacterFactory cf = new CharacterFactory();

        System.out.println("Création du personnage du Joueur 1");
        Character player1 = cf.CreateCharacter();

        System.out.println("Création du personnage du Joueur 2");
        Character player2 = cf.CreateCharacter();

        Game game = new Game(player1 , player2);
        game.start();
    }
}
