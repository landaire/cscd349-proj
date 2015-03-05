package com.cscd.game.model.characters.bad;

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
  super("Bard",300,100,25,45,.7,25);
 }
 
 public Bard(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
