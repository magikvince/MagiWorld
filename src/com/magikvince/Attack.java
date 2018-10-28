package com.magikvince;

/**
 *
 * represents an attack of a Character<BR>
 * It can be either a basic or special attack.
 *
 *
 */

public class Attack
{
    private String name;
    private String type;
    private int enemyDamage;
    private int selfDamage;

    public Attack(String nom, String type, int enemy, int auto)
    {
        this.name = nom;
        this.type = type;
        this.enemyDamage = enemy;
        this.selfDamage = auto;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getEnemyDamage() {
        return enemyDamage;
    }

    public int getSelfDamage() {
        return selfDamage;
    }
}
