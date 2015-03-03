package com.cscd.game.model.weapons.ammunition;

/**
 * Created by Sean Burright on 2/17/15.
 */
public abstract class A_Ammunition
{
 private String _name;
 
 public A_Ammunition(String name)
 {
  _name = name;
 }
 
 public String getName()
 {
  return _name;
 }
}
