package com.cscd.game.ui.character;

import com.cscd.game.event.EventDispatcher;
import com.cscd.game.event.EventDispatcherFactory;
import com.cscd.game.event.RecenterMapEvent;
import com.cscd.game.event.UpdateMessageEvent;
import com.cscd.game.goals.DungeonGoals;
import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.grid.Grid;
import com.googlecode.blacken.grid.Positionable;

/**
 * Created by Lander Brandt on 2/13/15.
 */
public class Party implements Moveable, Positionable {
    private PositionableObject[] party;
    private Dungeon dungeon;

    public Party(PositionableObject[] party, Dungeon dungeon) {
        this.party = party;
        this.dungeon = dungeon;
    }

    @Override
    public void moveBy(int y, int x) {
        Integer there;
        Grid<Integer> grid = this.dungeon.getGrid();
        Integer underPlayer = dungeon.getConfigOption("room:floor");
        Positionable player = party[0];

        try {
            there = grid.get(player.getY() + y, player.getX() + x);
        } catch(IndexOutOfBoundsException e) {
            return;
        }

        EventDispatcher dispatcher = EventDispatcherFactory.get();

        if (dungeon.playerCanAccessPosition(there)) {
            // Set each position in the party to the last positionable's position
            // so we start at the head, it moves to the desired location. The next char in the party
            // moves to the head's last position, and so on

            /**
             * newPosition represents what the positionable in the for loop will be going to. We set it by default
             * to the head party member's position + (x, y) so that the head will move there.
             *
             * At the end of the loop, newPosition is set to the current positionable's previous location so that the
             * next positionable will then move there
             */
            Positionable newPosition = party[0].getPosition();
            newPosition.setPosition(newPosition.getY() + y, newPosition.getX() + x);

            for (PositionableObject positionable : party) {
                Positionable oldPos = positionable.getPosition();
                grid.set(oldPos.getY(), oldPos.getX(), underPlayer);

                positionable.setPosition(newPosition);

                grid.set(newPosition.getY(), newPosition.getX(), positionable.getRepresentation().getPrimaryCodePoint());

                newPosition = oldPos;
            }

            // Special handling for the head. We're going to center the map around it.
            dispatcher.recenter(new RecenterMapEvent(player));

            if (there.equals(DungeonGoals.nextLocation)) {
                StringBuilder buf = new StringBuilder();
                buf.append("Got it.");
                buf.append(' ');
                if (there == '9') {
                    buf.append("All done!");
                } else {
                    buf.append("Next is unlocked.");
                }
                DungeonGoals.nextLocation++;

                // Notify the dungeon to update the message
                dispatcher.updateMessage(new UpdateMessageEvent(buf.toString(), true, false));
            }
        } else if (there >= '0' && there <= '9') {
            dispatcher.updateMessage(new UpdateMessageEvent("That position is still locked.", false, false));
        }
    }

    @Override
    public int getX() {
        return party[0].getX();
    }

    @Override
    public int getY() {
        return party[0].getY();
    }

    @Override
    public Positionable getPosition() {
        return party[0];
    }

    @Override
    public void setX(int x) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setY(int y) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void setPosition(int y, int x) {
        party[0].setPosition(y, x);
    }

    @Override
    public void setPosition(Positionable point) {
        setPosition(point.getY(), point.getX());
    }
}
