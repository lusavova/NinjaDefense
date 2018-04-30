package telerik.interfaces;

import telerik.Position;

public abstract class GameObject implements Movable, Collidable {
    private Position position;

    public GameObject(Position position) {
        this.position = position;
    }

    //size
    //intial_state
}
