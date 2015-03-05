package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagicHealerPriest extends A_ClassMagicHealer
{
 private int _healAmount;
 public A_ClassMagicHealerPriest(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
  _healAmount = healAmount;
 }

 @Override
 public int heal()
 {
  return 0;
 }
}
