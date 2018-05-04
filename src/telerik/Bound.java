package telerik;

import telerik.interfaces.Entity;

import java.awt.*;

public class Bound extends Rectangle {
    public Bound(Entity gameObj) {
        moveBounds(gameObj);
    }

    public void moveBounds(Entity gameObj) {
        this.x = gameObj.getPosition().getX();
        this.y = gameObj.getPosition().getY();
        this.width = gameObj.getSize().getWidth();
        this.height = gameObj.getSize().getHeight();
    }
}
