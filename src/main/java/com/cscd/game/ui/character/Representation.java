package com.cscd.game.ui.character;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Lander Brandt on 2/13/15.
 *
 * Moved from the {@see Dungeon} class to a standalone class
 */
public class Representation {
    public List<Integer> codepoints = new ArrayList<>();
    public List<List<Integer>> colors = new ArrayList<>();
    /**
     * Add a codepoint and a color.
     * @param codepoint
     * @param color
     */
    public void add(Integer codepoint, Integer color) {
        this.codepoints.add(codepoint);
        List<Integer> t = new ArrayList<>(1);
        t.add(color);
        this.colors.add(t);
    }
    public void add(Integer codepoint, Integer... colorset) {
        this.codepoints.add(codepoint);
        List<Integer> t = new ArrayList<>(1);
        t.addAll(Arrays.asList(colorset));
        this.colors.add(t);
    }
    /**
     * Add a codepoint and a palette range.
     * @param codepoint
     * @param startColor
     * @param count
     */
    public void add(Integer codepoint, int startColor, int count) {
        this.codepoints.add(codepoint);
        List<Integer> t = new ArrayList<>(count);
        while(count-- > 0) {
            t.add(startColor++);
        }
        this.colors.add(t);
    }
    /**
     * Add a codepoint and a color series.
     * @param codepoint
     * @param colorItr
     */
    public void add(Integer codepoint, Iterator<Integer> colorItr) {
        this.codepoints.add(codepoint);
        List<Integer> t = new ArrayList<>();
        while(colorItr.hasNext()) {
            t.add(colorItr.next());
        }
        this.colors.add(t);
    }
    /**
     * Get the codepoint/color for a float (likely Perlin) value.
     * @param value 0.0 to 1.0
     * @return {codepoint, color}
     */
    public Integer[] get(float value) {
        if (value < 0) { value *= -1; }
        int index = (int)Math.floor(value * this.codepoints.size());
        int clrIdx = (int)Math.floor(value * this.colors.get(index).size());
        Integer codepoint = this.codepoints.get(index);
        Integer color = this.colors.get(index).get(clrIdx);
        return new Integer[] {codepoint, color};
    }
    public List<Integer> getColors(int index) {
        return this.colors.get(index);
    }
    public List<Integer> getColors(double value) {
        if (value < 0) { value *= -1; }
        int index = (int)Math.floor(value * this.codepoints.size());
        return this.colors.get(index);
    }
    public Integer getColor(double value) {
        if (value < 0) { value *= -1; }
        int index = (int)Math.floor(value * this.codepoints.size());
        int clrIdx = (int)Math.floor(value * this.colors.get(index).size());
        return this.colors.get(index).get(clrIdx);
    }
    public Integer getCodePoint(double value) {
        if (value < 0) { value *= -1; }
        int index = (int)Math.floor(value * this.codepoints.size());
        return this.codepoints.get(index);
    }
    public Integer getCodePoint(int index) {
        return this.codepoints.get(index);
    }
    public int size() {
        return this.codepoints.size();
    }
    public boolean isEmpty() {
        return this.codepoints.isEmpty();
    }

    public Integer getPrimaryCodePoint() {
        return this.codepoints.get(0);
    }
}
