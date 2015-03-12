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
  super("Ogre",400,100,30,60,.6);
 }
 
 public Ogre(int minDamage, int maxDamage)
 {
  super("Ogre",400,100,minDamage,maxDamage,.6);
 }
 
 public Ogre(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit);
 }
}
