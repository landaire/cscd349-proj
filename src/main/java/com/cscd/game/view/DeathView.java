package com.cscd.game.view;

import com.googlecode.blacken.terminal.BlackenKeys;

/**
 * Created by Lander Brandt on 3/15/15.
 */
public class DeathView extends AbstractYesNoView {
    private static final String header = "Your party has been slain.";
    private static final String message = "Would you like to try again? (y/n)";

    protected String getHeader() {
        return header;
    }

    protected String getMessage() {
        return message;
    }
}
