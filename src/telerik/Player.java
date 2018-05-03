package telerik;

import telerik.entities.*;
import telerik.game_states.PlayState;
import telerik.interfaces.Ship;

public class Player {
    private int points;
    private int lives;
    private OwnShip ship;

    private PlayState game;

    public Player(PlayState game) {
        this.game = game;
        this.lives = Constants.INITIAL_LIVES;
        this.points = Constants.INITIAL_POINTS;
        ship = new OwnShip(game);
    }

    public Ship getShip() {
        return ship;
    }
}
