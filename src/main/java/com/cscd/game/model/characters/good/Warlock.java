package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassMagicDamageWarlock;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Warlock extends A_ClassMagicDamageWarlock
{
    public static final String TYPE = "Warlock";
 public Warlock()
 {
  super(new Inventory(),Warlock.TYPE,400,100,20,40,.7,20);
  for (int i = 0; i < 5; i++)
   getInventory().addItem(new ItemPotionHealth());
 }
 public Warlock(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory,name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
