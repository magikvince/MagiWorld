package com.magikvince;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Character
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

    /**
     *
     * Create a specialized Character instance
     *
     * @param name non du personnage
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
                System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage");
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

    public void useAttack(Attack attack, Character player )
    {

    }


    /**
     *
     * Met à jour la vie_restante
     * @param damage amout of damage to take into account to calculate left life
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

    public String toString()
    {
        String texte = "Joueur " + this.name + " niveau " + this.level +  " je possède " + this.life + " de vitalité, " ;
        texte += this.strength + " de force, " + this.agility + " d'agilité et " + this.intelligence + " d'intelligence !";
        return texte;

    }

    private boolean checkAttributes()
    {
        int totalAttributes = this.strength + this.intelligence + this.agility;
        return ( this.level >= totalAttributes);
    }
}
