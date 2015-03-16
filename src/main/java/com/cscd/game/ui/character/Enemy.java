package com.cscd.game.ui.character;

import com.cscd.game.model.classes.A_Class;

/**
 * Created by Lander Brandt on 3/3/15.
 */
public class Enemy extends PositionableObject {
    A_Class enemyClass;

    public Enemy(Representation representation, A_Class enemyClass) {
        super(representation);

        this.enemyClass = enemyClass;
    }
}
