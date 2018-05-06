package telerik.entities;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.entities.flying_objects.FriendlyBullet;
import telerik.exceptions.NoSuchEntityException;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

import java.awt.*;
import java.util.Random;

import static javax.swing.text.StyleConstants.Size;
import static javax.swing.text.StyleConstants.getSpaceAbove;

public class EnemyShip extends Ship implements CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {

    private int speed;
    private int shootDelay;
    private int width;
    private int height;
    private int isHurting = 0;

    public EnemyShip(PlayState game, int level, int x, int y, int speed) throws NoSuchEntityException {
        super(game);

        if(level > 1) {
            throw new NoSuchEntityException("No such enemy ship.");
        }
        this.setLevel(level);
        this.speed = speed;
        this.shootDelay = game.getSpawner().getRnd().nextInt(Constants.ENEMY_BULLETS_SHOOT_DELAY) ;

        if (level == 0) {

            setHealth(Constants.ENEMY_1_HEALTH);
            this.width = Constants.ENEMY_SHIP_1_WIDTH;
            this.height = Constants.ENEMY_SHIP_1_HEIGHT;

            this.setImage(game.getSpriteSheet().getImage(0, 99, width, height));

        } else if (level == 1) {

            setHealth(Constants.ENEMY_2_HEALTH);
            this.width = Constants.ENEMY_SHIP_2_WIDTH;
            this.height = Constants.ENEMY_SHIP_2_HEIGHT;

            this.setImage(game.getSpriteSheet().getImage(0, 154, width, height));
        }

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));

        this.setBounds();
        addToEnemyShips();

    }


    @Override
    public void update() {
        if (isHurting > 0) {
            isHurting--;
            if (isHurting == 0) {
                restoreFrame();
            }
        }

        if (getHealth() <= 0) {
            new Explosion(getGame(), this);
            getGame().getHandler().addToRemove(this);

            getGame().setNumOfEnemyShips(getGame().getNumOfEnemyShips() - 1);
        }

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

    private void restoreFrame() {
        this.getImageList().clear();
        if (getLevel() == 0) {
            this.setImage(getGame().getSpriteSheet().getImage(0, 99, width, height));
        }
        else {
            this.setImage(getGame().getSpriteSheet().getImage(0, 154, width, height));
        }
    }

    private void updateFrame() {
        isHurting = 4;
        this.getImageList().clear();
        if (getLevel() == 0) {
            this.setImage(getGame().getSpriteSheet().getImage(100, 99, width, height));
        }
        else {
            this.setImage(getGame().getSpriteSheet().getImage(68, 154, width, height));
        }
    }

    @Override
    public void onCollide() {

    }

    @Override
    public void onCollideWithShip() {
        new Explosion(getGame(), this);
        getGame().getHandler().addToRemove(this);
        getGame().getPlayer().setLives(getGame().getPlayer().getLives() - 1);
        new Explosion(getGame(), getGame().getPlayer().getShip());
        getGame().getPlayer().getShip().resetPosition();
        System.out.println("KAMIKADZE! " + this + " killed. -1 Live");

    }

    @Override
    public void onCollideWithBullet(FriendlyBullet bullet) {
        updateFrame();
        setHealth(getHealth() - bullet.getPower());
        getGame().getPlayer().setPoints(getGame().getPlayer().getPoints() + bullet.getPower());
    }

    private void addToEnemyShips() {
        getGame().getSpawner().addEnemyShip(this);
    }

    public int getShootDelay() {
        return shootDelay;
    }

    @Override
    public String toString(){
        return "Enemy ship";
    }

}
