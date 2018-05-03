package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;

public class FriendlyBullet extends FlyingObject {
    private int kind;

    public FriendlyBullet(PlayState game, int kind) {
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
        this.setPosition(this.getGame().getPlayer().getShip().getPosition());
        addUpdateable();
    }

    @Override
    public Position nextPosition() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void onColide() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getHandler().addUpdateable(this);
    }
}
