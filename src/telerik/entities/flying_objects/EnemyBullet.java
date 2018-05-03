package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;

public class EnemyBullet extends FlyingObject {
    private int kind;

    public EnemyBullet(PlayState game, int kind) {
        super(game);
        this.kind = kind;
        if (kind == 1) {
            this.setPower(Constants.ENEMY_BULLET_1_POWER);
            this.setSize(new Size(10, 27));
            this.setImage(game.getSpriteSheet().getImage(257, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 350));

        } else if (kind == 2) {
            this.setPower(Constants.ENEMY_BULLET_2_POWER);
            this.setSize(new Size(10, 44));
            this.setImage(game.getSpriteSheet().getImage(267, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 400));

        }
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
