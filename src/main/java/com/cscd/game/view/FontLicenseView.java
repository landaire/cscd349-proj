package com.cscd.game.view;

import com.googlecode.blacken.core.Obligations;
import com.googlecode.blacken.examples.ViewerHelper;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public class FontLicenseView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        // show the font license
        ViewerHelper vh;
        new ViewerHelper(term,
                Obligations.getFontName() + " Font License",
                Obligations.getFontLicense()).run();

        return null;
    }
}
