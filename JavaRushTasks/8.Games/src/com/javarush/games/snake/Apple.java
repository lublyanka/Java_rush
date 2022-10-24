package com.javarush.games.snake;

import com.javarush.engine.cell.*;

public class Apple extends GameObject{

    private final static String APPLE_SIGN="\uD83C\uDF4E";

    public Apple(int x, int y) {
        super(x, y);
    }

    public  void draw(Game game){
        game.setCellValueEx(x, y, Color.NONE, APPLE_SIGN, Color.LIME, 75);
    }
}