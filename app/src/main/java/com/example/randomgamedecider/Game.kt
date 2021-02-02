package com.example.randomgamedecider

import android.media.Image
import android.widget.ImageView

class Game() {

    var gameImage:ImageView
    get(){
        return gameImage
    }
        set(value) {
            gameImage=value
        }

    var title: String
        get() {
            return title
        }
        set(value) {
            title = value
        }


    var genre: String
        get() {
            return genre
        }
        set(value) {
            genre = value
        }

    constructor(title:String, genre:String, gameImage: ImageView){
        this.title=title
        this.genre=genre
        this.gameImage=gameImage
    }

}



