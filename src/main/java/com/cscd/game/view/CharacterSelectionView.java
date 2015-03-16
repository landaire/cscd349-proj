package com.cscd.game.view;

import com.cscd.game.model.characters.builder.CharacterBuilder;
import com.cscd.game.model.characters.good.*;
import com.cscd.game.model.classes.A_Class;
import com.googlecode.blacken.terminal.BlackenKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lander Brandt on 3/15/15.
 */
public class CharacterSelectionView extends AbstractView {
    @Override
    public ViewResponse execute(Object data) {
        int characterCount = 0;
        term.disableEventNotices();

        ArrayList<A_Class> chosenCharacters = new ArrayList<>();
        String chosenCharacterNames = "";

        // Register selectable heroes
        HashMap<Integer, String> heroes = new HashMap<>();
        String[] names = new String[] {
                Beast.TYPE, Hospital.TYPE, Hunter.TYPE, Mage.TYPE,
                Ninja.TYPE, Paladin.TYPE, Warlock.TYPE,
        };

        for (int i = 0; i < names.length; i++) {
            heroes.put(i + 1, names[i]);
        }

        String error = "";
        while (true) {
            term.clear();
            term.setCurBackground(0);
            term.setCurForeground(7);
            centerOnLine(0, "Choose your party");

            int line = 3;
            for (Map.Entry<Integer, String> entry : heroes.entrySet()) {
                term.mvputs(line, 0, String.format("%d. %s", entry.getKey(), entry.getValue()));
                line += 2;
            }

            term.mvputs(line, 0, "Chosen characters: " + chosenCharacterNames);
            if (!error.isEmpty()) {
                term.mvputs(++line, 0, String.format("Error: %s", error));
            }

            int last = term.getHeight() - 1;
            term.mvputs(last-1, 0, "Press '?' for Help.");
            if(characterCount >= 2)
            {
                alignRight(last-0, "Press C to continue");

                //need a way to disable Enter key until they have 2 or more in the party
            }
            //alignRight(last-0, "Press any other key to continue.");
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

            // Ignore these keys
            if (key == BlackenKeys.NO_KEY || key == BlackenKeys.RESIZE_EVENT) {
                continue;
            }

            if (key >= '0' && key <= '9') {
                int selectedCharacter = Integer.parseInt(Character.toString((char)key));

                // Check if the user's input is invalid -- if it is then display an error and continue the loop
                if (!heroes.containsKey(selectedCharacter) ) {
                    error = "Invalid character selection";
                    continue;
                }

                String type = heroes.get(selectedCharacter);
                chosenCharacterNames += type + ", ";
                characterCount++;

                chosenCharacters.add(CharacterBuilder.build(type));
                error = "";
                continue;
            } else if (key == 'C' || key == 'c') {
                if (characterCount >= 2) {
                    break;
                }
                error = "Please choose at least two party members";
                continue;
            }

            error = "Invalid input";
        }

        return new ViewResponse(chosenCharacters.toArray(new A_Class[chosenCharacters.size()]));
    }
}
