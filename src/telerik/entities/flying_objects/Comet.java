package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.enumerators.CometType;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.HurtingShip;
import telerik.interfaces.Movable;

import java.util.Random;

public class Comet extends FlyingObject implements Movable, CollidesWithOwnShip, HurtingShip {
    private CometType kind;
    private int speed;
    private int power = Constants.COMET_POWER;
    private int width = Constants.COMET_WIDTH;
    private int height = Constants.COMET_HIGHT;

    public Comet(PlayState game, CometType kind, int y, int speed) {
        super(game);

        this.kind = kind;
        this.speed = speed;

        setPower(Constants.COMET_POWER);
        setSize(new Size(Constants.COMET_WIDTH, Constants.COMET_HIGHT));

        if (kind == CometType.LEFT) {
            this.setPosition(new Position(0 - getSize().getWidth(), y));
        } else if (kind == CometType.RIGHT) {
            this.setPosition(new Position(Constants.WIDTH, y));
        }

        setSprites(kind);
        setBounds();

        addToMovableCollection();
        addToCollidableWithOwnShip();
    }

    public void setSprites(CometType kind) {
        int y;

        if (kind == CometType.LEFT) {
            y = 270;
        } else {
            y = 214;
        }

        for (int i = 0; i < 6; i++) {
            int x = Constants.COMET_WIDTH * i;
            setImage(getGame().getSpriteSheet().getImage(x, y, Constants.COMET_WIDTH, Constants.COMET_HIGHT));
        }
    }

    @Override
    public void update() {
        updateFrame();
        getPosition().setY(getPosition().getY() + speed);
        if (getPosition().getY() >= Constants.HEIGHT) {
            resetCometPosition();
        }
        if (kind == CometType.LEFT) {
            getPosition().setX(getPosition().getX() + speed);
        }

        if (this.kind == CometType.RIGHT) {
            getPosition().setX(getPosition().getX() - speed);
        }

        getBounds().moveBounds(this);
    }

    private void resetCometPosition() {

        getPosition().setY(getGame().getSpawner().getRnd().nextInt(Constants.HEIGHT - 250));

        if (kind == CometType.LEFT) {
            getPosition().setX(0 - getSize().getWidth());
        }
        if (this.kind == CometType.RIGHT) {
            getPosition().setX(Constants.WIDTH);
        }
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void onCollide() {

        resetCometPosition();
    }

    private void updateFrame() {
        frame++;

        if (frame == getImageList().size()) {
            frame = 0;
        }
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        getGame().getPlayer().setHealth(getGame().getPlayer().getHealth() - Constants.COMET_POWER);
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
