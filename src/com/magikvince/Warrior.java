package com.magikvince;


/**
 *
 * Character is a Warrior.<BR>
 * Main skill is strength.
 *
 */
public class Warrior extends Character
{

    public Warrior(String name, int level , int strength, int intelligence, int agility )
    {
        super(name, level, strength, intelligence, agility, null, null);
        this.basicAttack = new Attack("Coup d'Épée", "basic", this.strength, 0);
        this.specialAttack = new Attack("Coup de Rage", "special", this.strength * 2, this.strength / 2);
        this.toString();
    }


    public String toString()
    {
        return "Woarg je suis le Guerrier " + super.toString();
    }

    @Override
    public int calculateDamage(Attack attack)
    {
        if (attack.getType().equals("basic"))
        {
            return this.getStrength();
        } else if (attack.getType().equals("special"))
        {
            this.self_damage = this.strength / 2;
            return this.strength * 2;
        }
        else {
            return 0;
        }
    }
}
