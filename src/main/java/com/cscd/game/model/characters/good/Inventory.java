package com.cscd.game.model.characters.good;

import com.cscd.game.model.weapons.A_Weapon;
import com.cscd.game.model.weapons.ammunition.A_Ammunition;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

import java.util.ArrayList;
import java.util.List;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Inventory
{
 private ArrayList<ItemPotionHealth> _items;
 private ArrayList<A_Weapon> _weapons;
 private ArrayList<A_Ammunition> _ammunition;
 
 public Inventory()
 {
  _items = new ArrayList<>();
  _weapons = new ArrayList<>();
  _ammunition = new ArrayList<>();
 }
 
 public void addItem(ItemPotionHealth item)
 {
  _items.add(item);
 }
 
 public void addArrow(A_Ammunition arrow)
 {
  _ammunition.add(arrow);
 }
 
 public void addWeapon(A_Weapon weapon)
 {
  _weapons.add(weapon);
 }
 
 public void useArrow()
 {
  
 }
 
 public void useBolt()
 {
  
 }
 
 // returns heal value
 public int usePotion()
 {
  int value = 0;
  if (_items.size() == 0)
  {
   //give error: no potions
   return value;
  }
  for (ItemPotionHealth potion : _items)
  {
   value = potion.getValue();
   _items.remove(potion);
   return value;
  }
  System.err.println("Error occurred in usePotion");
  return 0;
 }
 
 public A_Weapon getWeapon()
 {
   return _weapons.get(0);
 }
 
 public int consumePotion()
 {
  int value = 0;
  if (_items.size() > 0)
  {
   value = _items.get(0).getValue();
   _items.remove(0);
  }
  
  return value;
 }
}
