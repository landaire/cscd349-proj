package com.cscd.game.factory;

import com.googlecode.blacken.examples.Dungeon;

/**
 * Created by Lander Brandt on 3/3/15.
 */
public class DungeonFactory {
    private static Dungeon dungeon;

    public static Dungeon get() {
        if (dungeon == null) {
            dungeon = new Dungeon();
        }

        return dungeon;
    }
}
