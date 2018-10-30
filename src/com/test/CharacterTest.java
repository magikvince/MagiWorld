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
    public void Given_Attack_When_Choosing_Character_Mage_Then_DisplayText()
    {
      Mage mage = new Mage("Magikvince", 20, 0, 0, 20);
      assertTrue(mage.getBasicAttack().getName().equals("Boule de Feu"));
      assertTrue(mage.getSpecialAttack().getName().equals("Soin"));
    }

    @Test
    public void Given_Attack_When_Choosing_Character_Warrior_Then_DisplayText()
    {

        Warrior warrior = new Warrior("Tofy", 20, 20, 0, 0);
        assertTrue(warrior.getBasicAttack().getName().equals("Coup d'Épée"));
        assertTrue(warrior.getSpecialAttack().getName().equals("Coup de Rage"));
    }

    @Test
    public void Given_Attack_When_Choosing_Character_Rogue_Then_DisplayText()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
        assertTrue(rogue.getBasicAttack().getName().equals("Tir à l'Arc"));
        assertTrue(rogue.getSpecialAttack().getName().equals("Concentration"));
    }

    @Test
    public void Given_Level_When_Creating_Rogue_Then_Control_Life_Value()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
        assertEquals(100 , rogue.getLife() );
    }


    // testing fight abilities
    @Test
    public void Given_Mage_Basic_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Mage mage = new Mage("Magikvince", 20, 0, 0, 20);
        assertEquals(20, mage.calculateDamage(mage.getBasicAttack()) );
    }

    @Test
    public void Given_Warrior_Basic_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Warrior warrior = new Warrior("Tofy", 20, 20, 0, 0);
        assertEquals(20, warrior.calculateDamage(warrior.getBasicAttack()) );
    }

    @Test
    public void Given_Rogue_Basic_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
        assertEquals(20, rogue.calculateDamage(rogue.getBasicAttack()) );
    }

    @Test
    public void Given_Mage_Special_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Mage mage = new Mage("Magikvince", 20, 0, 0, 20);
     }

    @Test
    public void Given_Warrior_Special_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Warrior warrior = new Warrior("Tofy", 20, 20, 0, 0);

    }

    @Test
    public void Given_Rogue_Special_Attack_When_Calculating_Agility_Then_Display_New_Agility()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
    }

}
