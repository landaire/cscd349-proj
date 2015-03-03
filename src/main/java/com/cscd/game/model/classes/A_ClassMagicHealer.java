package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicHealer extends A_ClassMagic
{
 @Override
 public int attack()
 {
  return 0;
 }

 public A_ClassMagicHealer(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
 
 public abstract int heal();
}
