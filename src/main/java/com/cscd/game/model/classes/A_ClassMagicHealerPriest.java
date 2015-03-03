package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicHealerPriest extends A_ClassMagicHealer
{
 public A_ClassMagicHealerPriest(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }

 @Override
 public int heal()
 {
  return 0;
 }
}
