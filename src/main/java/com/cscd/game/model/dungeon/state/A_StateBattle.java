package com.cscd.game.model.dungeon.state;

import com.cscd.game.model.characters.good.Journey;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_StateBattle extends A_State
{
 private Journey _journey;
 
 public A_StateBattle(Journey journey)
 {
  super(journey);
  _journey = journey;
 }
 
 @Override
 public StateBattleEnemyAttack doEnemyAttack()
 {
  return new StateBattleEnemyAttack(_journey);
 }

 @Override
 public StateBattleEnemyDefend doEnemyDefend()
 {
  return new StateBattleEnemyDefend(_journey);
 }

 @Override
 public StateBattleHeroAttack doHeroAttack()
 {
  return new StateBattleHeroAttack(_journey);
 }

 @Override
 public StateBattleHeroDefend doHeroDefend()
 {
  return new StateBattleHeroDefend(_journey);
 }

 @Override
 public StateBattleLose doStateBattleLose()
 {
  return new StateBattleLose(_journey);
 }

 @Override
 public StateBattleWin doStateBattleWin()
 {
  return new StateBattleWin(_journey);
 }
}
