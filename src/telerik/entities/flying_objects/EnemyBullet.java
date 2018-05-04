package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

public class EnemyBullet extends FlyingObject implements Movable {
    private int kind;
    private int velY = 3;

    public EnemyBullet(PlayState game, int kind) {
        super(game);

        this.kind = kind;

        if (kind == 0) {
            this.setPower(Constants.ENEMY_BULLET_1_POWER);
            this.setSize(new Size(10, 27));
            this.setImage(game.getSpriteSheet().getImage(257, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 350));

        } else if (kind == 1) {
            this.setPower(Constants.ENEMY_BULLET_2_POWER);
            this.setSize(new Size(10, 44));
            this.setImage(game.getSpriteSheet().getImage(267, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 400));

        }

        addToMovableCollection();
    }

    @Override
    public void move() {
        getPosition().setY(getPosition().getY() + velY);
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void onCollide() {

    }
}


