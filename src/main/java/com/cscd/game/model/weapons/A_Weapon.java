package com.cscd.game.model.weapons;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_Weapon
{
 private int _minDamage;
 private int _maxDamage;
 private int _speed;
 private String _name;
 
 public A_Weapon(int minDamage, int maxDamage, int speed, String name)
 {
  _maxDamage = maxDamage;
  _minDamage = minDamage;
  _speed = speed;
  _name = name;
 }
 
 public int getMinDamage()
 {
  return _minDamage;
 }
 
 public int getMaxDamage()
 {
  return _maxDamage;
 }
 
 public int getSpeed()
 {
  return _speed;
 }
 
 public String getName()
 {
  return _name;
 }
}
