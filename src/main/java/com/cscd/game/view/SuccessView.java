package com.cscd.game.view;

/**
 * Created by Lander Brandt on 3/15/15.
 */
public class SuccessView extends AbstractYesNoView {
    private static final String header = "Your party has succeeded!";
    private static final String message = "Would you like to restart your journey? (y/n)";

    protected String getHeader() {
        return header;
    }

    protected String getMessage() {
        return message;
    }
}
