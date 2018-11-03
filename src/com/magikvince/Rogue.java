package com.magikvince;


/**
 *
 * Character is a Rogue.<BR>
 * Main skill is agiliy.
 *
 */
public class Rogue extends Character
{

    public Rogue(String name, int level , int strength, int intelligence, int agility )
    {
        super(name, level, strength, intelligence, agility, null, null);
        this.basicAttack = new Attack("Tir à l'Arc", "basic", this.agility, 0);
        this.specialAttack = new Attack("Concentration", "special", 0 , 0);
        this.toString();
    }

    /**
     * updating agility after using special attack
     *
     */
    public void Concentrate()
    {
        int concentrated = this.level / 2;
        this.agility += concentrated;

        System.out.println(this.name + " utilise " + this.getSpecialAttack().getName() + " et gagne " + concentrated + " en agilité.");
    }

    public String toString()
    {
        return "Groak je suis le Rôdeur " + super.toString();
    }

    @Override
    public int calculateDamage(Attack attack)
    {
        if (attack.getType().equals("basic")) {
            return this.getAgility();
        } else if (attack.getType().equals("special")) {
            this.Concentrate();
            return 0;
        }
        else {
            return 0;
        }
    }
}
