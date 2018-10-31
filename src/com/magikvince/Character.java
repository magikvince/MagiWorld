package com.magikvince;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 *
 * Represents a Character of the Game.<BR>
 * It can be either a Warrior, a Mage or a Rogue.
 *
 */

public abstract class Character
{
    protected String name;

    protected int level;
    protected int life;
    protected int strength;
    protected int agility;
    protected int intelligence;

    protected int remaining_life;

    protected Attack basicAttack;
    protected Attack specialAttack;


    /***
     *
     * Constructor for tests with Junits without having to choose values with Scanner and System.in
     *
     */

    public Character(String name, int level , int strength, int agility, int intelligence, Attack basic, Attack special)
    {
        this.name = name;
        this.level = level;
        this.life = this.level * 5;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.basicAttack = basic;
        this.specialAttack = special;
        this.remaining_life = this.life;
    }

    public Character(String name)
    {
        do
        {
            this.level = 0;
            this.strength = this.agility = this.intelligence = -1;
            this.name = name;

            Scanner sc = new Scanner(System.in);

            while (this.level <= 0 || this.level > 100) {
                System.out.println("Niveau du personnage ? ");
                this.level = sc.nextInt();
            }

            this.life = this.level * 5;

            while (this.strength < 0 || this.strength > 100) {
                System.out.println("Force du personnage ? ");
                this.strength = sc.nextInt();
            }

            while (this.agility < 0 || this.agility > 100) {
                System.out.println("Agilité du personnage ? ");
                this.agility = sc.nextInt();
            }

            while (this.intelligence < 0 || this.intelligence > 100) {
                System.out.println("Intelligence du personnage ? ");
                this.intelligence = sc.nextInt();
            }

            if ( ! checkAttributes()) {
                System.out.println(this.toString());
                System.out.println("La somme des attributs du personnage ne peut pas être plus grande que son niveau!");
                System.out.println("Veuillez recommencer la saisie svp.");
            }
        }while ( ! checkAttributes());
    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getLife() {
        return life;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getRemaining_life() {
        return remaining_life;
    }

    public Attack getBasicAttack() {
        return basicAttack;
    }

    public Attack getSpecialAttack() {
        return specialAttack;
    }

     /**
     *
     * Create a specialized Character instance
     *
     * @param name name of character
     * @return instance of either Warrior, Mage or Rogue
     */

    public static Character chooseSpeciality(String name)
    {
        int class_choice = 0;
        Scanner sc = new Scanner(System.in);

        // class_choice must be between 1 to 3

        try
        {
            while ((class_choice < 1 || class_choice > 3)) {
                System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
                class_choice = sc.nextInt();
            }

            switch (class_choice) {
                case 1:
                    return new Warrior(name);
                case 2:
                    return new Rogue(name);
                case 3:
                    return new Mage(name);
                default:
                    return null;
            }
        }
        catch (InputMismatchException ime) {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix de votre personnage svp!");
            System.exit(1);
        }
        return null;
    }

    public Attack chooseAttack()
    {
        int attack_choice = 0;

        String texte = this.name + " (" + this.remaining_life + ") veuillez choisir votre action ";
        texte += "(1: Attaque basique, 2: Attaque speciale)";

        try {
            Scanner sc = new Scanner(System.in);
            while ( attack_choice != 1 && attack_choice != 2)
            {
                System.out.println(texte);
                attack_choice = sc.nextInt();
            }
        }
        catch ( InputMismatchException ime)
        {
            System.out.println("ERREUR de saisie : veuillez choisir entre 1 ou 2 !");
            this.chooseAttack();
        }

        switch(attack_choice)
        {
            case 1: return this.basicAttack;
            case 2: return this.specialAttack;
            default : return null;
        }
    }


    public void useAttack(Attack attack, Character enemy )
    {
       int amount = this.calculateDamage(attack);

       if (amount > 0)
           System.out.println(this.name + " utilise " + attack.getName() + " inflige " + amount + " dommages.");

       enemy.takeDamage(amount);
    }

    /**
     * Indicates the amount of damage dealt by chosen attack to enemy<BR>
     * this depends on basic or special attack and of Character speciality ( Mage , Warrior , Rogue)
     * @return amount of damage
     */

    public abstract int calculateDamage(Attack attack);

    /**
     *
     * Update of remaining life after receving enemy attack
     * @param damage amout of damage to take into account to calculate left life
     *
     */

    public void takeDamage ( int damage)
    {
        this.remaining_life = this.remaining_life - damage;
        System.out.println(this.name + " perd " + damage + " points de vie");
    }

    /**
     *
     * check if totalAttributes is equal to level of character
     * @return boolean value : true or false
     *
     */

    public String toString()
    {
        String texte = "Joueur " + this.name + " niveau " + this.level +  " je possède " + this.life + " de vitalité, " ;
        texte += this.strength + " de force, " + this.agility + " d'agilité et " + this.intelligence + " d'intelligence !";
        return texte;

    }

    protected boolean checkAttributes()
    {
        int totalAttributes = this.strength + this.intelligence + this.agility;
        return ( this.level == totalAttributes);
    }

    public boolean isDead()
    {
        return (this.remaining_life > 0);
    }
}
