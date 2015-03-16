package com.cscd.game.view;

import com.googlecode.blacken.terminal.BlackenKeys;

/**
 * Created by Lander Brandt on 3/15/15.
 */
public class SplashView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        boolean ready = false;
        term.disableEventNotices();
        while (!ready) {
            term.clear();
            term.setCurBackground(0);
            term.setCurForeground(7);
            centerOnLine(0, "Dungeon");
            centerOnLine(1, "A very fun dungeon game");
            centerOnLine(3, "Originally created by Steven Black (Copyright (C) 2010-2012)");
            centerOnLine(5, "Modified for CSCD 349 by Lander Brandt, Tony Moua, Sean Burright");
            centerOnLine(6, "Released under the Apache 2.0 License.");
            term.mvputs(8, 0, "HOW TO PLAY");
            term.mvputs(9, 0, "-----------");
            term.mvputs(10,0, "A representation of a map is shown.  You and your party are the");
            term.mvputs(11,0, "at sign (@).  The object is to run around collecting the numbers");
            term.mvputs(12,0, "in order.  The numbers have walls around them that only open up");
            term.mvputs(13,0, "if you've collected the previous number.");
            term.mvputs(15,0, "Use the arrow keys to move around.");
            term.mvputs(17,0, "You will randomly encounter opponents in halls");
            int last = term.getHeight() - 1;
            term.mvputs(last-1, 0, "Press '?' for Help.");
            alignRight(last-0, "Press any other key to continue.");
            int key = BlackenKeys.NO_KEY;
            while(key == BlackenKeys.NO_KEY) {
                // This works around an issue with the AWT putting focus someplace weird
                // if the window is not in focus when it is shown. It only happens on
                // startup, so a splash screen is the perfect place to fix it.
                // A normal game might want an animation at such a spot.
                key = term.getch(200);
            }
            // int modifier = BlackenKeys.NO_KEY;
            if (BlackenKeys.isModifier(key)) {
                // modifier = key;
                key = term.getch(); // should be immediate
            }

            View nextView = null;

            switch(key) {
                case BlackenKeys.NO_KEY:
                case BlackenKeys.RESIZE_EVENT:
                    // should be safe
                    break;
                case 'l':
                case 'L':
                    nextView = new LicenseView();
                    break;
                case 'n':
                case 'N':
                    nextView = new LegalView();
                    break;
                case 'f':
                case 'F':
                    nextView = new FontLicenseView();
                    break;
                case '?':
                    nextView = new HelpView();
                    break;
                default:
                    ready = true;
                    break;
            }

            if (nextView != null) {
                nextView.execute(null);
            }
        }

        return null;
    }
}
