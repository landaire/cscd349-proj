package com.cscd.game.model.characters.good;

import com.cscd.game.model.classes.A_ClassMagicHealerPriest;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Hospital extends A_ClassMagicHealerPriest
{
    public static final String TYPE = "Hospital";
 public Hospital()
 {
  super(Hospital.TYPE,300,100,10,30,.6,100);
 }
 public Hospital(String name, int HP, int MP, int minDamage, int maxDamage, double chanceToHit, int healAmount)
 {
  super(name, HP, MP, minDamage, maxDamage, chanceToHit, healAmount);
 }
}
