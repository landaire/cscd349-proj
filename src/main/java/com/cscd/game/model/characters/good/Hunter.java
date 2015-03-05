package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassPhysicalRanger;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Hunter extends A_ClassPhysicalRanger
{
 public Hunter()
 {
  super("Hunter",300,100,25,45,.6,20);
 }
 public Hunter(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
