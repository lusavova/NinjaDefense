package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

import java.util.Random;

public class Comet extends FlyingObject implements Movable {
    private int kind;
    private int speed;

    public Comet(PlayState game, int kind, int y, int speed) {
        super(game);

        this.speed = speed;

        this.kind = kind;
        this.setPower(Constants.COMET_POWER);
        this.setSize(new Size(57, 56));

        if (kind == 1) {
            this.setImage(game.getSpriteSheet().getImage(277, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position(0 - getSize().getWidth(), 440));
        } else if (kind == 2) {
            this.setImage(game.getSpriteSheet().getImage(0, 214, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position(Constants.WIDTH, 500));
        }

        addToMovableCollection();
    }

    @Override
    public void move() {
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

    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void onCollide() {

    }
}
