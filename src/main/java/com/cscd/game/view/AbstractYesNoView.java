package com.cscd.game.view;

import com.googlecode.blacken.terminal.BlackenKeys;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public abstract class AbstractYesNoView extends AbstractView {
    protected abstract String getHeader();

    protected abstract String getMessage();

    public ViewResponse execute(Object data) {
        return prompt(data);
    }

    public YesNoViewResponse prompt(Object data) {
        clear();

        String error = "";
        while (true) {
            centerOnLine(0, getHeader());
            centerOnLine(1, getMessage());

            if (!error.isEmpty()) {
                int last = term.getHeight() - 1;
                term.mvputs(last, 0, String.format("Error: %s", error));
            }

            int key = getKeyInput();

            if (BlackenKeys.isModifier(key)) {
                // modifier = key;
                key = term.getch(); // should be immediate
            }

            switch (key) {
                case 'y':
                case 'Y':
                    return new YesNoViewResponse(true);
                case 'n':
                case 'N':
                    return new YesNoViewResponse(false);
                default:
                    error = "Invalid input";
                    break;
            }
        }
    }
}
