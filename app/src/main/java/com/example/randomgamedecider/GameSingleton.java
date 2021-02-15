package com.example.randomgamedecider;

import java.util.ArrayList;

public class GameSingleton {

    private static GameSingleton mInstance;
    private ArrayList<Game1> list = null;

    public static GameSingleton getInstance() {
        if(mInstance == null)
            mInstance = new GameSingleton();

        return mInstance;
    }

    private GameSingleton() {
        list = new ArrayList<Game1>();
    }


    public ArrayList<Game1> getAllGames() {
        return this.list;
    }


    public void setGames(ArrayList<Game1> games){
        this.list=games;
    }

    public void addGame(Game1 game) {
        list.add(game);
    }
}
