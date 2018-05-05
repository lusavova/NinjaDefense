package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Ammo extends Entity implements CollidesWithOwnShip {
    private int spawnDelay = Constants.FUEL_SPAWN_DELAY;
    private int live = Constants.FUEL_LIVE;
    private int width = Constants.FUEL_WIDTH;
    private int height = Constants.FUEL_HEIGHT;

    public Ammo(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(17, 23));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(525, 0, getSize().getWidth(), getSize().getHeight()));

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
        getGame().getPlayer().getShip().setBullets(getGame().getPlayer().getShip().getBullets() + 100);
    }
}
