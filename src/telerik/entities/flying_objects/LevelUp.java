package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;


public class LevelUp extends Entity implements CollidesWithOwnShip {
    private int spawnDelay;
    private int live;
    private int width;
    private int height;

    public LevelUp(PlayState game, int x, int y) {
        super(game);

        this.spawnDelay = Constants.LEVELUP_SPAWN_DELAY;
        this.live = Constants.LEVELUP_lIVE;
        this.width = Constants.LEVEL_UP_WIDTH;
        this.height = Constants.LEVEL_UP_HEIGHT;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(567, 0, getSize().getWidth(), getSize().getHeight()));

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
        getGame().getPlayer().getShip().upgradeShip();
    }
}
