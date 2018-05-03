package telerik.entities.flying_objects;


import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.Entity;
import telerik.interfaces.Updateable;

public class Fuel extends Entity implements Updateable, Collectable {
    public Fuel(PlayState game) {
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
        this.getGame().getHandler().addUpdateable(this);
    }
}
