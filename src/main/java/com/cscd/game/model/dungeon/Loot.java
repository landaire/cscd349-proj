package com.cscd.game.model.dungeon;

import com.cscd.game.model.classes.A_Class;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

import java.util.Random;

/**
 * Created by Sean Burright on 3/16/2015.
 */
public class Loot
{
 private A_Class[] _party;

 public Loot(A_Class[] party)
 {
  _party = party;
 }

 public String generateLoot()
 {

  // 1 - 3 items will drop
  int numDrop = (int)(Math.random()*2 + 1) + 1;
  int i = 0;

  shuffleArray(_party);

  for (A_Class hero: _party)
  {
   hero.getInventory().addItem(new ItemPotionHealth());
   i++;
   if (i == numDrop)
    break;
  }
  String returnItems = "";
   for (i = 0; i < numDrop; i++)
   {
    returnItems += "Looted a potion\n";
   }
  return returnItems;
 }

 private void shuffleArray(A_Class[] array)
 {
  int index;
  A_Class temp;
  Random random = new Random();
  for (int i = array.length - 1; i > 0; i--)
  {
   index = random.nextInt(i + 1);
   temp = array[index];
   array[index] = array[i];
   array[i] = temp;
  }
 }
}
