package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class OneUp extends Entity implements CollidesWithOwnShip {
    private int spawnDelay = Constants.ONE_UP_SPAWN_DELAY;
    private int live = Constants.ONE_UP_lIVE;
    private int width = Constants.ONE_UP_WIDTH;
    private int height = Constants.ONE_UP_HEIGHT;

    public OneUp(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(25, 24));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(542, 0, getSize().getWidth(), getSize().getHeight()));

        this.setBounds();
        addToCollidableWithOwnShip();
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        getGame().getPlayer().setLives(getGame().getPlayer().getLives() + 1);
    }
}
