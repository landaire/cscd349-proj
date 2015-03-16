package com.cscd.game.view;

import com.googlecode.blacken.core.Obligations;
import com.googlecode.blacken.examples.ViewerHelper;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public class LegalView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        // show Notices file
        // This is the only one that needs to be shown for normal games.
        ViewerHelper vh;
        vh = new ViewerHelper(term, "Legal Notices", Obligations.getBlackenNotice());
        vh.setColor(7, 0);
        vh.run();

        return null;
    }
}
