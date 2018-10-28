package com.magikvince;

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Création du personnage du Joueur 1");
        Character player1 = Character.chooseSpeciality("Joueur 1");

        System.out.println("Création du personnage du Joueur 2");
        Character player2 = Character.chooseSpeciality("Joueur 2");

        Game game = new Game(player1 , player2);
    }
}
