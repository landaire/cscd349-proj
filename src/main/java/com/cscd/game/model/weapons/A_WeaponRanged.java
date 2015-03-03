package com.cscd.game.model.weapons;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_WeaponRanged extends A_Weapon
{
 private int _range;
 
 public A_WeaponRanged(int minDamage, int maxDamage, int speed, int range, String name)
 {
  super(minDamage, maxDamage, speed, name);
  _range = range;
 }
 
 public int getRange()
 {
  return _range;
 }
}
