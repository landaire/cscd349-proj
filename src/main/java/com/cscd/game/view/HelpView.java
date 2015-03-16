package com.cscd.game.view;

import com.googlecode.blacken.examples.ViewerHelper;

/**
 * Created by Lander Brandt on 3/16/15.
 */
public class HelpView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        ViewerHelper vh;

        String helpMessage =
                "Dungeon Example Commands\n" +
                        "============================================================================\n" +
                        "Ctrl+L : recenter and redisplay the screen\n" +
                        "j, Down : move down                  | k, Up : move up\n" +
                        "h, Left : move left                  | l (ell), Right: move right\n" +
                        "\n" +
                        "Space : next representation set      | Backspace : previous representations\n" +
                        "\n" +
                        "Q, q, Escape : quit\n" +
                        "\n" +
                        "L : show my license                  | N : show legal notices\n" +
                        "\n" +
                        "? : this help screen\n";

        vh = new ViewerHelper(term, "Help", helpMessage);
        vh.setColor(7, 0);
        vh.run();

        return null;
    }
}
