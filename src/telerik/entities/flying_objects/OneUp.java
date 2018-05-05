package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class OneUp extends Entity implements CollidesWithOwnShip {
    private int spawnDelay;
    private int live;
    private int width;
    private int height;

    public OneUp(PlayState game, int x, int y) {
        super(game);

        this.spawnDelay = Constants.ONE_UP_SPAWN_DELAY;
        this.live = Constants.ONE_UP_lIVE;
        this.width = Constants.ONE_UP_WIDTH;
        this.height = Constants.ONE_UP_HEIGHT;


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
