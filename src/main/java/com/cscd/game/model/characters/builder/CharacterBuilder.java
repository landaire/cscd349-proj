package com.cscd.game.model.characters.builder;

import com.cscd.game.model.characters.good.*;
import com.cscd.game.model.classes.A_Class;

/**
 * Created by Lander Brandt on 3/14/15.
 */
public class CharacterBuilder {

    /**
     * Currently only builds heroes
     * @param type
     * @return
     */
    public static A_Class build(String type) {
        A_Class character;

        switch (type) {
            case Beast.TYPE:
                character = new Beast();
                break;
            case Hospital.TYPE:
                character = new Hospital();
                break;
            case Hunter.TYPE:
                character = new Hunter();
                break;
            case Mage.TYPE:
                character = new Mage();
                break;
            case Ninja.TYPE:
                character = new Ninja();
                break;
            case Paladin.TYPE:
                character = new Paladin();
                break;
            case Warlock.TYPE:
                character = new Warlock();
                break;
            default:
                throw new RuntimeException(String.format("Unknown type \"%s\"", type));
        }

        return character;
    }
}
