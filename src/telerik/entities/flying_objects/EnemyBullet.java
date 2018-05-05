package telerik.entities.flying_objects;


import javafx.geometry.Pos;
import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

import java.awt.*;

public class EnemyBullet extends FlyingObject implements Movable, CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {
    private int bulletOnePower = Constants.ENEMY_BULLET_1_POWER;
    private int bulletTwoPower = Constants.ENEMY_BULLET_2_POWER;
    private int bulletOneHeight = Constants.ENEMY_BULLET_1_HEIGHT;
    private int bulletOneWidht = Constants.ENEMY_BULLET_1_WIDTH;
    private int bulletTwoHeight = Constants.ENEMY_BULLET_2_HEIGHT;
    private int bulletTwoWidth = Constants.ENEMY_BULLET_2_WIDTH;
    private int speed = Constants.ENEMY_BULLET_VEL;


    private int power;

    public EnemyBullet(PlayState game, int kind, int x, int y) {
        super(game);

        if (kind == 0) {
            this.setPower(Constants.ENEMY_BULLET_1_POWER);
            this.setSize(new Size(10, 27));
            this.setImage(game.getSpriteSheet().getImage(257, 0, Constants.ENEMY_BULLET_1_WIDTH, Constants.ENEMY_BULLET_1_HEIGHT));

        } else if (kind == 1) {
            this.setPower(Constants.ENEMY_BULLET_2_POWER);
            this.setSize(new Size(10, 44));
            this.setImage(game.getSpriteSheet().getImage(267, 0, Constants.ENEMY_BULLET_2_WIDTH, Constants.ENEMY_BULLET_2_HEIGHT));
        }

        this.setPosition(new Position(x - getSize().getWidth() / 2, y + getSize().getHeight() / 2));
        this.setBounds();

        addToMovableCollection();
        addToCollidableWithOwnBullet();
        addToCollidableWithOwnShip();
    }

    @Override
    public void update() {
        getPosition().setY(getPosition().getY() + Constants.ENEMY_BULLET_VEL);
        if (getPosition().getY() >= Constants.HEIGHT) {
            getGame().getHandler().addToRemove(this);
        }
        getBounds().moveBounds(this);
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public void addToCollidableWithOwnBullet() {
        getGame().getHandler().addCollidableWithBullet(this);
    }


    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }

    @Override
    public void onCollideWithBullet(FriendlyBullet bullet) {
        onCollide();
        System.out.println("collided");

    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        getGame().getPlayer().setHealth(getGame().getPlayer().getHealth() - getPower());
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}


