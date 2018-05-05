package telerik.interfaces;

import telerik.game_states.PlayState;

public abstract class FlyingObject extends Entity implements Collidable {

    public FlyingObject(PlayState game) {
        super(game);
    }

    public FlyingObject() {

    }
}
