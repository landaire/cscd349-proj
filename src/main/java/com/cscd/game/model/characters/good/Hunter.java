package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassPhysicalRanger;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Hunter extends A_ClassPhysicalRanger
{
    public static final String TYPE = "Hunter";
 public Hunter()
 {
  super(new Inventory(), Hunter.TYPE,300,100,25,45,.6,20);
  for (int i = 0; i < 5; i++)
   getInventory().addItem(new ItemPotionHealth());
 }
 public Hunter(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory,name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
