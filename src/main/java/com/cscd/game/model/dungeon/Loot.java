package com.cscd.game.model.dungeon;

import com.cscd.game.model.classes.A_Class;
import com.cscd.game.model.weapons.items.ItemPotionHealth;

import java.util.Random;

/**
 * Created by Sean Burright on 3/16/2015.
 */
public class Loot
{
 public Loot(A_Class[] party)
 {
  generateLoot(party);
 }

 public void generateLoot(A_Class[] party)
 {

  // 1 - 3 items will drop
  int numDrop = (int)(Math.random()*2 + 1) + 1;
  int i = 0;

  shuffleArray(party);

  for (A_Class hero: party)
  {
   hero.getInventory().addItem(new ItemPotionHealth());
   i++;
   if (i == numDrop)
    return;
  }
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
