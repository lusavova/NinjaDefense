package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Food extends Entity implements CollidesWithOwnShip {

    public Food(PlayState game, int x, int y, int food) {
        super(game);

        this.setSize(new Size(Constants.FOOD_WIDTH, Constants.FOOD_HEIGHT));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(500, 25 * food, Constants.FOOD_WIDTH, Constants.FOOD_HEIGHT));

        this.setBounds();
        addToCollidableWithOwnShip();
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);

        System.out.println(getGame().getPlayer().getHealth());
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        getGame().getPlayer().setHealth(getGame().getPlayer().getHealth() + 5);
    }
}
