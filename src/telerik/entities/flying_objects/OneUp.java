package telerik.entities.flying_objects;


import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class OneUp extends Entity implements CollidesWithOwnShip {

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
        System.out.printf("one up collide");
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }
}
