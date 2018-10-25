package com.magikvince;

/**
 *
 * Définit une attaque d'un personnage
 * Elle peut être soit basique , soit spéciale
 *
 *
 */

public class Attaque
{

    private String nom;
    private String type;
    private int enemyDamage;
    private int autoDamage;

    public Attaque(String nom, String type, int enemy, int auto)
    {
        this.nom = nom;
        this.type = type;
        this.enemyDamage = enemy;
        this.autoDamage = auto;
    }

}
