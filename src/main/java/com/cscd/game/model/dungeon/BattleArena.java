package com.cscd.game.model.dungeon;

import com.cscd.game.model.classes.A_Class;
import com.cscd.game.ui.character.Party;
import com.googlecode.blacken.examples.Dungeon;

import java.util.ArrayList;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class BattleArena
{
 private final static int ATTACK = 0;
 private final static int DEFEND = 1;
 private final static int POTION = 2;
 private final static int HEAL = 3;

 private Party _party;
 private ArrayList<A_Class> _encounter;
 private Dungeon _dungeon;
 private A_Class _currEnemy;
 private A_Class _currHero;
 private A_Class[] _theParty;

 public BattleArena(Party party, ArrayList<A_Class> encounter, boolean surpriseAttack, Dungeon dungeon)
 {
  _encounter = encounter;
  _party = party;
  _dungeon = dungeon;
  battle(surpriseAttack);
 }

 private void battle(boolean surpriseAttack)
 {
  boolean cont = true;
  _dungeon.combatMessage("Our heroes have encountered enemies!\n" +
      _encounter);
  _theParty = _party.getCharacters();

  _currEnemy = _encounter.get(0);
  if (surpriseAttack)
   enemyTurn();

  while (cont)
  {
   heroTurn();
   enemyTurn();
   cont = checkIfAlive();
  }
 }

 private void heroTurn()
 {
  // ask user if they want to attack, potion, or heal
  for (int i = 0; i < _theParty.length; i++)
  {
   _currHero = _theParty[i];
   A_Class enemyToAttack;
   if (!_currHero.isDead())
   {
    switch (_dungeon.getOption())
    {
     // if they want to attack give them a list of enemies to attack
     case ATTACK:
      enemyToAttack = _dungeon.enemyToAttack(_encounter);
      _dungeon.combatMessage(_currHero.attack(enemyToAttack));
      break;
     case POTION:
      _currHero.usePotion();
      break;
     // execute attack on the enemy and end turn
     case HEAL:
      break;
    }
   }
  }
 }

 private void enemyTurn()
 {
  // roll die to either attack or use potion (don't use potion at full health)
  for (int i = 0; i < _encounter.size(); i++)
  {
   _currEnemy = _encounter.get(i);
   if (!_currEnemy.isDead())
   {
    int num = 0;
    if (_currEnemy.getHP() < _currEnemy.getMaxHP())
    {
     if (((int) Math.random() * 101) > 75)
      num = 1;
    }

    if (num > 0)
     _currEnemy.usePotion();
    else
     _dungeon.combatMessage(_currEnemy.attack(_theParty[(int) Math.random() * _theParty.length + 1]));
    // if attack, choose a random hero to attack
    // attack hero and end turn
    if (!checkIfAlive())
     return;
   }
  }

 }

 private boolean checkIfAlive()
 {
  int i = 1;
  for (A_Class hero: _theParty)
  {
   if (hero.isDead())
    i++;
  }
  if (i == _theParty.length)
   _dungeon.gameOver("All heroes are dead");

  for (A_Class enemy: _encounter)
  {
   if (enemy.isDead())
    i++;
  }
  if (i == _encounter.size())
   return false;

  return true;
 }
}
