package com.cscd.game.event;

import java.util.Observable;

/**
 * Created by Lander Brandt on 2/17/15.
 */
public class EventDispatcher extends Observable {
    public void updateMessage(UpdateMessageEvent event) {
        notify(event);
    }

    public void recenter(RecenterMapEvent event) {
        notify(event);
    }

    public void notify(Object o) {
        setChanged();
        notifyObservers(o);
    }
}
