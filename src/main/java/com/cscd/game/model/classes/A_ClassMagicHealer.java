package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicHealer extends A_ClassMagic
{
 @Override
 public int attack(A_Class enemy)
 {
  return 0;
 }

 public A_ClassMagicHealer(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
 
 public abstract int heal(A_Class hero);
}
