package com.codedotorg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PixelPedia {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The list of games */
    private ArrayList<Game> games;

    /** The ListView containing the names of games */
    private ListView<String> listView;

    /** The text field for the user to enter a game */
    private TextField inputField;

    /**
     * Constructs a new PixelPedia object with the given window, width, and height.
     * Initializes an empty list of games, a ListView for displaying game names, and a TextField for user input.
     * 
     * @param window the Stage object representing the window of the application
     * @param width the width of the window in pixels
     * @param height the height of the window in pixels
     */
    public PixelPedia(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        games = new ArrayList<Game>();
        listView = new ListView<String>();
        inputField = new TextField();
    }
    
    /**
     * This method sets the title of the window to "PixelPedia", creates the
     * main scene and adds the stylesheet to it.  Finally, it sets the main
     * scene to the window and shows it.
     */
    public void startApp() {
        window.setTitle("PixelPedia");
        
        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the PixelPedia application.
     * 
     * @return the main scene
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("PixelPedia");
        Button addButton = createAddButton();

        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(titleLabel, inputField, addButton, listView);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Adds a new game to the list of games.
     * It first retrieves the text from the input field, checks if it's not empty,
     * then creates a new Game object with the input text and adds it to the games list.
     * After adding the new game, it sorts the games list, refreshes the list view,
     * and finally clears the input field.
     */
    public void addGame() {
        String newGame = inputField.getText();

        if (!newGame.isEmpty()) {
            games.add(new Game(newGame));
            refreshList();
            inputField.clear();
        }
    }

    /**
     * Sorts the games in the 'games' list based on their titles.
     */
    public void sortGames() {
        
        
    }

    /**
     * Refreshes the list of games displayed in the listView.
     * It first clears the listView, then iterates over the 'games' list,
     * adding each game's name to the listView.
     */
    public void refreshList() {
        listView.getItems().clear();

        for (Game game : games) {
            listView.getItems().add(game.getTitle());
        }
    }

    /**
     * Creates a new button with the text "Add Game" and
     * sets its action to call the addGame() method.
     * 
     * @return the newly created button
     */
    public Button createAddButton() {
        Button tempButton = new Button("Add Game");

        tempButton.setOnAction(event -> {
            addGame();
        });

        return tempButton;
    }

}
