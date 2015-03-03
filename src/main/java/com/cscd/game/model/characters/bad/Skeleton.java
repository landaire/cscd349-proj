package com.cscd.game.model.characters.bad;

import com.cscd.game.model.classes.A_ClassPhysicalRanger;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Skeleton extends A_ClassPhysicalRanger implements I_IsBad
{
 public Skeleton()
 {
  super("Skeleton",220,100,30,50,.8);
 }
 
 public Skeleton(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
