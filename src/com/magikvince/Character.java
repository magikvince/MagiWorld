package com.magikvince;

import java.lang.reflect.Field;
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

    public Character(String name, int level , int strength, int intelligence, int agility, Attack basic, Attack special)
    {
        this.name = name;
        this.level = level;
        this.life = this.level * 5;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.basicAttack = basic;
        this.specialAttack = special;
        this.remaining_life = this.life;
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


    public Attack chooseAttack()
    {
        int attack_choice = 0;

        String texte = this.name + " (" + this.remaining_life + " Vitalité) veuillez choisir votre action ";
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
           System.out.println(this.name + " utilise " + attack.getName() + " et inflige " + amount + " dommages.");

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

    public boolean isDead()
    {
        //System.out.println("Le joueur " + this.name + " a " + this.remaining_life + " point(s) de vie restant(s) sur " + this.life + " !");
        //System.out.println("isDead = " + (this.remaining_life <= 0));
        return this.remaining_life <= 0;
    }
}
