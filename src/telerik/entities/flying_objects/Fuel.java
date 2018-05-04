package telerik.entities.flying_objects;


import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Fuel extends Entity implements CollidesWithOwnShip {
    public Fuel(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(17, 23));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(525, 0, getSize().getWidth(), getSize().getHeight()));

        this.setBounds();
    }


    @Override
    public void addToCollidableWithOwnShip() {

    }

    @Override
    public void onCollide() {

    }
}
