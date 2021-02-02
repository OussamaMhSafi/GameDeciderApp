package com.example.randomgamedecider

import android.widget.ImageView

class GameSingleton private constructor(){


    var image:ImageView = TODO()
    var allGames:ArrayList<Game> = TODO()


    private object HOLDER {
        val INSTANCE = GameSingleton()
    }

    companion object {
        val instance: GameSingleton by lazy { HOLDER.INSTANCE }
    }

     fun onCreate(){


    }

}