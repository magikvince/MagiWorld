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
    public void Given_Mage_Special_Attack_When_Calculating_Damage_and_remaining_life_Then_Display_Damage()
    {
        Mage mage = new Mage("Magikvince", 30, 0, 0, 30);

        mage.takeDamage(100);
        assertEquals( 50, mage.getRemaining_life());
        assertEquals(0, mage.calculateDamage(mage.getSpecialAttack()) );

        assertEquals( 110, mage.getRemaining_life());
     }

    @Test
    public void Given_Warrior_Special_Attack_When_Calculating_Damage_Then_Display_Damage()
    {
        Warrior warrior = new Warrior("Tofy", 15, 10, 5, 0);
        assertEquals(20, warrior.calculateDamage(warrior.getSpecialAttack()) );
        assertEquals(70 , warrior.getRemaining_life());
        assertEquals(20, warrior.calculateDamage(warrior.getSpecialAttack()) );
        assertEquals(65 , warrior.getRemaining_life());
    }

    @Test
    public void Given_Rogue_Special_Attack_When_Calculating_Agility_Then_Display_New_Agility()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
        rogue.Concentrate();
        assertEquals(30, rogue.getAgility());
    }

    @Test
    public void Given_Mage_When_Taking_Damage_Then_Update_Remaining_Life()
    {
        Mage mage = new Mage("Magikvince", 30, 0, 0, 30);
        assertEquals(150, mage.getLife());
        mage.takeDamage(100);
        assertEquals(50, mage.getRemaining_life());
    }

    @Test
    public void Given_Warrior_When_Taking_Damage_Then_Update_Remaining_Life()
    {
        Warrior warrior = new Warrior("Tofy", 15, 10, 5, 0);
        assertEquals(75, warrior.getLife());
        warrior.takeDamage(10);
        warrior.takeDamage(10);
        warrior.takeDamage(20);
        assertEquals(35, warrior.getRemaining_life());
    }

    @Test
    public void Given_Rogue_When_Taking_Damage_Then_Update_Remaining_Life()
    {
        Rogue rogue = new Rogue("Cenvin", 20, 0, 20, 0);
        assertEquals(100, rogue.getLife());
        rogue.takeDamage(10);
        assertEquals(90, rogue.getRemaining_life());
        rogue.takeDamage(10);
        rogue.takeDamage(20);
        assertEquals(60, rogue.getRemaining_life());
    }
}
