package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
import com.cscd.game.model.classes.A_ClassMagicDamagePaladin;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class HolyLiberator extends A_ClassMagicDamagePaladin
{
 public HolyLiberator()
 {
  super(new Inventory(),"Holy Liberator",400,100,10,20,.7,0);
 }
 
 public HolyLiberator(int minDamage, int maxDamage)
 {
  super(new Inventory(),"Holy Liberator",400,100,minDamage,maxDamage,.7,0);
 }
 
 public HolyLiberator(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
