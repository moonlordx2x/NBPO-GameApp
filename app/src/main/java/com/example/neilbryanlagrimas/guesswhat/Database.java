package com.example.neilbryanlagrimas.guesswhat;

/**
 * Created by Neil Bryan Lagrimas on 29/12/2018.
 */

public class Database {

    String Media;
    int Media_logo;

    public Database(String media, int media_logo) {
        Media = media;
        Media_logo = media_logo;
    }

    public String getMedia() {
        return Media;
    }

    public int getMedia_logo() {
        return Media_logo;
    }
}
