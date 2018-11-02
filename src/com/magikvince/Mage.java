package com.magikvince;

/**
 *
 * Character is a mage.<BR>
 * Main skill is intelligence.
 */

public class Mage extends Character
{

    public Mage(String name, int level , int strength, int intelligence, int agility)
    {
        super(name, level, strength, intelligence, agility, null, null);
        this.basicAttack  = new Attack("Boule de Feu", "basic", this.intelligence, 0);
        this.specialAttack = new Attack("Soin", "special", 0, this.intelligence * 2);
    }

    public String toString()
    {
        return "Abracabra je suis le Mage " + super.toString();
    }

    @Override
    public int calculateDamage(Attack attack)
    {
        if (attack.getType().equals("basic")) {
            return this.getIntelligence();
        } else if (attack.getType().equals("special")) {
            this.heal();
            return 0;
        }
        else {
            return 0;
        }
    }

    private void heal() {

        int theoric_healed = this.intelligence * 2;
        int real_healed = 0;

        if ( this.remaining_life + theoric_healed <= this.life ) {
            real_healed = theoric_healed;
            this.remaining_life += real_healed;
        }
        else{
            real_healed = this.life - this.remaining_life;
            this.remaining_life = this.life;
        }

        System.out.println(this.name + " utilise " + this.specialAttack.getName() + " et gagne " + real_healed + " en vitalité.");
    }
}
