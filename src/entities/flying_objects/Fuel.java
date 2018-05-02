package entities.flying_objects;

import interfaces.Collectable;
import interfaces.Entity;
import interfaces.Updateable;
import system.Game;
import system.Position;
import system.Size;

public class Fuel extends Entity implements Updateable, Collectable {
    public Fuel(Game game) {
        super(game);
        this.setSize(new Size(17, 23));
        this.setPosition(new Position(20, 50));
        this.setImage(game.getSpriteSheet().getImage(525, 0, getSize().getWidth(), getSize().getHeight()));
        addUpdateable();
    }

    @Override
    public void update() {

    }

    @Override
    public void onCollect() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }
}
