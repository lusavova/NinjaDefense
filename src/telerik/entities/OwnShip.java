package telerik.entities;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collidable;
import telerik.interfaces.Ship;

public class OwnShip extends Ship  implements Collidable {

    private int velX = 0;
    private int velY = 0;

    public OwnShip(PlayState game) {
        super(game);
        this.setHealth(Constants.INITIAL_HEALTH);
        this.setSize(new Size(Constants.OWN_SHIP_WIDTH, Constants.OWN_SHIP_HEIGHT));
        this.setPosition(new Position((Constants.WIDTH - Constants.OWN_SHIP_WIDTH) / 2, Constants.HEIGHT - Constants.OWN_SHIP_HEIGHT - 10));

        setSprites();

        this.setBounds();
    }

    private void setSprites() {
        for (int i = 0; i < 4; i++) {
            this.setImage(getGame().getSpriteSheet().getImage(Constants.OWN_SHIP_WIDTH * i, 0, Constants.OWN_SHIP_WIDTH, Constants.OWN_SHIP_HEIGHT));
        }
    }

    private void setSpritesUpgraded() {
        for (int i = 0; i < 6; i++) {
            this.setImage(getGame().getSpriteSheet().getImage(Constants.OWN_SHIP_UPGRADED_WIDTH * i, 0, Constants.OWN_SHIP_UPGRADED_WIDTH, Constants.OWN_SHIP_UPGRADED_HEIGHT));
        }
    }

    public void move() {
        updateFrame();

        getPosition().setX(getPosition().getX() + velX);
        getPosition().setY(getPosition().getY() + velY);

        if (getPosition().getX() <= 0) {
            getPosition().setX(0);
        }
        if (getPosition().getX() >= Constants.WIDTH - 60) {
            getPosition().setX(Constants.WIDTH - 60);
        }
        if (getPosition().getY() <= 105) {
            getPosition().setY(105);
        }
        if (getPosition().getY() >= Constants.HEIGHT - getSize().getHeight()) {
            getPosition().setY(Constants.HEIGHT - getSize().getHeight());
        }
        getBounds().moveBounds(this);
    }

    private void updateFrame() {
        frame++;
        if (frame == getImageList().size()) {
            frame = 0;
        }
    }

    public void upgradeShip() {
        getImageList().clear();
        setSpritesUpgraded();
        setLevel(2);
        getPosition().setX(getPosition().getX() - 17);
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    @Override
    public void onCollide() {
        System.out.println("Own Ship Collide");
    }
}
