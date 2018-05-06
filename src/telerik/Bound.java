package telerik;

import telerik.entities.flying_objects.Comet;
import telerik.enumerators.CometType;
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

        if (gameObj instanceof Comet) {
            this.width = 16;
            this.height = 16;
            if (((Comet) gameObj).getKind() == CometType.LEFT) {
                this.x = this.x + gameObj.getSize().getWidth() - width;
                this.y = this.y + gameObj.getSize().getHeight() - height;
            }
            if (((Comet) gameObj).getKind() == CometType.RIGHT) {
                this.y = this.y + gameObj.getSize().getHeight() - height;
            }
        }
    }
}
