package interfaces;

import system.Game;
import types.FlyingObjectType;

public abstract class FlyingObject extends Entity implements Movable, Updateable, Colidable {
    private FlyingObjectType type;
    private int power;

    public FlyingObject(Game game) {
        super(game);
    }

    public FlyingObject() {

    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
