package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.enumerators.BulletShipSide;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

import java.awt.*;

public class FriendlyBullet extends FlyingObject implements Movable {

    private int kind;

    public FriendlyBullet(PlayState game, int kind, Position position, BulletShipSide side) {
        super(game);
        this.kind = kind;

        if (kind == 1) {
            this.setPower(Constants.FRIENDLY_BULLET_1_POWER);
            this.setSize(new Size(7, 23));
            this.setImage(game.getSpriteSheet().getImage(240, 0, getSize().getWidth(), getSize().getHeight()));

        } else if (kind == 2) {
            this.setPower(Constants.FRIENDLY_BULLET_2_POWER);
            this.setSize(new Size(10, 31));
            this.setImage(game.getSpriteSheet().getImage(247, 0, getSize().getWidth(), getSize().getHeight()));
        }

        int x = this.getGame().getPlayer().getShip().getPosition().getX();
        int y = this.getGame().getPlayer().getShip().getPosition().getY() + 10;

        int shipWidth = this.getGame().getPlayer().getShip().getSize().getWidth();

        if (side == BulletShipSide.RIGHT) {
            this.setPosition(new Position(x + shipWidth - this.getSize().getWidth(), y));

        } else if (side == BulletShipSide.LEFT) {
            this.setPosition(new Position(x, y));

        } else if (side == BulletShipSide.MIDLEFT) {
            this.setPosition(new Position(x + shipWidth - this.getSize().getWidth() - 16, y + 5));

        } else {
            this.setPosition(new Position(x + 16, y + 5));
        }

        this.setBounds();

        addToMovableCollection();
        addToBulletCollection();
    }


    @Override
    public void move() {
        getPosition().setY(getPosition().getY() - Constants.FRIENDLY_BULLET_1_SPEED);
        getBounds().moveBounds(this);
        if (getPosition().getY() <= 0) {
            getGame().getHandler().addToRemove(this);
        }
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    private void addToBulletCollection() {
        getGame().getHandler().addOwnBullet(this);
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }

    public int getKind() {
        return kind;
    }
}
