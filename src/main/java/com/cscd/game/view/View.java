package com.cscd.game.view;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public interface View {
    /**
     * Executes a view and returns a response. The response can be any user input,
     * transformed input, or null.
     * @param data
     * @return
     */
    public ViewResponse execute(Object data);
}
