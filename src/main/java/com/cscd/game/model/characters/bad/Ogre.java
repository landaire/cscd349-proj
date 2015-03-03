package com.cscd.game.model.characters.bad;

import com.cscd.game.model.classes.A_ClassPhysicalWarrior;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Ogre extends A_ClassPhysicalWarrior implements I_IsBad
{
    public static final String name = "Ogre";

 public Ogre()
 {
  super("Ogre",100,100,50,100,.75);
 }
 
 public Ogre(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
