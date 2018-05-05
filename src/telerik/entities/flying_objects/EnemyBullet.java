package telerik.entities.flying_objects;


import javafx.geometry.Pos;
import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnBullet;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;

import java.awt.*;

public class EnemyBullet extends FlyingObject implements Movable, CollidesWithOwnShip, CollidesWithOwnBullet {


    private int bulletOneHeight;
    private int bulletOneWidht;
    private int bulletTwoHeight;
    private int bulletTwoWidth;

    private int speed = Constants.ENEMY_BULLET_VEL;

    private int power;

    public EnemyBullet(PlayState game, int kind, int x, int y) {
        super(game);

        if (kind == 0) {

            this.power = Constants.ENEMY_BULLET_1_POWER;
            this.bulletOneHeight = Constants.ENEMY_BULLET_1_HEIGHT;
            this.bulletOneWidht = Constants.ENEMY_BULLET_1_WIDTH;

            this.setSize(new Size(bulletOneWidht, bulletTwoHeight));
            this.setImage(game.getSpriteSheet().getImage(257, 0, bulletOneWidht, bulletOneHeight));

        } else if (kind == 1) {

            this.power = Constants.ENEMY_BULLET_2_POWER;
            this.bulletTwoHeight = Constants.ENEMY_BULLET_2_HEIGHT;
            this.bulletTwoWidth = Constants.ENEMY_BULLET_2_WIDTH;

            this.setSize(new Size(bulletTwoWidth, bulletTwoHeight));
            this.setImage(game.getSpriteSheet().getImage(267, 0, bulletTwoWidth, bulletTwoHeight));
        }

        this.setPosition(new Position(x - getSize().getWidth() / 2, y + getSize().getHeight() / 2));
        this.setBounds();

        addToMovableCollection();
        addToCollidableWithOwnBullet();
        addToCollidableWithOwnShip();
    }

    @Override
    public void update() {
        getPosition().setY(getPosition().getY() + speed);
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


}


