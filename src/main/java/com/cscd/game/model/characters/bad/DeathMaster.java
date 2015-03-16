package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
import com.cscd.game.model.classes.A_ClassMagicDamageWarlock;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class DeathMaster extends A_ClassMagicDamageWarlock
{
 public DeathMaster()
 {
  super(new Inventory(),"Death Master",400,100,15,30,.7,25);
 }
 
 public DeathMaster(int minDamage, int maxDamage)
 {
  super(new Inventory(),"Death Master",400,100,minDamage,maxDamage,.7,100);
 }
 public DeathMaster(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
