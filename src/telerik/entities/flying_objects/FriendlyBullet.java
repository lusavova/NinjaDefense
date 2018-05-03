package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

public class FriendlyBullet extends FlyingObject implements Movable {
    private int kind;
    private int velY = 5;

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
        addToMovableCollection();
    }

    @Override
    public void move() {
        getPosition().setY(getPosition().getY() - velY);
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void onCollide() {

    }


}
