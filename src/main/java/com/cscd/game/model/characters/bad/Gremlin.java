package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
import com.cscd.game.model.classes.A_ClassPhysicalRogue;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Gremlin extends A_ClassPhysicalRogue
{
 public Gremlin()
 {
  super(new Inventory(),"Gremlin",250,100,15,30,.8);
 }
 
 public Gremlin(int minDamage, int maxDamage)
 {
  super(new Inventory(),"Gremlin",250,100,minDamage,maxDamage,.8);
 }

 public Gremlin(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
