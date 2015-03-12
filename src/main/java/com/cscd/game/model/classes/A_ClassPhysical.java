package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassPhysical extends A_Class
{
 public A_ClassPhysical(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }

 @Override
 public int attack(A_Class enemy)
 {
  return 0;
 }

 @Override
 public void defend(A_Class enemy)
 {

 }
}
