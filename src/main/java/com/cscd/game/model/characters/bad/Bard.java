package com.cscd.game.model.characters.bad;

import com.cscd.game.model.characters.good.Inventory;
import com.cscd.game.model.classes.A_ClassMagicDamageMage;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Bard extends A_ClassMagicDamageMage
{
 public Bard()
 {
  super(new Inventory(),"Bard",150,100,10,20,.7,25);
 }
 
 public Bard(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
