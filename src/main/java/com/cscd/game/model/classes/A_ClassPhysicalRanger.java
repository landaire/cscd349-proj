package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassPhysicalRanger extends A_ClassPhysical
{
 private int _range;
 public A_ClassPhysicalRanger(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
  _range = range;
 }
}
