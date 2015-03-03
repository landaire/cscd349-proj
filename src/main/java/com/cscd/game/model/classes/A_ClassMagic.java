package com.cscd.game.model.classes;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_ClassMagic extends A_Class
{
 public A_ClassMagic(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }

 @Override
 public void defend()
 {

 }
}
