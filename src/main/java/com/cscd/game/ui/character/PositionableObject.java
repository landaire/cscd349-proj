package com.cscd.game.ui.character;

import com.cscd.game.factory.ConfigFactory;
import com.cscd.game.factory.DungeonFactory;
import com.cscd.game.ui.Color;
import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.grid.Grid;
import com.googlecode.blacken.grid.Point;
import com.googlecode.blacken.grid.Positionable;

/**
 * Created by Lander Brandt on 2/13/15.
 */
public class PositionableObject extends Point implements Moveable, Positionable {
    protected Dungeon dungeon;
    protected Representation representation;

    /**
     * @param representation the visual representation for the object
     */
    public PositionableObject(Representation representation) {
        this.dungeon = DungeonFactory.get();
        this.representation = representation;
    }

    /**
     * Moves the player x and y units relative to where they are now. Will throw an IndexOutOfBounds
     * exception if the position is not within the boundaries of the dungeon
     * @param x
     * @param y
     */
    public void moveBy(int x, int y) {
        Integer there;
        Positionable oldPos = getPosition();
        Grid<Integer> grid = dungeon.getGrid();

        try {
            there = grid.get(getY() + y, getX() + x);
        } catch(IndexOutOfBoundsException e) {
            return;
        }

        grid.set(oldPos.getX(), oldPos.getY(), ConfigFactory.get("room:floor"));
    }

    public Representation getRepresentation() {
        return representation;
    }
}
