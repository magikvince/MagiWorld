package com.magikvince;

/**
 *
 * Définit une attaque d'un personnage
 * Elle peut être soit basique , soit spéciale
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

}
