package com.cscd.game.model.dungeon.state;

import com.cscd.game.model.characters.good.Journey;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_State
{
 private Journey _journey;
 
 public A_State(Journey journey)
 {
  if (journey == null)
   throw new RuntimeException("null journey");
  _journey = journey;
 }
 
 public Journey getJourney()
 {
  if (_journey == null)
   throw new RuntimeException("null journey");
  return _journey;
 }
 
 public StateBattleEnemyAttack doEnemyAttack()
 {
  throw new RuntimeException("enemy cannot attack");
 }
 
 public StateBattleEnemyDefend doEnemyDefend()
 {
  throw new RuntimeException("enemy cannot defend");
 }
 
 public StateBattleHeroAttack doHeroAttack()
 {
  throw new RuntimeException("hero cannot attack");
 }
 
 public StateBattleHeroDefend doHeroDefend()
 {
  throw new RuntimeException("hero cannot defend");
 }
 
 public StateBattleLose doStateBattleLose()
 {
  throw new RuntimeException("cannot lose battle");
 }
 
 public StateBattleWin doStateBattleWin()
 {
  throw new RuntimeException("cannot win battle");
 }
 
 public StateWalkDoor doStateWalkDoor()
 {
  throw new RuntimeException("cannot walk through door");
 }
 
 public StateWalkHallway doStateWalkHallway()
 {
  throw new RuntimeException("cannot walk through hallway");
 }
 
 public StateStart doStateStart()
 {
  throw new RuntimeException("cannot start");  
 }
 
 public StateChooseHero doStateChooseHero()
 {
  throw new RuntimeException("cannot choose hero");
 }
 
 public StateBattleUsePotion doStateBattleUsePotion()
 {
  throw new RuntimeException("cannot use potion");
 }
 
 public StateGameOver doGameOver()
 {
  throw new RuntimeException("cannot end game");
 }
 
 public StateBattleStart doStateBattleStart()
 {
  throw new RuntimeException("cannot start battle");
 }
}
