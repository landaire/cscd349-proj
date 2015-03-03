package com.cscd.game.model.dungeon.state;

import com.cscd.game.model.characters.good.Journey;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class StateStart extends A_State
{
 private Journey _journey;
 
 public StateStart(Journey journey)
 {
  super(journey);
  _journey = journey;
 }

 @Override
 public StateChooseHero doStateChooseHero()
 {
  return new StateChooseHero(_journey);
 }
}
