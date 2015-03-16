package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassMagicHealerPriest;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Hospital extends A_ClassMagicHealerPriest
{
    public static final String TYPE = "Hospital";
 public Hospital()
 {
  super(new Inventory(),Hospital.TYPE,300,100,10,30,.6,100);
  for (int i = 0; i < 5; i++)
   getInventory().addItem(new ItemPotionHealth());
 }
 public Hospital(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, healAmount);
 }
}
