package com.cscd.game;

/**
 * Created by Lander Brandt on 2/3/15.
 */
public enum Color {
    Player(0xe4); // Some type of Yellow

    public final int value;

    private Color(int value) {
        this.value = value;
    }
}
