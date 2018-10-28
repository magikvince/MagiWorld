package com.magikvince;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println("Création du personnage du Joueur 1");
        Character player1 = new Character("Joueur 1");

        System.out.println("Création du personnage du Joueur 2");
        Character player2 = new Character("Joueur 2");

        Game game = new Game(player1 , player2);

    }
}
