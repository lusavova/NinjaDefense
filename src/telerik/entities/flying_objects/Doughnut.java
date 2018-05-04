package telerik.entities.flying_objects;

import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.Entity;

public class Doughnut extends Entity implements Collectable {

    public Doughnut(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(25, 23));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(500, 0, getSize().getWidth(), getSize().getHeight()));
    }


    @Override
    public void onCollect() {

    }

}
