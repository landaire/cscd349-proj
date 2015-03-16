package com.cscd.game.view;

import com.cscd.game.factory.DungeonFactory;
import com.googlecode.blacken.terminal.CursesLikeAPI;

/**
 * Created by Lander Brandt on 3/15/15.
 */
public abstract class AbstractView implements View {
    CursesLikeAPI term;

    public AbstractView() {
        getTerm();
    }

    public ViewResponse execute() {
        return execute(null);
    }

    public abstract ViewResponse execute(Object data);

    protected CursesLikeAPI getTerm() {
        if (term == null) {
            term = DungeonFactory.get().getTerminal();
        }

        return term;
    }

    protected void centerOnLine(int y, String string) {
        int offset = term.getWidth() / 2 - string.length() / 2;
        term.mvputs(y, offset, string);
    }

    protected void alignRight(int y, String string) {
        int offset = term.getWidth() - string.length();
        if (term.getHeight() -1 == y) {
            offset--;
        }
        term.mvputs(y, offset, string);
    }

    protected void clear() {
        this.getTerm().clear();
    }
}
