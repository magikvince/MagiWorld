package com.magikvince;

import java.util.Scanner;

public class Personnage
{
    protected String nom;
    protected int classe;
    protected int niveau;
    protected int vie;
    protected int force;
    protected int agilite;
    protected int intelligence;

    protected int vie_restante;


    public Personnage( String nom)
    {
        this.nom = nom;

        System.out.println("Création du personnage du " + nom );
        Scanner sc = new Scanner(System.in);

        System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage");
        this. = sc.nextInt();

        System.out.println("Niveau du personnage ? ");

        System.out.println("Force du personnage ? ");

        System.out.println("Agilité du personnage ? ");

        System.out.println("Intelligence du personnage ? ");
    }

    public void fight(Attaque attaque, Personnage perso)
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
