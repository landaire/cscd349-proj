package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicDamage extends A_ClassMagic
{
 private int _range;
 public A_ClassMagicDamage(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
  _range = range;
 }

 @Override
 public int attack()
 {
  return 0;
 }
}
