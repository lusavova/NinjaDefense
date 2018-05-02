package entities;

import system.Constants;
import system.Game;

public class Player {
    private String username;
    private int points;
    private int lives;
    private FriendlyShip ship;

    private Game game;

    public Player(String username, Game game) {
        this.username = username;
        this.game = game;
        this.lives = Constants.INITIAL_LIVES;
        this.points = Constants.INITIAL_POINTS;
        ship = new FriendlyShip(game);
    }

    public FriendlyShip getShip() {
        return ship;
    }
}
