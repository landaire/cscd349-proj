package com.cscd.game.model.weapons.items;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_Item
{
 private String _name;
 
 public A_Item(String name)
 {
  _name = name;
 }
 
 public String getName()
 {
  return _name;
 }
}
