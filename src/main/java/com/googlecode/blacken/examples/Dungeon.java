/* blacken - a library for Roguelike games
 * Copyright &copy; 2012 Steven Black <yam655@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.googlecode.blacken.examples;

import com.cscd.game.event.EventDispatcherFactory;
import com.cscd.game.event.RecenterMapEvent;
import com.cscd.game.event.UpdateMessageEvent;
import com.cscd.game.factory.ConfigFactory;
import com.cscd.game.goals.DungeonGoals;
import com.cscd.game.model.characters.builder.CharacterBuilder;
import com.cscd.game.model.characters.good.*;
import com.cscd.game.model.classes.A_Class;
import com.cscd.game.ui.Color;
import com.cscd.game.ui.character.*;
import com.cscd.game.view.*;
import com.googlecode.blacken.bsp.BSPTree;
import com.googlecode.blacken.colors.ColorNames;
import com.googlecode.blacken.colors.ColorPalette;
import com.googlecode.blacken.core.Obligations;
import com.googlecode.blacken.core.Random;
import com.googlecode.blacken.dungeon.Room;
import com.googlecode.blacken.dungeon.SimpleDigger;
import com.googlecode.blacken.extras.PerlinNoise;
import com.googlecode.blacken.grid.Grid;
import com.googlecode.blacken.grid.Point;
import com.googlecode.blacken.grid.Positionable;
import com.googlecode.blacken.swing.SwingTerminal;
import com.googlecode.blacken.terminal.*;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A super-simple game
 * 
 * @author Steven Black
 */
public class Dungeon implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dungeon.class);
    /**
     * TerminalInterface used by the example
     */
    protected CursesLikeAPI term;
    /**
     * Whether to quit the loop or not
     */
    protected boolean quit;
    private Party player;
    private Grid<Integer> grid;
    private Random rand;
    private final static Positionable MAP_START = new Point(1, 0);
    private final static Positionable MAP_END = new Point(-1, 0);
    private Positionable upperLeft = new Point(0, 0);
    private boolean dirtyMsg = false;
    private boolean dirtyStatus = false;
    private String message;
    private float noisePlane;
    private Set<Integer> passable;
    private List<Map<Integer, Representation>> representations = new ArrayList<>();
    private int mapRepresentation = 0;
    private boolean reset = true;

    public void addRepresentations() {

        // Initialize the room walls
        Set<Integer> roomWalls = new HashSet<>();
        // roomWalls.add(ConfigFactory.get("room:wall"));
        roomWalls.add(ConfigFactory.get("room:wall:top"));
        roomWalls.add(ConfigFactory.get("room:wall:left"));
        roomWalls.add(ConfigFactory.get("room:wall:bottom"));
        roomWalls.add(ConfigFactory.get("room:wall:right"));
        roomWalls.add(ConfigFactory.get("room:wall:top-left"));
        roomWalls.add(ConfigFactory.get("room:wall:top-right"));
        roomWalls.add(ConfigFactory.get("room:wall:bottom-left"));
        roomWalls.add(ConfigFactory.get("room:wall:bottom-right"));

        // default
        Representation e;
        Map<Integer, Representation> r;

        r = new HashMap<>();
        representations.add(r);

        e = new Representation();
        e.add(ConfigFactory.get("player"), Color.Yellow.value);
        r.put(ConfigFactory.get("player"), e);

        // Initialize the party with a base representation.
        player = new Party(e);

        e = new Representation();
        e.add(ConfigFactory.get("room:door"), 58, 130, 94, 94, 94, 94, 94, 94, 94, 94);
        r.put(ConfigFactory.get("room:door"), e);

        e = new Representation();
        e.add(ConfigFactory.get("floor"), 0xee, 10);
        r.put(ConfigFactory.get("floor"), e);

        e = new Representation();
        e.add(ConfigFactory.get("hall:floor"), 0xee, 10);
        r.put(ConfigFactory.get("hall:floor"), e);

        e = new Representation();
        e.add(ConfigFactory.get("diggable"), 0x58, 14);
        r.put(ConfigFactory.get("diggable"), e);

        e = new Representation();
        e.add(ConfigFactory.get("hall:wall"), 0x58, 14);
        r.put(ConfigFactory.get("hall:wall"), e);

        for (Integer roomWall : roomWalls) {
            e = new Representation();
            e.add(roomWall, 0x58, 14);
            r.put(roomWall, e);
        }

        e = new Representation();
        e.add(ConfigFactory.get("water"), 17, 11);
        e.add(ConfigFactory.get("mountains"), 236, 20);
        e.add(ConfigFactory.get("water"), 17, 11);
        e.add(ConfigFactory.get("water"), 17, 11);
        e.add(ConfigFactory.get("water"), 17, 11);
        e.add(ConfigFactory.get("mountains"), 236, 20);
        r.put(ConfigFactory.get("void"), e);

        for (char goal = '0'; goal <= '9'; goal++) {
            Integer g = new Integer(goal);
            e = new Representation();
            e.add(g, 0x4 + g - '0');
            r.put(g, e);
        }

        // nethack

        r = new HashMap<>();
        representations.add(r);
        e = new Representation();
        e.add("@".codePointAt(0), 7);
        r.put(ConfigFactory.get("player"), e);

        e = new Representation();
        e.add("+".codePointAt(0), 7);
        r.put(ConfigFactory.get("room:door"), e);

        e = new Representation();
        e.add(".".codePointAt(0), 7);
        r.put(ConfigFactory.get("floor"), e);

        e = new Representation();
        e.add("#".codePointAt(0), 7);
        r.put(ConfigFactory.get("hall:floor"), e);

        e = new Representation();
        e.add(" ".codePointAt(0), 0);
        r.put(ConfigFactory.get("diggable"), e);

        e = new Representation();
        e.add(" ".codePointAt(0), 0);
        r.put(ConfigFactory.get("hall:wall"), e);

        e = new Representation();
        e.add("-".codePointAt(0), 7);
        r.put(ConfigFactory.get("room:wall:top"), e);
        r.put(ConfigFactory.get("room:wall:bottom"), e);
        r.put(ConfigFactory.get("room:wall:top-left"), e);
        r.put(ConfigFactory.get("room:wall:top-right"), e);
        r.put(ConfigFactory.get("room:wall:bottom-left"), e);
        r.put(ConfigFactory.get("room:wall:bottom-right"), e);

        e = new Representation();
        e.add("|".codePointAt(0), 7);
        r.put(ConfigFactory.get("room:wall:left"), e);
        r.put(ConfigFactory.get("room:wall:right"), e);

        for (Integer roomWall : roomWalls) {
            if (!r.containsKey(roomWall)) {
                e = new Representation();
                e.add(roomWall, 0x58, 14);
                r.put(roomWall, e);
            }
        }

        e = new Representation();
        e.add(" ".codePointAt(0), 0);
        r.put(ConfigFactory.get("void"), e);

        for (char goal = '0'; goal <= '9'; goal++) {
            Integer g = new Integer(goal);
            e = new Representation();
            e.add(g, 0x4 + g - '0');
            r.put(g, e);
        }

        // moria

        r = new HashMap<>();
        representations.add(r);

        e = new Representation();
        e.add((int) '@', Color.Yellow.value);
        r.put(ConfigFactory.get("player"), e);

        e = new Representation();
        e.add((int) '+', 58, 130, 94, 94, 94, 94, 94, 94, 94, 94);
        e.add((int) '+', 58, 130, 94, 94, 94, 94, 94, 94, 94, 94);
        e.add((int) '\'', 58, 130, 94, 94, 94, 94, 94, 94, 94, 94);
        r.put(ConfigFactory.get("room:door"), e);

        e = new Representation();
        e.add((int) '.', 0xee, 10);
        r.put(ConfigFactory.get("floor"), e);

        r.put(ConfigFactory.get("hall:floor"), e);

        e = new Representation();
        e.add(BlackenCodePoints.CODEPOINT_MEDIUM_SHADE, 0x58, 14);
        e.add(BlackenCodePoints.CODEPOINT_LIGHT_SHADE, 0x58, 14);
        e.add(BlackenCodePoints.CODEPOINT_MEDIUM_SHADE, 0x58, 14);
        e.add(BlackenCodePoints.CODEPOINT_MEDIUM_SHADE, 0x58, 14);
        r.put(ConfigFactory.get("diggable"), e);

        e = r.get(ConfigFactory.get("diggable"));
        r.put(ConfigFactory.get("hall:wall"), e);

        for (Integer roomWall : roomWalls) {
            e = new Representation();
            e.add(BlackenCodePoints.CODEPOINT_MEDIUM_SHADE, 0x58, 14);
            r.put(roomWall, e);
        }

        e = new Representation();
        e.add(" ".codePointAt(0), 0);
        r.put(ConfigFactory.get("void"), e);

        for (char goal = '0'; goal <= '9'; goal++) {
            Integer g = new Integer(goal);
            e = new Representation();
            e.add(g, 0x4 + g - '0');
            r.put(g, e);
        }
    }

    /**
     * Create a new instance
     */
    public Dungeon() {
        rand = new Random();
        noisePlane = rand.nextFloat();

        grid = new Grid<>(ConfigFactory.get("diggable"), 100, 100);
        passable = new HashSet<>();
        passable.add(ConfigFactory.get("floor"));
        passable.add(ConfigFactory.get("hall:floor"));
        passable.add(ConfigFactory.get("room:door"));
    }

    public Grid<Integer> getGrid() {
        return this.grid;
    }

    /**
     * Make a map
     */
    private void makeMap() {
        grid.clear();
        SimpleDigger simpleDigger = new SimpleDigger();
        BSPTree<Room> bsp = simpleDigger.setup(grid, ConfigFactory.getConfig());
        List<Room> rooms = new ArrayList(bsp.findContained(null));
        Collections.shuffle(rooms, rand);
        DungeonGoals.nextLocation = 0x31;
        int idx = 0;
        for (Integer c = 0x31; c < 0x3a; c++) {
            rooms.get(idx).assignToContainer(c);
            idx++;
            if (idx >= rooms.size()) {
                idx = 0;
                Collections.shuffle(rooms, rand);
            }
        }
        // simpleDigger.digRoomAvoidanceHalls(bsp, grid, config);
        simpleDigger.digHallFirst(bsp, grid, ConfigFactory.getConfig(), false);
        Integer underPlayer = ConfigFactory.get("room:floor");
        Positionable pos = rooms.get(idx).placeThing(grid, underPlayer, ConfigFactory.get("player"));
        this.player.setPosition(pos);

        recenterMap();
    }

    private void showMap() {
        int ey = MAP_END.getY();
        int ex = MAP_END.getX();
        if (ey <= 0) {
            ey += term.getHeight();
        }
        if (ex <= 0) {
            ex += term.getWidth();
        }
        Map<Integer, Representation> currentRep = this.representations.get(this.mapRepresentation);
        for (int y = MAP_START.getY(); y < ey; y++) {
            for (int x = MAP_START.getX(); x < ex; x++) {
                int y1 = y + upperLeft.getY() - MAP_START.getY();
                int x1 = x + upperLeft.getX() - MAP_START.getX();
                int what = ConfigFactory.get("void");
                if (y1 >= 0 && x1 >= 0 && y1 < grid.getHeight() && x1 < grid.getWidth()) {
                    what = grid.get(y1, x1);
                }
                Representation how = currentRep.get(what);
                if (how == null) {
                    LOGGER.error("Failed to find entry for {}", BlackenKeys.toString(what));
                }
                double noise = PerlinNoise.noise(x1, y1, noisePlane);
                int as = how.getCodePoint(noise);
                int fclr = how.getColor(noise);
                int bclr = 0;
                EnumSet<CellWalls> walls = EnumSet.noneOf(CellWalls.class);
                if (what >= '0' && what <= '9') {
                    if (what > DungeonGoals.nextLocation) {
                        walls = CellWalls.BOX;
                    }
                }
                term.set(y, x, BlackenCodePoints.asString(as),
                         fclr, bclr, EnumSet.noneOf(TerminalStyle.class), walls);
            }
        }
    }
    
    /**
     * The application loop.
     * @return the quit status
     */
    public boolean loop() {
        int ch = BlackenKeys.NO_KEY;
        int mod;

        while (!quit) {
            if (reset) {
                chooseParty();

                ch = BlackenKeys.NO_KEY;

                makeMap();
                term.disableEventNotices();
                updateStatus();
                player.moveBy(0,0);
                this.message = "Welcome to Dungeon!";
                term.move(-1, -1);

                reset = false;
            }


            if (dirtyStatus) {
                updateStatus();
            }
            updateMessage(false);
            showMap();
            term.setCursorLocation(player.getY() - upperLeft.getY() + MAP_START.getY(),
                                   player.getX() - upperLeft.getX() + MAP_START.getX());
            this.term.getPalette().rotate(0xee, 10, +1);
            // term.refresh();
            mod = BlackenKeys.NO_KEY;
            ch = term.getch();
            if (ch == BlackenKeys.RESIZE_EVENT) {
                this.refreshScreen();
                continue;
            } else if (BlackenKeys.isModifier(ch)) {
                mod = ch;
                ch = term.getch();
            }
            // LOGGER.debug("Processing key: {}", ch);
            if (ch != BlackenKeys.NO_KEY) {
                this.message = null;
                doAction(mod, ch);
            }
        }
        return this.quit;
    }

    public boolean playerCanAccessPosition(Integer there) {
        return there.equals(ConfigFactory.get("player")) || passable.contains(there) || there == DungeonGoals.nextLocation;
    }

    private void updateMessage(boolean press) {
        if (this.message != null && !dirtyMsg) {
            dirtyMsg = true;
        }
        if (dirtyMsg) {
            for (int x = 0; x < term.getWidth(); x++) {
                term.mvaddch(0, x, ' ');
            }
            if (message == null) {
                dirtyMsg = false;
            } else {
                term.mvputs(0, 0, message);
            }
            if (press) {
                message = null;
            }
        }
    }

    /**
     * Update the status.
     */
    private void updateStatus() {
        term.setCurForeground(7);
        dirtyStatus = false;
        for (int x = 0; x < term.getWidth()-1; x++) {
            term.mvaddch(term.getHeight(), x, ' ');
        }

        Integer nextLocation = DungeonGoals.nextLocation;
        if (nextLocation <= '9') {
            term.mvputs(term.getHeight(), 0, "Get the ");
            term.setCurForeground((nextLocation - '0') + 0x4);
            term.addch(nextLocation);
            term.setCurForeground(7);
            if (nextLocation == '9') {
                term.puts(" to win.");
            }
        } else {
            term.mvputs(term.getHeight(), 0, "You won!");
        }
        String msg = "Q to quit.";
        term.mvputs(term.getHeight(), term.getWidth() - msg.length() - 1, msg);
    }

    private void refreshScreen() {
        term.clear();
        updateStatus();
        updateMessage(false);
        this.showMap();
    }
    
    private boolean doAction(int modifier, int ch) {
        View nextView = null;
        if (BlackenModifier.MODIFIER_KEY_CTRL.hasFlag(modifier)) {
            switch (ch) {
            case 'l':
            case 'L':
                this.recenterMap();
                refreshScreen();
                break;
            }
            return false;
        } else {
            switch (ch) {
            case 'j':
            case BlackenKeys.KEY_DOWN:
            case BlackenKeys.KEY_NP_2:
            case BlackenKeys.KEY_KP_DOWN:
                player.moveBy(+1,  0);
                break;
            case 'k':
            case BlackenKeys.KEY_UP:
            case BlackenKeys.KEY_NP_8:
            case BlackenKeys.KEY_KP_UP:
                player.moveBy(-1,  0);
                break;
            case 'h':
            case BlackenKeys.KEY_LEFT:
            case BlackenKeys.KEY_NP_4:
            case BlackenKeys.KEY_KP_LEFT:
                player.moveBy(0,  -1);
                break;
            case 'l':
            case BlackenKeys.KEY_RIGHT:
            case BlackenKeys.KEY_NP_6:
            case BlackenKeys.KEY_KP_RIGHT:
                player.moveBy(0,  +1);
                break;
            case ' ':
                this.mapRepresentation++;
                if (this.mapRepresentation >= this.representations.size()) {
                    this.mapRepresentation = 0;
                }
                break;
            case BlackenKeys.KEY_BACKSPACE:
                this.mapRepresentation--;
                if (this.mapRepresentation < 0) {
                    this.mapRepresentation = this.representations.size() -1;
                }
                break;
            case 'q':
            case 'Q':
            case BlackenKeys.KEY_ESCAPE:
                this.quit = true;
                return false;
            case 'L':
                nextView = new LicenseView();
                break;
            case 'N':
                nextView = new LegalView();
                break;
            case 'F':
                nextView = new FontLicenseView();
                break;
            case '?':
                nextView = new HelpView();
                break;
            default:
                return false;
            }

            if (nextView != null) {
                nextView.execute(null);
                refreshScreen();
            }
        }
        return true;
    }

    private void recenterMap() {
        upperLeft.setY(player.getY() - (term.getHeight()-2)/2);
        upperLeft.setX(player.getX() - (term.getWidth()-2)/2);
    }
    
    
    /**
     * Initialize the example
     * 
     * @param term alternate TerminalInterface to use
     * @param palette alternate ColorPalette to use
     */
    public void init(TerminalInterface term, ColorPalette palette) {
        if (term == null) {
            term = new SwingTerminal();
            term.init("Dungeon", 25, 80);
        }
        this.term = new CursesLikeAPI(term);
        if (palette == null) {
            palette = new ColorPalette();
            palette.addAll(ColorNames.XTERM_256_COLORS, false);
        } 
        this.term.setPalette(palette);

        EventDispatcherFactory.get().addObserver(this);
        addRepresentations();
    }


    public void splash() {
        SplashView splashView = new SplashView();
        splashView.execute();
    }

    /**
     * Quit the application.
     * 
     * <p>This calls quit on the underlying TerminalInterface.</p>
     */
    public void quit() {
        term.quit();
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof UpdateMessageEvent) {
            UpdateMessageEvent event = (UpdateMessageEvent)arg;
            this.message = event.message();

            this.dirtyStatus = event.dirtyStatus();
            this.updateMessage(event.updateMessage());
        } else if (arg instanceof RecenterMapEvent) {
            checkForRecenter(((RecenterMapEvent) arg).positionable());
        }
    }

    private void checkForRecenter(Positionable player) {
        grid.set(player.getY(), player.getX(), 0x40);
        int playerScreenY = player.getY() - upperLeft.getY() + MAP_START.getY();
        int playerScreenX = player.getX() - upperLeft.getX() + MAP_START.getX();
        int ScreenY2 = (MAP_END.getY() <= 0
                ? term.getHeight() -1 + MAP_END.getY() : MAP_END.getY());
        int ScreenX2 = (MAP_END.getX() <= 0
                ? term.getWidth() -1 + MAP_END.getX() : MAP_END.getX());
        if (playerScreenY >= ScreenY2 || playerScreenX >= ScreenX2 ||
                playerScreenY <= MAP_START.getY() ||
                playerScreenX <= MAP_START.getX()) {
            recenterMap();
        }
    }
    
    public void chooseParty()
    {
        CharacterSelectionView view = new CharacterSelectionView();
    	A_Class[] classes = (A_Class[])view.execute(null).getData();

        this.player.setCharacters(classes);
    }//end choose

 public CursesLikeAPI getTerminal()
 {
  return term;
 }
 
 public void gameOver(String string)
 {
     DeathView view = new DeathView();
     YesNoViewResponse response = view.prompt(null);
     if (response.isYes()) {
         this.reset = true;
     } else {
         quit();
     }
 }
}
