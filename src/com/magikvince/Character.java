package com.magikvince;

import java.util.Scanner;

public class Character
{
    protected String name;

    protected String speciality;

    protected int level;
    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;

    protected int staying_life;

    protected Attack basicAttack;
    protected Attack specialAttack;


    public Character(String name)
    {
        int class_choice = 0 ;
        this.strength = this.agility = this.intelligence = 0;

        this.name = name;

        System.out.println("Création du personnage du " + name );
        Scanner sc = new Scanner(System.in);

        // class_choice must be between 1 to 3
        while ( (class_choice < 1 || class_choice > 3)) {
            System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage");
            class_choice = sc.nextInt();
        }

        switch (class_choice)
        {
            case 1 : this.speciality = "Warrior"; break;
            case 2 : this.speciality = "Rogue"; break;
            case 3:  this.speciality = "Mage"; break;
        }

        while ( this.level <= 0 || this.level > 100 ) {
            System.out.println("Niveau du personnage ? ");
            this.level = sc.nextInt();
        }

        this.life = this.level * 5;

        while ( this.strength < 0 || this.strength > 100) {
            System.out.println("Force du personnage ? ");
            this.strength = sc.nextInt();
        }

        while ( this.agility < 0 || this.agility > 100 )
        {
            System.out.println("Agilité du personnage ? ");
            this.agility = sc.nextInt();
        }

        while ( this.intelligence < 0 || this.intelligence > 100)
        {
            System.out.println("Intelligence du personnage ? ");
            this.intelligence = sc.nextInt();
        }
    }

    public void useAttack(Attack attack, Character player )
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


    /**
     *
     * check if totalAttributes is equal to level of character
     * @return boolean value : true or false
     *
     */

    public boolean checkAttributes()
    {
        int totalAttributes = this.strength + this.intelligence + this.agility;
        return ( this.level == totalAttributes);
    }
}
