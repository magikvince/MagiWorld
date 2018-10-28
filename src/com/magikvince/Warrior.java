package com.magikvince;


/**
 *
 * Character is a Warrior.<BR>
 * Main skill is strength.
 *
 */
public class Warrior extends Character
{
    public Warrior( String name)
    {
        super(name);

        this.basicAttack = new Attack("Coup d'Épée", "basic", this.strength, 0);
        this.specialAttack = new Attack("Coup de Rage", "special", this.strength * 2, this.strength / 2);
    }

    public Warrior(String name, int level , int strength, int agility , int intelligence)
    {
        super(name, level, strength, agility, intelligence, null, null);
        this.basicAttack = new Attack("Coup d'Épée", "basic", this.strength, 0);
        this.specialAttack = new Attack("Coup de Rage", "special", this.strength * 2, this.strength / 2);
    }


    public String toString()
    {
        return "Woarg je suis le Guerrier " + super.toString();
    }
}
