package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassPhysical extends A_Class
{
 public A_ClassPhysical(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }

 @Override
 public int attack()
 {
  return 0;
 }

 @Override
 public void defend()
 {

 }
}
