package com.cscd.game.model.dungeon;

import com.cscd.game.model.classes.A_Class;
import com.cscd.game.ui.character.Party;
import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.terminal.BlackenKeys;
import com.googlecode.blacken.terminal.CursesLikeAPI;

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
 private CursesLikeAPI _term;
 private String _log;

 public BattleArena(Party party, ArrayList<A_Class> encounter, boolean surpriseAttack, Dungeon dungeon)
 {
  _encounter = encounter;
  _party = party;
  _dungeon = dungeon;
  _term = _dungeon.getTerminal();
  _log = "";
  battle(surpriseAttack);
 }

 private void battle(boolean surpriseAttack)
 {
  boolean cont = true;

  clearTerm();
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
    switch (getOption())
    {
     // if they want to attack give them a list of enemies to attack
     case ATTACK:
      enemyToAttack = _dungeon.enemyToAttack(_encounter);
      clearTerm();
      combatMessage(_currHero.attack(enemyToAttack));
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

 private void combatMessage(String string)
 {
  int line = 3;
  _term.mvputs(0,line,string);
 }

 private void enemyTurn()
 {
  _log = "";
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
    _log +=_currEnemy.attack(_theParty[(int) (Math.random() * _theParty.length)]) + "\n";
    // if attack, choose a random hero to attack
    // attack hero and end turn
    checkIfAlive();
   }
  }

 }

 private boolean checkIfAlive()
 {
  int i = 0;
  for (A_Class hero: _theParty)
  {
   if (hero.isDead())
    i++;
  }
  if (i == _theParty.length)
   _dungeon.gameOver("All heroes are dead");

  i = 0;
  for (A_Class enemy: _encounter)
  {
   if (enemy.isDead())
    i++;
  }
  if (i == _encounter.size())
   return false;

  return true;
 }

 private void clearTerm()
 {
  _term.clear();
  _term.setCurBackground(0);
  _term.setCurForeground(7);
  String header = "Our heroes have encountered enemies!";
  _term.mvputs(0,_term.getWidth()/2-header.length()/2,header);
  _term.mvputs(1,_term.getWidth()/2,_log);
 }


 private int getOption()
 {
  clearTerm();
  int option = -1;
  int line = 3;
  _term.mvputs(line++, 0, "Choose an option");
  _term.mvputs(line++, 0, "1. Attack");
  _term.mvputs(line++, 0, "2. Potion");
  _term.mvputs(line++, 0, "3. Heal");

  int key = BlackenKeys.NO_KEY;
  while (key == BlackenKeys.NO_KEY)
  {
   key = _term.getch(200);
   if (key == BlackenKeys.NO_KEY || key == BlackenKeys.RESIZE_EVENT)
    continue;
   if (key >= '0' && key <= '3')
   {
    option = Integer.parseInt(Character.toString((char) key));
    break;
   }
  }
  return option;
 }
}
