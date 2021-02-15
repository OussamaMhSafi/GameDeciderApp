package com.example.randomgamedecider

import android.media.Image
import android.widget.ImageView

class Game() {


    var imageResource:Int
    get(){
        return imageResource
    }
        set(value) {
            imageResource=value
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

    constructor(title:String, genre:String, imageResource: Int) : this() {
        this.title=title
        this.genre=genre
        this.imageResource=imageResource
    }

}



