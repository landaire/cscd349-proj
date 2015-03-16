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
  _HP = _maxHP = HP;
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
 
 public void takeDamage(int damage)
 {
  _HP -= damage;
  if (_HP <= 0)
   _isDead = true;
 }
 
 public boolean isDead()
 {
  return _isDead;
 }

 public int heal(int HP)
 {
  int healAmt = HP;

  if (HP + _HP > _maxHP)
   _HP = _maxHP;
  else
   _HP += HP;

  return healAmt;
 }
 
 public String usePotion()
 {
  return _name+" heals for "+heal(_inventory.consumePotion())+" health\n"+_name+" is now at "+ _HP+" health";
 }
 
 public int getMaxHP()
 {
  return _maxHP;
 }
 
 public String defend()
 {
  if (_HP < 0)
   return _name+" is dead";
  
  return _name+" has "+_HP+" health remaining";
 }

 public String attack(A_Class enemy)
 {
  if (enemy.isDead())
   return enemy.getName()+" has already been defeated";
  
  int attack = (int)(Math.random() * (this.getMaxDamage() - this.getMinDamage()) +1) + this.getMinDamage();
  enemy.takeDamage(attack);
  return this.getName()+" attacks "+enemy.getName()+" for "+attack+" damage "+ (isDead() ? enemy.getName()+" has been defeated" : "\n"+enemy.defend())+"\n";
 }
 
 public String toString()
 {
  return _name;
 }
 
}
