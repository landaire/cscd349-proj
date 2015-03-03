package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicDamage extends A_ClassMagic
{
 public A_ClassMagicDamage(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }

 @Override
 public int attack()
 {
  return 0;
 }
}
