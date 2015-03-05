package com.cscd.game.model.characters.bad;

import com.cscd.game.model.classes.A_ClassPhysicalRogue;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Gremlin extends A_ClassPhysicalRogue implements I_IsBad
{
 public Gremlin()
 {
  super("Gremlin",250,100,15,30,.8);
 }
 
 public Gremlin(int minDamage, int maxDamage)
 {
  super("Gremlin",250,100,minDamage,maxDamage,.8);
 }

 public Gremlin(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
