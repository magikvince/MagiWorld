package com.magikvince;


import java.util.InputMismatchException;
import java.util.Scanner;

public class CharacterFactory
{
    private Scanner sc;

    public CharacterFactory()
    {
        this.sc = new Scanner(System.in);
    }

    public int askForSpeciality()
    {
        int class_choice = 0;

        // class_choice must be between 1 to 3
        try
        {
            while ((class_choice < 1 || class_choice > 3)) {
                System.out.println("Veuillez choisir la classe de votre personnage ( 1 : Guerrier, 2 : Rôdeur, 3 : Mage)");
                class_choice = sc.nextInt();
            }

        }
        catch (InputMismatchException ime) {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix de votre personnage svp!");
            System.exit(1);
        }
        return class_choice;
    }

    public String askForName()
    {
        System.out.println("Nom du personnage ? ");
        String name = sc.next();
        return name;
    }

    public int askForLevel()
    {
        int level = -1;

        try
        {
            while (level <= 0 || level > 100)
            {
                System.out.println("Niveau du personnage ? ");
                level = sc.nextInt();
            }
        }
        catch (InputMismatchException ime) {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix du niveau de votre personnage svp!");
            System.exit(1);
        }
        return level;
    }

    public int askForStrength()
    {
        int strength = -1;

        try
        {
            while (strength < 0 || strength > 100)
            {
                System.out.println("Force du personnage ? ");
                strength = sc.nextInt();
            }
        }
        catch (InputMismatchException ime)
        {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix de la force de votre personnage svp!");
            System.exit(1);
        }
        return strength;
    }

    public int askForIntelligence()
    {
        int intelligence = -1;

        try
        {
            while (intelligence < 0 || intelligence > 100)
            {
                System.out.println("Intelligence du personnage ? ");
                intelligence = sc.nextInt();
            }
        }
        catch (InputMismatchException ime)
        {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix de l'intelligence de votre personnage svp!");
            System.exit(1);
        }
        return intelligence;
    }

    private int askForAgility()
    {
        int agility = -1;

        try
        {
            while (agility < 0 || agility > 100)
            {
                System.out.println("Agilité du personnage ? ");
                agility = sc.nextInt();
            }
        }
        catch (InputMismatchException ime)
        {
            System.out.println("ERREUR de saisie : veuillez saisir un nombre lors du choix de l'agilité de votre personnage svp!");
            System.exit(1);
        }
        return agility;

    }

    private boolean checkAttributes(int level, int strength, int intelligence, int agility)
    {
        int totalAttributes = strength + intelligence + agility;

        if  ( level == totalAttributes)
        {
            return true;
        }
        else
        {
            System.out.println("niveau = " + level + " est different de : " + strength + " + " + intelligence + " + " + agility + "!");
            System.out.println("La somme des attributs du personnage doit être égale à son niveau!");
            System.out.println("Veuillez recommencer la saisie svp.");
            return false;
        }
    }

    /**
     *
     * Create a specialized Character instance
     *
     * @param name name of character
     * @return instance of either Warrior, Mage or Rogue
     *
     */

    public Character CreateCharacter()
    {
        String name;
        int speciality, level, strength , intelligence, agility;

        do
        {
            speciality = this.askForSpeciality();
            name = this.askForName();
            level = this.askForLevel();
            strength = this.askForStrength();
            intelligence = this.askForIntelligence();
            agility = this.askForAgility();

        } while ( ! checkAttributes(level, strength, intelligence , agility));

        switch (speciality) {
            case 1: System.out.println("Création d'un Guerrier");
                    return new Warrior(name, level, strength, intelligence, agility);

            case 2: System.out.println("Création d'un Rôdeur");
                    return new Rogue(name, level, strength, intelligence, agility);

            case 3: System.out.println("Création d'un Mage");
                    return new Mage(name, level, strength, intelligence, agility);

            default:
                System.out.println("Choix de personnage non compris , on renvoie null !");
                return null;
        }
    }
}
