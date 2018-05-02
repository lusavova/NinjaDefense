package entities;

import interfaces.ReachingPlanet;
import interfaces.Ship;
import system.Constants;
import system.Game;
import system.Position;
import system.Size;

public class EnemyShip extends Ship implements ReachingPlanet {

    private int kind;

    public EnemyShip(Game game, int kind) {
        super(game);
        this.kind = kind;
        if (kind == 1) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(99, 55));
            this.setImage(game.getSpriteSheet().getImage(0, 99, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 150));

        } else if (kind == 2) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(67, 60));
            this.setImage(game.getSpriteSheet().getImage(0, 154, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 50));

        }
    }

    @Override
    public void update() {
        getPosition().setX(getPosition().getX() + 1);
    }

    @Override
    public Position nextPosition(Position position) {
        return null;
    }

    @Override
    public void onPlanetReach() {
        //TODO
    }
}
