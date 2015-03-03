package com.cscd.game.model.dungeon.state;

import com.cscd.game.model.characters.good.Journey;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public abstract class A_StateWalk extends A_State
{
 private Journey _journey;
 
 public A_StateWalk(Journey journey)
 {
  super(journey);
  _journey = journey;
 }

 @Override
 public StateWalkHallway doStateWalkHallway()
 {
  return new StateWalkHallway(_journey);
 }

 @Override
 public StateWalkDoor doStateWalkDoor()
 {
  return new StateWalkDoor(_journey);
 }
}
