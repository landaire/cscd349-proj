package com.cscd.game.model.classes;

import com.cscd.game.model.characters.good.Inventory;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_Class
{
 private String _name;
 private int _HP;
 private int _maxHP;
 private int _MP;
 private int _minDamage;
 private int _maxDamage;
 private double _chanceToHit;
 private boolean _isDead;
 private Inventory _inventory;

 public A_Class(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  if (name == "")
   throw new RuntimeException("no name");
  _inventory = inventory;
  _name = name;
  _HP = HP;
  _maxDamage = HP;
  _MP = MP;
  _minDamage = minDamage;
  _maxDamage = maxDamage;
  _chanceToHit = chanceToHit;
  _isDead = false;
 }
 
 public Inventory getInventory()
 {
  return _inventory;
 }
 
 public String getName()
 {
  return _name;
 }
 
 public int getHP()
 {
  return _HP;
 }
 
 public int getMP()
 {
  return _MP;
 }
 
 public int getMinDamage()
 {
  return _minDamage;
 }
 
 public int getMaxDamage()
 {
  return _maxDamage;
 }
 
 public double getChanceToHit()
 {
  return _chanceToHit;
 }
 
 public boolean isDead()
 {
  return _isDead;
 }

 public void heal(int HP)
 {
  if (HP + _HP > _maxHP)
   _HP = _maxHP;
  else
   _HP += HP;
 }
 
 public abstract void defend(A_Class enemy);
 
 public abstract int attack(A_Class enemy);
 
}
