package com.cscd.game.ui.character;

import com.googlecode.blacken.examples.Dungeon;
import com.googlecode.blacken.grid.Grid;
import com.googlecode.blacken.grid.Positionable;

/**
 * Created by Lander Brandt on 2/13/15.
 */
public class SnakePlayer implements Moveable {
    private PositionableObject[] party;
    private Dungeon dungeon;

    public SnakePlayer(PositionableObject[] party, Dungeon dungeon) {
        this.party = party;
        this.dungeon = dungeon;
    }

    @Override
    public void moveBy(int x, int y) {
        Integer there;
        Positionable oldPos = party[0].getPosition();
        Grid<Integer> grid = this.dungeon.getGrid();
        try {
            there = grid.get(player.getY() + y, player.getX() + x);
        } catch(IndexOutOfBoundsException e) {
            return;
        }

        if (dungeon.playerCanAccessPosition(there)) {
            grid.set(oldPos.getY(), oldPos.getX(), underPlayer);


            // Set each position in the party to the last positionable's position
            // so we start at the head, it moves to the desired location. The next char in the party
            // moves to the head's last position, and so on

            for (PositionableObject positionable : party) {
                positionable.setPosition(old);
            }
            player.setPosition(player.getY() + y, player.getX() + x);
            underPlayer = grid.get(player);
            grid.set(player.getY(), player.getX(), 0x40);
            int playerScreenY = player.getY() - upperLeft.getY() + MAP_START.getY();
            int playerScreenX = player.getX() - upperLeft.getX() + MAP_START.getX();
            int ScreenY2 = (MAP_END.getY() <= 0
                    ? term.getHeight() -1 + MAP_END.getY() : MAP_END.getY());
            int ScreenX2 = (MAP_END.getX() <= 0
                    ? term.getWidth() -1 + MAP_END.getX() : MAP_END.getX());
            if (playerScreenY >= ScreenY2 || playerScreenX >= ScreenX2 ||
                    playerScreenY <= MAP_START.getY() ||
                    playerScreenX <= MAP_START.getX()) {
                recenterMap();
            }
            if (there == nextLocation) {
                StringBuilder buf = new StringBuilder();
                buf.append("Got it.");
                buf.append(' ');
                if (there == '9') {
                    buf.append("All done!");
                } else {
                    buf.append("Next is unlocked.");
                }
                this.underPlayer = config.get("room:floor");
                nextLocation ++;
                this.message = buf.toString();
                dirtyStatus = true;
                this.updateMessage(false);
            }
        } else if (there >= '0' && there <= '9') {
            this.message = "That position is still locked.";
            this.updateMessage(false);
        }
    }
}
