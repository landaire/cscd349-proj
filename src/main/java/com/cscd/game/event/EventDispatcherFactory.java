package com.cscd.game.event;

/**
 * Created by Lander Brandt on 2/17/15.
 */
public class EventDispatcherFactory {
    static EventDispatcher dispatcher;

    public static EventDispatcher get() {
        if (dispatcher == null) {
            dispatcher = new EventDispatcher();
        }

        return dispatcher;
    }
}
