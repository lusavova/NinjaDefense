package telerik.game_states;

import telerik.Player;

public class ControlPanel {

    private int points;
    private int lives;
    private int health;
    private int bullets;

    public ControlPanel(Player player) {
        this.points = player.getPoints();
        this.lives = player.getLives();
        this.health = player.getHealth();
        this.bullets = player.getBullets();
    }
}
