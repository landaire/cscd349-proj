package com.cscd.game.main;

import com.cscd.game.event.EventDispatcherFactory;
import com.cscd.game.event.listener.PartyMoveListener;
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
        registerEventListeners();

        Dungeon that = DungeonFactory.get();
        that.init(null, null);
        that.splash();
        that.chooseCharacter();
        that.loop();
        that.quit();
    }

    private static void registerEventListeners()  {
        EventDispatcherFactory.get().addObserver(new PartyMoveListener());
    }
}
