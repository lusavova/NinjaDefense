package telerik.entities;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.text.StyleConstants.Size;
import static javax.swing.text.StyleConstants.getSpaceAbove;

public class EnemyShip extends Ship implements CollidesWithOwnShip, CollidesWithOwnBullet {
    private int speed;
    private int shootDelay;

    public EnemyShip(PlayState game, int level, int x, int y, int speed) {
        super(game);

        this.setLevel(level);
        this.speed = speed;
        this.shootDelay = Constants.ENEMY_BULLETS_SHOOT_DELAY;

        if (level == 0) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(Constants.ENEMY_SHIP_1_WIDTH, Constants.ENEMY_SHIP_1_HEIGHT));
            this.setImage(game.getSpriteSheet().getImage(0, 99, Constants.ENEMY_SHIP_1_WIDTH, Constants.ENEMY_SHIP_1_HEIGHT));
        } else if (level == 1) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(Constants.ENEMY_SHIP_2_WIDTH, Constants.ENEMY_SHIP_2_HEIGHT));
            this.setImage(game.getSpriteSheet().getImage(0, 154, Constants.ENEMY_SHIP_2_WIDTH, Constants.ENEMY_SHIP_2_HEIGHT));
        }

        this.setPosition(new Position(x, y));

        this.setBounds();
        addToCollidableWithOwnBullet();
        addToCollidableWithOwnShip();
        addToEnemyShips();

    }


    @Override
    public void move() {
        if (shootDelay == 0) {
            shootDelay = Constants.ENEMY_BULLETS_SHOOT_DELAY;
        }
        shootDelay--;
        getPosition().setX(getPosition().getX() + speed);

        if (getPosition().getX() <= 0 || getPosition().getX() >= Constants.WIDTH - getSize().getWidth()) {
            speed *= -1;
        }
        getBounds().moveBounds(this);
    }

    @Override
    public void onCollide() {

    }


    @Override
    public void addToCollidableWithOwnBullet() {
        getGame().getHandler().addCollidableWithBullet(this);
    }

    @Override
    public void onCollideWithBullet() {

    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
    }

    @Override
    public void onCollideWithShip() {
        getGame().getHandler().addToRemove(this);
        getGame().getPlayer().setLives(getGame().getPlayer().getLives() - 1);
        // TO DO : to resep ship position
    }


    private void addToEnemyShips() {
        getGame().getSpawner().addEnemyShip(this);
    }

    public int getShootDelay() {
        return shootDelay;
    }
}
