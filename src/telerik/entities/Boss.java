package telerik.entities;

import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.entities.flying_objects.FriendlyBullet;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnBullet;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.HurtingShip;
import telerik.abstract_classes.Ship;

public class Boss extends Ship implements CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {

    private int speedX;
    private int speedY;
    private int shootDelay;
    private int width;
    private int height;
    private int isHurting;
    private boolean isAppearing;

    public Boss(PlayState game) {
        super(game);

        this.isHurting = 0;
        this.isAppearing = true;
        this.speedX = Constants.BOSS_SPEED_X;
        this.speedY = Constants.BOSS_SPEED_Y;
        this.shootDelay = Constants.BOSS_SHOOT_DELAY;

        setHealth(Constants.BOSS_HEALTH);
        this.width = Constants.BOSS_WIDTH;
        this.height = Constants.BOSS_HEIGHT;

        this.setImage(game.getSpriteSheet().getImage(0, 560, width, height));

        this.setSize(new Size(width, height));
        this.setPosition(new Position((Constants.WIDTH - width) / 2, Constants.CONTROL_PANEL_HEIGHT - height));

        this.setBounds();
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
            getGame().setWon(true);
        }

        if (shootDelay == 0) {
            shootDelay = Constants.BOSS_SHOOT_DELAY;
        }

        shootDelay--;

        if (isAppearing) {
            getPosition().setY(getPosition().getY() + speedY);
            if (getPosition().getY() > Constants.CONTROL_PANEL_HEIGHT + 50) {
                isAppearing = false;
            }
        } else {
            getPosition().setX(getPosition().getX() + speedX);
            getPosition().setY(getPosition().getY() + speedY);
            if (getPosition().getX() <= 0 || getPosition().getX() >= Constants.WIDTH - width) {
                speedX *= -1;
            }
            if (getPosition().getY() <= Constants.CONTROL_PANEL_HEIGHT || getPosition().getY() >= 250) {
                speedY *= -1;
            }
        }

        getBounds().moveBounds(this);
    }

    private void restoreFrame() {
        this.getImageList().clear();
        this.setImage(getGame().getSpriteSheet().getImage(0, 560, width, height));
    }

    private void updateFrame() {
        isHurting = 4;
        this.getImageList().clear();
        this.setImage(getGame().getSpriteSheet().getImage(width, 560, width, height));
    }

    @Override
    public void onCollide() {

    }

    @Override
    public void onCollideWithShip() {
        updateFrame();
        setHealth(getHealth() - 500);
        getGame().getPlayer().setLives(getGame().getPlayer().getLives() - 1);
        new Explosion(getGame(), getGame().getPlayer().getShip());
        getGame().getPlayer().getShip().resetPosition();
        System.out.println("KAMIKADZE! " + this + " hurt. -1 Live");
    }

    @Override
    public void onCollideWithBullet(FriendlyBullet bullet) {
        updateFrame();
        setHealth(getHealth() - bullet.getPower());
        getGame().getPlayer().setPoints(getGame().getPlayer().getPoints() + bullet.getPower());
    }

    public int getShootDelay() {
        return shootDelay;
    }

    @Override
    public String toString() {
        return "Boss";
    }

}
