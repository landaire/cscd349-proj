package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicHealerPriest extends A_ClassMagicHealer
{
 private int _healAmount;
 public A_ClassMagicHealerPriest(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
  _healAmount = healAmount;
 }

 @Override
 public int heal(A_Class enemy)
 {
  return 0;
 }
}
