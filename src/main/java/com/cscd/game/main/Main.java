package com.cscd.game.main;

import com.cscd.game.factory.DungeonFactory;
import com.googlecode.blacken.examples.Dungeon;

/**
 * Sean Burright
 * Lander Brandt
 * Tony Moua
 */
public class Main
{
 public static void main(String[] args)
 {
     Dungeon that = DungeonFactory.get();
     that.init(null, null);
     that.splash();
     that.loop();
     that.quit();
 }
}
