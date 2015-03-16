package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
import com.cscd.game.model.classes.A_ClassPhysicalRanger;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Skeleton extends A_ClassPhysicalRanger
{
 public Skeleton()
 {
  super(new Inventory(),"Skeleton",100,100,10,20,.8,20);
 }
 
 public Skeleton(int minDamage, int maxDamage)
 {
  super(new Inventory(),"Skeleton",220,100,minDamage,maxDamage,.8,20);
 }
 
 public Skeleton(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
