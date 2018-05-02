package entities.flying_objects;

import interfaces.Entity;
import interfaces.FlyingObject;
import interfaces.Collectable;
import interfaces.Updateable;
import system.Game;
import system.Position;
import system.Size;

public class OneUp extends Entity implements Updateable, Collectable {

    public OneUp(Game game) {
        super(game);
        this.setSize(new Size(25, 24));
        this.setPosition(new Position(20, 80));
        this.setImage(game.getSpriteSheet().getImage(542, 0, getSize().getWidth(), getSize().getHeight()));
        addUpdateable();
    }

    @Override
    public void tick() {

    }

    @Override
    public void onCollect() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }
}
