package entities.flying_objects;

import interfaces.Collectable;
import interfaces.Entity;
import interfaces.Updateable;
import system.Game;
import system.Position;
import system.Size;

public class Doughnut extends Entity implements Updateable, Collectable {

    public Doughnut(Game game) {
        super(game);
        this.setSize(new Size(25, 23));
        this.setPosition(new Position(20, 20));
        this.setImage(game.getSpriteSheet().getImage(500, 0, getSize().getWidth(), getSize().getHeight()));
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
