package com.cscd.game.main;

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
     Dungeon that = new Dungeon();
     that.init(null, null);
     that.splash();
     that.loop();
     that.quit();
 }
}
