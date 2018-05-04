package telerik.entities;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Ship;

public class OwnShip extends Ship {

    private int velX = 0;
    private int velY = 0;

    public OwnShip(PlayState game) {
        super(game);
        this.setHealth(Constants.INITIAL_HEALTH);
        this.setSize(new Size(60, 99));
        this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, Constants.HEIGHT - 150));
        this.setImage(game.getSpriteSheet().getImage(0, 0, getSize().getWidth(), getSize().getHeight()));
        this.setImage(game.getSpriteSheet().getImage(60, 0, getSize().getWidth(), getSize().getHeight()));
        this.setImage(game.getSpriteSheet().getImage(120, 0, getSize().getWidth(), getSize().getHeight()));
        this.setImage(game.getSpriteSheet().getImage(180, 0, getSize().getWidth(), getSize().getHeight()));
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
        if (getPosition().getY() >= Constants.HEIGHT - 100) {
            getPosition().setY(Constants.HEIGHT - 100);
        }
    }

    private void updateFrame() {
        frame++;
        if (frame == getImageList().size()) {
            frame = 0;
        }
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
}
