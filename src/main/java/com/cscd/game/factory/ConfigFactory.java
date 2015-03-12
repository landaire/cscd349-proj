package com.cscd.game.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lander Brandt on 3/5/15.
 */
public class ConfigFactory {
    static Map<String, Integer> config;
    static boolean initialized = false;

    public static Integer get(String opt) {
        if (!initialized) {
            initialize();
        }

        return config.get(opt);
    }

    public static Map<String, Integer> getConfig() {
        return config;
    }

    private static void initialize() {
        if (initialized) {
            return;
        }

        initialized = true;

        config = new HashMap<>();

        // Used by Simple Digger
        // Courier New doesn't have Heavy, but does have Double.
        config.put("diggable", "\u2592".codePointAt(0)); // 50% shade
        config.put("floor", "\u25AA".codePointAt(0)); // small black square
        config.put("hall:floor", "\u25AB".codePointAt(0)); // sm. white square
        config.put("hall:wall", "\u2591".codePointAt(0)); // 25% shade
        config.put("room:door", "+".codePointAt(0));
        config.put("room:wall:top", "\u2500".codePointAt(0)); // light horiz
        config.put("room:wall:left", "\u2502".codePointAt(0)); // light vert
        config.put("room:wall:bottom", "\u2550".codePointAt(0)); // heavy horiz
        config.put("room:wall:right", "\u2551".codePointAt(0)); // heavy horiz
        config.put("room:wall:top-left", "\u250C".codePointAt(0)); // Lh/Lv
        config.put("room:wall:top-right", "\u2556".codePointAt(0)); // Lh/Hv
        config.put("room:wall:bottom-left", "\u2558".codePointAt(0)); // Hh/Lv
        config.put("room:wall:bottom-right", "\u255D".codePointAt(0)); // Hv/Hh

        // game specific
        config.put("void", " ".codePointAt(0));
        config.put("player", "@".codePointAt(0));
        config.put("water", "~".codePointAt(0));
        config.put("mountains", "^".codePointAt(0));
    }
}
