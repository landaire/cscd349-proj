package com.cscd.game;

/**
 * Created by Lander Brandt on 2/3/15.
 */
public enum Color {
    Black(0x000000),
    Red3(0xcd0000),
    Green3(0x00cd00),
    Yellow3(0xcdcd00),
    Blue2(0x0000ee),
    Magenta3(0xcd00cd),
    Cyan3(0x00cdcd),
    Gray90(0xe5e5e5),
    Gray50(0x7f7f7f),
    Red(0xff0000),
    Green(0x00ff00),
    Yellow(0xffff00),
    Rgb(0x5c5cff),
    Magenta(0xff00ff),
    Cyan(0x00ffff),
    White(0xffffff);

    public final int value;

    private Color(int value) {
        this.value = value;
    }
}
