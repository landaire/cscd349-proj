package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
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
  super(new Inventory(),"Cleric",150,100,2,10,.6,100);
 }
 
 public Cleric(int heal)
 {
  super(new Inventory(),"Cleric",300,100,10,25,.6,heal);
 }
 
 public Cleric(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, healAmount);
 }
}
