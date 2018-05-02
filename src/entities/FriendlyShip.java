package entities;

import interfaces.Ship;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class FriendlyShip extends Ship {

    public FriendlyShip(Game game) {
        super(game);
        this.setHealth(Constants.INITIAL_HEALTH);
        this.setSize(new Size(60, 99));
        this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, Constants.HEIGHT - 150));
        this.setImage(game.getSpriteSheet().getImage(0, 0, getSize().getWidth(), getSize().getHeight()));
    }

    @Override
    public void tick() {
        this.setPosition(nextPosition(getPosition()));
    }

    @Override
    public Position nextPosition(Position position) {
        return this.getPosition();
    }
}
