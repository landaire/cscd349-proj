package com.cscd.game.model.characters.bad;

import com.cscd.game.model.classes.A_ClassMagicHealerPriest;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Cleric extends A_ClassMagicHealerPriest
{
 public Cleric()
 {
  super("Cleric",300,100,10,25,.6,100);
 }
 
 public Cleric(int heal)
 {
  super("Cleric",300,100,10,25,.6,heal);
 }
 
 public Cleric(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, healAmount);
 }
}
