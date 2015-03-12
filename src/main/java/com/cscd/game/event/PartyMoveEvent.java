package com.cscd.game.event;

import com.cscd.game.ui.character.Party;
import com.googlecode.blacken.grid.Positionable;

/**
 * Created by Lander Brandt on 3/12/15.
 */
public class PartyMoveEvent {
    private Party positionable;

    public PartyMoveEvent(Party party) {
        positionable = party;
    }

    public Party party() {
        return positionable;
    }
}
