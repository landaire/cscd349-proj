package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassMagicDamagePaladin;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Paladin extends A_ClassMagicDamagePaladin
{
    public static final String TYPE = "Paladin";
 public Paladin()
 {
  super(Paladin.TYPE,600,100,20,40,.7,0);
 }
 
 public Paladin(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int range)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, range);
 }
}
