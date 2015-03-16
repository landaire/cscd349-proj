package com.cscd.game.view;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public class YesNoViewResponse extends ViewResponse {
    Boolean yes;

    public YesNoViewResponse(boolean yes) {
        super(yes);

        this.yes = yes;
    }

    public boolean isYes() {
        return yes;
    }

    public boolean isNo() {
        return !yes;
    }
}
