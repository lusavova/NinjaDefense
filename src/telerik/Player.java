package telerik;

import telerik.entities.*;
import telerik.game_states.PlayState;
import telerik.interfaces.Ship;

public class Player {

    private int points;
    private int lives;
    private int health;
    private int bullets;
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getBullets() {
        return bullets;
    }

    public void setBullets(int bullets) {
        this.bullets = bullets;
    }
}
