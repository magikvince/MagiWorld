package com.magikvince;

import java.util.Scanner;

public class Character
{
    protected String name;
    protected int level;
    protected int life;
    protected int strenght;
    protected int agility;
    protected int intelligence;

    protected int ;


    public Character( String name)
    {
        this.name = name;

        System.out.println("Création du personnage du " + name );
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage");
        this. = sc.nextInt();

        System.out.println("Niveau du personnage ? ");

        System.out.println("Force du personnage ? ");

        System.out.println("Agilité du personnage ? ");

        System.out.println("Intelligence du personnage ? ");
    }

    public void fight(Attaque attaque, Character perso)
    {

    }


    /**
     *
     * Met à jour la vie_restante
     * @param damage
     *
     */

    public void takeDamage ( int damage)
    {


    }

}
