package com.magikvince;


/**
 *
 * Character is a Rogue.<BR>
 * Main skill is agiliy.
 *
 */
public class Rogue extends Character
{
    public Rogue(String name)
    {
        super(name);

        this.basicAttack = new Attack("Tir à l'Arc", "basic", this.agility, 0);
        this.specialAttack = new Attack("Concentration", "special", 0 , 0);
    }

    public Rogue(String name, int level , int strength, int agility , int intelligence)
    {
        super(name, level, strength, agility, intelligence, null, null);
        this.basicAttack = new Attack("Tir à l'Arc", "basic", this.agility, 0);
        this.specialAttack = new Attack("Concentration", "special", 0 , 0);
    }

    /**
     * updating agility after using special attack
     *
     */
    public void Concentrate()
    {
        this.agility += this.level / 2;
    }

    public String toString()
    {
        return "Groak je suis le Rôdeur " + super.toString();
    }

    @Override
    public int calculateDamage(Attack attack) {
        return 0;
    }
}
