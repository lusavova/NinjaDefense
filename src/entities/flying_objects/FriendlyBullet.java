package entities.flying_objects;

import interfaces.FlyingObject;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class FriendlyBullet extends FlyingObject {
    private int kind;

    public FriendlyBullet(Game game, int kind) {
        super(game);
        this.kind = kind;
        if (kind == 1) {
            this.setPower(Constants.FRIENDLY_BULLET_1_POWER);
            this.setSize(new Size(7, 23));
            this.setImage(game.getSpriteSheet().getImage(240, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 250));

        } else if (kind == 2) {
            this.setPower(Constants.FRIENDLY_BULLET_2_POWER);
            this.setSize(new Size(10, 31));
            this.setImage(game.getSpriteSheet().getImage(247, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 280));

        }
        addUpdateable();
    }

    @Override
    public Position nextPosition(Position position) {
        return null;
    }

    @Override
    public void tick() {

    }

    @Override
    public void onColide() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }
}
