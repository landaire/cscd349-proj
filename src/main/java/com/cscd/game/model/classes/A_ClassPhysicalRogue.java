package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassPhysicalRogue extends A_ClassPhysical
{
 public A_ClassPhysicalRogue(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
