package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicDamageWarlock extends A_ClassMagicDamage
{
 public A_ClassMagicDamageWarlock(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
