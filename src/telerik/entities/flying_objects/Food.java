package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.abstract_classes.Entity;

public class Food extends Entity implements CollidesWithOwnShip, Collectable {

    private int live;

    public Food(PlayState game, int x, int y, int food) {
        super(game);

        int width = Constants.FOOD_WIDTH;
        int height = Constants.FOOD_HEIGHT;
        this.live = Constants.FOOD_LIVE;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(500, 25 * food, width, height));

        this.setBounds();
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        int currentHealth = getGame().getPlayer().getShip().getHealth();
        getGame().getPlayer().getShip().setHealth(currentHealth + Constants.FOOD_AWARD);

        System.out.println(Constants.FOOD_AWARD + " " + this + " collected.");
    }

    @Override
    public void shouldDie() {
        live--;
        if(live == 0) {
            onCollide();
        }
    }

    @Override
    public String toString(){
        return "Health";
    }
}
