package com.cscd.game.ui.builder;

import com.cscd.game.model.characters.bad.Ogre;
import com.cscd.game.ui.Color;
import com.cscd.game.ui.character.Enemy;
import com.cscd.game.ui.character.PositionableObject;
import com.cscd.game.ui.character.Representation;

import java.util.HashMap;

/**
 * Created by Lander Brandt on 3/3/15.
 */
public class CharacterBuilder {
    private static HashMap<String, Representation> representations = new HashMap<>();
    private static boolean representationsSet = false;

    public static PositionableObject build(String name) {
        if (!representationsSet) {
            initializeRepresentations();
            representationsSet = true;
        }

        switch (name) {
            case Ogre.name:
                return new Enemy(representations.get(name), new Ogre());
        }

        throw new RuntimeException("No such character");
    }

    private static void initializeRepresentations() {
        Representation r = new Representation();
        // Ogre
        r.add((int)'O', Color.Red.value);

        representations.put(Ogre.name, r);
    }
}
