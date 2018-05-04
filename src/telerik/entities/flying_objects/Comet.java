package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

import java.util.Random;

public class Comet extends FlyingObject implements Movable, CollidesWithOwnShip {
    private int kind;
    private int speed;

    public Comet(PlayState game, int kind, int y, int speed) {
        super(game);

        this.speed = speed;

        this.kind = kind;
        this.setPower(Constants.COMET_POWER);
        this.setSize(new Size(Constants.COMET_WIDTH, Constants.COMET_HIGHT));

        if (kind == 1) {
            this.setPosition(new Position(0 - getSize().getWidth(), y));
        } else if (kind == 2) {
            this.setPosition(new Position(Constants.WIDTH, y));
        }

        setSprites(kind);

        this.setBounds();

        addToMovableCollection();
        addToCollidableWithOwnShip();
    }

    public void setSprites(int kind) {
        int y;
        if(kind == 1) {
            y = 270;
        }
        else {
            y = 214;
        }
        for (int i = 0; i < 6; i++) {
            this.setImage(getGame().getSpriteSheet().getImage(Constants.COMET_WIDTH * i, y, Constants.COMET_WIDTH, Constants.COMET_HIGHT));
        }
    }

    @Override
    public void move() {
        updateFrame();
        getPosition().setY(getPosition().getY() + speed);

        if (getPosition().getY() >= Constants.HEIGHT) {

            getPosition().setY(getGame().getSpawner().getRnd().nextInt(Constants.HEIGHT - 250));

            if (kind == 1) {//type 1
                getPosition().setX(0 - getSize().getWidth());
            }
            if (this.kind == 2) {//type 2
                getPosition().setX(Constants.WIDTH);
            }
        }

        if (kind == 1) {//type 1
            getPosition().setX(getPosition().getX() + speed);
        }

        if (this.kind == 2) {//type 2
            getPosition().setX(getPosition().getX() - speed);
        }

        getBounds().moveBounds(this);
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void onCollide() {
        System.out.println("Comet collide");
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
}
