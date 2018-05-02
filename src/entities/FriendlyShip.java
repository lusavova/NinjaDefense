package entities;

import interfaces.Ship;
import javafx.geometry.Pos;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class FriendlyShip extends Ship {

    private int velX = 0;
    private int velY = 0;

    public FriendlyShip(Game game) {
        super(game);
        this.setHealth(Constants.INITIAL_HEALTH);
        this.setSize(new Size(60, 99));
        this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, Constants.HEIGHT - 150));
        this.setImage(game.getSpriteSheet().getImage(0, 0, getSize().getWidth(), getSize().getHeight()));
        this.addUpdateable();
    }

    @Override
    public void update() {
        this.setPosition(nextPosition());
    }

    @Override
    public Position nextPosition() {
        getPosition().setX(getPosition().getX() + velX);
        getPosition().setY(getPosition().getY() + velY);
        if (getPosition().getX() <= 0)
            getPosition().setX(0);
        if (getPosition().getX() >= Constants.WIDTH-60)
            getPosition().setX(Constants.WIDTH-60);
        if (getPosition().getY() <= 105)
            getPosition().setY(105);
        if (getPosition().getY() >= Constants.HEIGHT-100)
            getPosition().setY(Constants.HEIGHT-100);
        System.out.println(getPosition().getX());
        System.out.println(getPosition().getY());
        return getPosition();
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
