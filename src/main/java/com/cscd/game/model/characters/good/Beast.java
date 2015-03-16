package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassPhysicalWarrior;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Beast extends A_ClassPhysicalWarrior
{
    public static final String TYPE = "Beast";
 public Beast()
 {
  super(new Inventory(), Beast.TYPE,500,100,70,95,.8);
 }
 public Beast(Inventory inventory, String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(inventory, name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
