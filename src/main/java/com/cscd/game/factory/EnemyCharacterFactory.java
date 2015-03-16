package com.cscd.game.factory;


import com.cscd.game.model.characters.bad.*;
import com.cscd.game.model.classes.A_Class;

import java.util.ArrayList;
import java.util.Random;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class EnemyCharacterFactory
{
 private final static int BARD = 0;
 private final static int CLERIC = 1;
 private final static int DEATH_MASTER = 2;
 private final static int GREMLIN = 3;
 private final static int HOLY_LIBERATOR = 4;
 private final static int OGRE = 5;
 private final static int SKELETON = 6;

 public ArrayList<A_Class> getEnemies()
 {
  Random num = new Random(System.currentTimeMillis());
  int amount = (int)(Math.random()*3)+2;
  ArrayList<A_Class> enemies = new ArrayList<>();
  for (int i = 0; i < amount; i++)
  {
   switch (num.nextInt(7))
   {
    case BARD:
     enemies.add(new Bard());
     break;
    case CLERIC:
     enemies.add(new Cleric());
     break;
    case DEATH_MASTER:
     enemies.add(new Cleric());
     break;
    case GREMLIN:
     enemies.add(new Gremlin());
     break;
    case HOLY_LIBERATOR:
     enemies.add(new HolyLiberator());
     break;
    case OGRE:
     enemies.add(new Ogre());
     break;
    case SKELETON:
     enemies.add(new Skeleton());
     break;
   }
  }
  return enemies;
 }
}
