package com.codedotorg;

public class Game {
    
    /** The title of a game */
    private String title;

    /**
     * Constructor for the Game class.
     *
     * @param title The title of the game.
     */
    public Game(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the game.
     * @return String The title of the game.
     */
    public String getTitle() {
        return title;
    }

}
