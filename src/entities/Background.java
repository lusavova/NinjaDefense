package entities;

import interfaces.Entity;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class Background extends Entity {
    public Background(Game game) {
        super(game);
        this.setSize(new Size(Constants.WIDTH, Constants.HEIGHT));
        this.setPosition(new Position(0, 0));
        this.setImage(game.getSpriteSheet().getImage(0, 214, getSize().getWidth(), getSize().getHeight()));
    }
}
