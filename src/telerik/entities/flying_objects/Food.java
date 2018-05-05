package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Food extends Entity implements CollidesWithOwnShip {

    private int live;
    private int width;
    private int height;

    public Food(PlayState game, int x, int y, int food) {
        super(game);

        this.live = Constants.FOOD_LIVE;
        this.width = Constants.FOOD_WIDTH;
        this.height = Constants.FOOD_HEIGHT;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(500, 25 * food, width, height));

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
        getGame().getPlayer().getShip().setHealth(getGame().getPlayer().getShip().getHealth() + Constants.FOOD_AWARD);
    }
}
