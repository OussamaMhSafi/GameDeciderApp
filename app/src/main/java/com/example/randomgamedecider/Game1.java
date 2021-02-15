package com.example.randomgamedecider;

public class Game1 {

    public String title;
    public String genre;
    public int imgResource;

    public Game1(String title, String genre, int imgResource) {
        this.title = title;
        this.genre = genre;
        this.imgResource = imgResource;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }
}
