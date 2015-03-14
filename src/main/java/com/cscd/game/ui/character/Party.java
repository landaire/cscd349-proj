package com.cscd.game.ui.character;

import com.cscd.game.event.*;
import com.cscd.game.factory.ConfigFactory;
import com.cscd.game.factory.DungeonFactory;
import com.cscd.game.goals.DungeonGoals;
import com.cscd.game.model.classes.A_Class;
import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.grid.Grid;
import com.googlecode.blacken.grid.Positionable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lander Brandt on 2/13/15.
 */
public class Party implements Moveable, Positionable {
    private ArrayList<PositionableObject> party;
    private Dungeon dungeon;
    private ArrayList<A_Class> characters;
    private Representation baseRepresentation;

    public Party(PositionableObject[] party) {
        this(party[0].getRepresentation());

        this.party = new ArrayList<>(Arrays.asList(party));
    }

    /**
     * @param baseRepresentation represenation that will be used when characters are added
     */
    public Party(Representation baseRepresentation) {
        this.baseRepresentation = baseRepresentation;

        this.dungeon = DungeonFactory.get();
        this.characters = new ArrayList<>();
        party = new ArrayList<>();
    }

    @Override
    public void moveBy(int y, int x) {
        Integer there;
        Grid<Integer> grid = this.dungeon.getGrid();
        Integer underPlayer = ConfigFactory.get("room:floor");
        Positionable player = headPartyMember();

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
            Positionable newPosition = headPartyMember().getPosition();
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

            dispatcher.notify(new PartyMoveEvent(this));
        } else if (there >= '0' && there <= '9') {
            dispatcher.updateMessage(new UpdateMessageEvent("That position is still locked.", false, false));
        }
    }

    @Override
    public int getX() {
        return headPartyMember().getX();
    }

    @Override
    public int getY() {
        return headPartyMember().getY();
    }

    @Override
    public Positionable getPosition() {
        return headPartyMember();
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
        headPartyMember().setPosition(y, x);
    }

    @Override
    public void setPosition(Positionable point) {
        setPosition(point.getY(), point.getX());
    }

    public A_Class[] getCharacters() {
        return this.characters.toArray(new A_Class[this.characters.size()]);
    }

    public void setCharacters(A_Class[] characters) {
        this.characters = new ArrayList<>(Arrays.asList(characters));
        party.clear();

        for (int i = 0; i < characters.length; i++) {
            party.add(new PositionableObject(baseRepresentation));
        }
    }

    public void addCharacter(A_Class character) {
        this.characters.add(character);
        this.party.add(new PositionableObject(baseRepresentation));
    }

    /**
     * Removes the provided character AND a representation from the party
     * @param character character to remove
     */
    public void removeCharacter(A_Class character) {
        if (this.characters.contains(character)) {
            this.characters.remove(character);
            this.party.remove(this.party.size() - 1);
        } else {
            throw new RuntimeException("Character does not exist");
        }
    }
    
    private PositionableObject headPartyMember() {
        return party.get(0);
    }
}
