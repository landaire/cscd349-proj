package com.cscd.game.model.weapons.items;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class A_ItemPotion extends A_Item
{
 private int _value;
 
 public A_ItemPotion(String name, int value)
 {
  super(name);
  _value = value;
 }
 
 public int getValue()
 {
  return _value;
 }
}
