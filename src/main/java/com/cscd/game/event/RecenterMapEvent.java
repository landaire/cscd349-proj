package com.cscd.game.event;

import com.googlecode.blacken.grid.Positionable;

/**
 * Created by Lander Brandt on 2/17/15.
 */
public class RecenterMapEvent {
    private Positionable positionable;

    public RecenterMapEvent(Positionable around) {
        positionable = around;
    }

    public Positionable positionable() {
        return positionable;
    }
}
