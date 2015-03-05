package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassPhysicalWarrior;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Beast extends A_ClassPhysicalWarrior
{
 public Beast()
 {
  super("Beast",500,100,70,95,.8);
 }
 public Beast(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
