package com.test;

import com.magikvince.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * test class for Character.java
 *
 */
public class CharacterTest
{

    @Test
    public void Given_Attack_When_Choosing_Character_Mage_Then_ShouldDisplayText()
    {
      Mage mage = new Mage("magikvince", 20, 0, 0, 20);

      assertTrue(mage.getBasicAttack().getName().equals("Boule de Feu"));
      assertTrue(mage.getSpecialAttack().getName().equals("Soin"));
    }

    @Test
    public void Given_Attack_When_Choosing_Character_Warrior_Then_ShouldDisplayText()
    {
        Warrior warrior = new Warrior("magikvince", 20, 20, 0, 0);

        assertTrue(warrior.getBasicAttack().getName().equals("Coup d'Épée"));
        assertTrue(warrior.getSpecialAttack().getName().equals("Coup de Rage"));
    }

    @Test
    public void Given_Attack_When_Choosing_Character_Rogue_Then_ShouldDisplayText()
    {
        Rogue rogue = new Rogue("magikvince", 20, 0, 20, 0);

        assertTrue(rogue.getBasicAttack().getName().equals("Tir à l'Arc"));
        assertTrue(rogue.getSpecialAttack().getName().equals("Concentration"));
    }

}
