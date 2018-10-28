package com.magikvince;

/**
 *
 * Character is a mage.<BR>
 * Main skill is intelligence.
 */

public class Mage extends Character
{
    public Mage(String name)
    {
        super(name);
        this.basicAttack = new Attack("Boule de Feu", "basic", this.intelligence, 0);
        this.specialAttack = new Attack("Soin", "special", 0, this.intelligence * 2);
    }

    public Mage(String name, int level , int strength, int agility , int intelligence)
    {
        super(name, level, strength, agility, intelligence, null, null);
        this.basicAttack  = new Attack("Boule de Feu", "basic", this.intelligence, 0);
        this.specialAttack = new Attack("Soin", "special", 0, this.intelligence * 2);
    }

    public String toString()
    {
        return "Abracabra je suis le Mage " + super.toString();
    }
}
