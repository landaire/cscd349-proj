package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassMagicDamageMage;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Mage extends A_ClassMagicDamageMage
{
 public Mage()
 {
  super("Mage",300,100,25,45,.7,20);
 }
 
 public Mage(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
