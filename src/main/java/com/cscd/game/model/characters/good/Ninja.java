package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassPhysicalRogue;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Ninja extends A_ClassPhysicalRogue
{
    public static final String TYPE = "Ninja";
 public Ninja()
 {
  super(new Inventory(),Ninja.TYPE,400,100,25,45,.7);
 }
 
 public Ninja(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
