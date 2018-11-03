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

    protected int self_damage;
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
        this.self_damage = 0;

        System.out.println(this.toString());
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

    public int getSelf_damage() { return self_damage; }

    public void setSelf_damage(int self_damage) { this.self_damage = self_damage;  }

    /**
     * Makes the character choose between basic or special attack
     * @return
     */
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

                if ( attack_choice != 1 && attack_choice != 2)
                    System.out.println("ERREUR de saisie : veuillez choisir entre 1 ou 2 !");
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


    /**
     * use the attack and deal damage to the enemy
     * @param attack
     * @param enemy
     */
    public void useAttack(Attack attack, Character enemy )
    {

       if ( attack == null)
           attack = this.chooseAttack();

       int amount = this.calculateDamage(attack);

       if (amount > 0)
           System.out.println(this.name + " utilise " + attack.getName() + " et inflige " + amount + " dommages.");

       enemy.takeDamage(amount);

       if (this.self_damage > 0) {
           this.takeDamage(self_damage);
           this.self_damage = 0;
       }

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
        if ( damage > 0) {
            this.remaining_life = this.remaining_life - damage;
            System.out.println(this.name + " perd " + damage + " points de vie");
        }
    }

    /**
     *
     * check if totalAttributes is equal to level of character
     * @return boolean value : true or false
     *
     */

    public String toString()
    {
        String texte = this.name + " niveau " + this.level +  " je possède " + this.life + " de vitalité, " ;
        texte += this.strength + " de force, " + this.agility + " d'agilité et " + this.intelligence + " d'intelligence !";
        return texte;

    }

    /**
     * Determines if a player is dead or not by checking the remaining life.<BR>
     * if life is 0 or inferior , they character is dead.
     * @return true or false is remaining life  superior 0
     */
    public boolean isDead()
    {
        //System.out.println("Le joueur " + this.name + " a " + this.remaining_life + " point(s) de vie restant(s) sur " + this.life + " !");
        //System.out.println("isDead = " + (this.remaining_life <= 0));

        if ( this.remaining_life <= 0) {
            System.out.println(this.getName() + " est mort");
            return true;
        }
        else
            return false;
    }
}
