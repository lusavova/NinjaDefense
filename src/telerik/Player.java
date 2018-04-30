package telerik;

public class Player {
    private String username;
    private int lives;
    private int points;
    private int health;

    public Player(String username) {
        this.username = username;
        this.lives = Constants.INITIAL_LIVES;
        this.points = Constants.INITIAL_POINTS;
        this.health = Constants.INITIAL_HEALTH;
    }
}
