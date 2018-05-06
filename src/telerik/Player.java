package telerik;

import telerik.entities.*;
import telerik.game_states.PlayState;

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

    public OwnShip getShip() {
        return ship;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
