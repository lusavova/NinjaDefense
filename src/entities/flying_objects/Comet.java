package entities.flying_objects;

import interfaces.FlyingObject;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class Comet extends FlyingObject {
    private int kind;

    public Comet(Game game, int kind) {
        super(game);
        this.kind = kind;
        this.setPower(Constants.COMET_POWER);
        this.setSize(new Size(57, 56));

        if (kind == 1) {
            this.setImage(game.getSpriteSheet().getImage(277, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 440));

        } else if (kind == 2) {
            this.setImage(game.getSpriteSheet().getImage(391, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 500));

        }
        addUpdateable();
    }

    @Override
    public Position nextPosition() {
        getPosition().setY(getPosition().getY() + 3);
        if (true) {//type 1
            getPosition().setX(getPosition().getX() + 3);
        }
        if (false){//type 2
            getPosition().setX(getPosition().getX() - 3);
        }
        return getPosition();
    }

    @Override
    public void update() {
        this.setPosition(nextPosition());
    }

    @Override
    public void onColide() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }
}
