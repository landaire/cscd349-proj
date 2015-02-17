package com.cscd.game.event;

/**
 * Created by Lander Brandt on 2/17/15.
 */
public class UpdateMessageEvent {
    private String message;
    private boolean dirtyStatus;
    private boolean updatemessage;

    public UpdateMessageEvent(String message, boolean dirtyStatus, boolean updateMessage) {
        this.message = message;
        this.dirtyStatus = dirtyStatus;
        this.updatemessage = updateMessage;
    }

    public String message() {
        return message;
    }

    public boolean dirtyStatus() {
        return this.dirtyStatus;
    }

    public boolean updateMessage() {
        return this.updatemessage;
    }
}
