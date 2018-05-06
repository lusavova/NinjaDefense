package telerik.abstract_classes;

import telerik.game_states.PlayState;
import telerik.interfaces.Collidable;

public abstract class FlyingObject extends Entity implements Collidable {

    public FlyingObject(PlayState game) {
        super(game);
    }

    public FlyingObject() {

    }
}
