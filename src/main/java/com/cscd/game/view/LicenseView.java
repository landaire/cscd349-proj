package com.cscd.game.view;

import com.googlecode.blacken.core.Obligations;
import com.googlecode.blacken.examples.ViewerHelper;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public class LicenseView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        // show Apache 2.0 License
        ViewerHelper vh;
        vh = new ViewerHelper(term, "License", Obligations.getBlackenLicense());
        vh.setColor(7, 0);
        vh.run();

        return null;
    }
}
