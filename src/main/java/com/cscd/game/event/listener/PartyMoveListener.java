package com.cscd.game.event.listener;

import com.cscd.game.event.EventDispatcherFactory;
import com.cscd.game.event.RandomEncounterEvent;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

/**
 * Created by Lander Brandt on 3/12/15.
 */
public class PartyMoveListener implements Observer {
    private static int steps = 10;
    private static int encounters = 0;
    private static Random rand = new Random(System.currentTimeMillis());

    @Override
    public void update(Observable o, Object arg) {
        // TODO: logic for limiting encounters?

        if (steps == 0) {
            steps = 10;

            // 25% chance of firing this event
            if (rand.nextInt(101) > 75) {
                encounters++;
                EventDispatcherFactory.get().notify(new RandomEncounterEvent());
            }
        } else {
            steps--;
        }
    }
}
