package telerik.interfaces;

import telerik.game_states.PlayState;

public abstract class Ship extends Entity implements Movable, Updateable {
    private int health;
    private int level;


    public Ship(PlayState game) {
        super(game);
        this.level = 1;
        addUpdateable();
    }

    public Ship() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getHandler().addUpdateable(this);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
