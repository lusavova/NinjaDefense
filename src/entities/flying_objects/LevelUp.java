package entities.flying_objects;

import interfaces.Entity;
import interfaces.FlyingObject;
import interfaces.Collectable;
import interfaces.Updateable;
import system.Game;
import system.Position;
import system.Size;

public class LevelUp extends Entity implements Updateable, Collectable {

    public LevelUp(Game game) {
        super(game);
        this.setSize(new Size(33, 25));
        this.setPosition(new Position(20, 110));
        this.setImage(game.getSpriteSheet().getImage(567, 0, getSize().getWidth(), getSize().getHeight()));
        addUpdateable();
    }

    @Override
    public void update() {

    }

    @Override
    public void onCollect() {
        // TODO add one life
    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }
}
