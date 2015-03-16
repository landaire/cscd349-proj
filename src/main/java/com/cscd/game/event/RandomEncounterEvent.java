package com.cscd.game.event;

import com.cscd.game.factory.EnemyCharacterFactory;
import com.cscd.game.model.classes.A_Class;
import com.cscd.game.model.dungeon.BattleArena;
import com.cscd.game.ui.character.Party;
import com.googlecode.blacken.examples.Dungeon;

import java.util.ArrayList;

/**
 * Created by Lander Brandt on 3/12/15.
 */
public class RandomEncounterEvent {
 
 private Dungeon _dungeon;
 private Party _party;
 private ArrayList<A_Class> _encounter;
 
 public RandomEncounterEvent(Party party)
 {
  _party = party;
  _dungeon = party.getDungeon();
  _encounter = new EnemyCharacterFactory().getEnemies();
  engageBattle();
 }
 
 public void engageBattle()
 {
  new BattleArena(_party,_encounter, surpriseAttack(),_dungeon);
 }
 
 public boolean surpriseAttack()
 {
  return true;
 }
}
