package com.cscd.game.model.dungeon;

import com.cscd.game.model.characters.good.Hospital;
import com.cscd.game.model.classes.A_Class;
import com.cscd.game.model.classes.A_ClassMagicHealerPriest;
import com.cscd.game.ui.character.Party;
import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.terminal.BlackenKeys;
import com.googlecode.blacken.terminal.CursesLikeAPI;
import sun.rmi.server.InactiveGroupException;

import java.util.ArrayList;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class BattleArena
{
 private final static int ATTACK = 1;
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
  _term.disableEventNotices();
  clearTerm();
  _theParty = _party.getCharacters();

  _currEnemy = _encounter.get(0);
  if (surpriseAttack)
   enemyTurn();

  while (cont)
  {
   //TODO fix the log disappearing after enemy turn
   heroTurn();
   enemyTurn();
   cont = checkIfAlive();
  }
  Loot loot = new Loot(_theParty);
  _log = loot.generateLoot();
  clearTerm();
 }

 private void heroTurn()
 {
  // ask user if they want to attack, potion, or heal
  for (int i = 0; i < _theParty.length && _encounter.size() > 0; i++)
  {
   _currHero = _theParty[i];
   A_Class enemyToAttack;
   if (!_currHero.isDead())
   {
    switch (getOption())
    {
     // if they want to attack give them a list of enemies to attack
     case ATTACK:
      enemyToAttack = enemyToAttack();
      _log += (_currHero.attack(enemyToAttack));
         if (enemyToAttack.isDead()) {
             _encounter.remove(enemyToAttack);
         }
      break;
     case POTION:
      _log += _currHero.usePotion();
      break;
     // execute attack on the enemy and end turn
     case HEAL:
      _log += ((A_ClassMagicHealerPriest)_currHero).heal(heroToHeal());
      break;
    }
   }
  }
 }

 private A_Class heroToHeal()
 {
  if (_log.length() > 300)
   _log = "";
  A_Class choice;
  while (true)
  {
   clearTerm();
   int line = 1;
   int i = 1;
   _term.mvputs(line,0,"Choose who to heal");
   for (A_Class hero: _theParty)
   {
    if (!hero.isDead())
     _term.mvputs(line+=2,0,i+++": "+hero.getName()+" "+hero.getHP()+" HP remaining");
   }

   int key = BlackenKeys.NO_KEY;
   while (key == BlackenKeys.NO_KEY)
    key = _term.getch(200);
   if (BlackenKeys.isModifier(key))
    key = _term.getch();


   if (key == BlackenKeys.NO_KEY || key == BlackenKeys.RESIZE_EVENT)
    continue;
   if (key >= '1' && key <= Integer.toString(_theParty.length).charAt(0))
   {
    choice = _theParty[(Integer.parseInt(Character.toString((char) key)) - 1)];
    if (choice.isDead()) {
     continue;
    }
    else
     break;
   }
  }
  return choice;
 }

 private A_Class enemyToAttack()
 {
  A_Class choice = null;
  int i;
  while (_encounter.size() > 0)
  {
   clearTerm();
   int line = 1;
   i = 1;
  _term.mvputs(line, 0, "Choose who to attack");
  for (A_Class enemy: _encounter)
  {
   if (!enemy.isDead())
    _term.mvputs(line+=2,0,i+++": "+enemy.getName()+" "+enemy.getHP()+" HP remaining");
  }

  int key = BlackenKeys.NO_KEY;
  while (key == BlackenKeys.NO_KEY)
   key = _term.getch(200);
  if (BlackenKeys.isModifier(key))
   key = _term.getch();


   if (key == BlackenKeys.NO_KEY || key == BlackenKeys.RESIZE_EVENT)
    continue;
   if (key >= '1' && key <= Integer.toString(_encounter.size()).charAt(0))
   {
    choice = _encounter.get(Integer.parseInt(Character.toString((char) key)) - 1);
    if (choice.isDead()) {
        continue;
    }
    else
     break;
   }
  }
  return choice;
 }


 private void enemyTurn()
 {
  if (_log.length() > 300)
   _log = "";
  A_Class hero;
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
    _log += _currEnemy.usePotion();
    else
    {
     while (true)
     {
     hero =_theParty[(int) (Math.random() * _theParty.length)];
      if (!hero.isDead())
       break;
     }
     _log += _currEnemy.attack(hero);
    }
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

  if (_encounter.size() == 0) {
      return false;
  }

  return true;
 }

 private void clearTerm()
 {
  _term.clear();
  _term.setCurBackground(0);
  _term.setCurForeground(7);
  String header = "Our heroes have encountered enemies!";
  _term.mvputs(0,_term.getWidth()/2-header.length()/2,header);
  _term.mvputs(_term.getWidth()/2,0,_log);
 }



 private int getOption()
 {
 int option;
  while (true)
  {
   clearTerm();
   int line = 1;
  _term.mvputs(line, 0, "Choose an option for "+_currHero+" "+_currHero.getHP()+" HP remaining");
  _term.mvputs(line+=2,0, "1. Attack");
  _term.mvputs(line+=2,0, "2. Potion");
   //code smell
   if (_currHero.getName().equals("Hospital"))
   _term.mvputs(line+=2,0, "3. Heal");

  int key = BlackenKeys.NO_KEY;
  while (key == BlackenKeys.NO_KEY)
  {
   key = _term.getch(200);
  }
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
