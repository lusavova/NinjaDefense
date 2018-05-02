package entities.flying_objects;

import interfaces.FlyingObject;
import interfaces.ReachingPlanet;
import system.Game;
import system.Position;
import system.Size;

public class Alien extends FlyingObject implements ReachingPlanet {

    public Alien(Game game) {
        super(game);
        this.setSize(new Size(50, 60));
        this.setPosition(new Position(20, 150));
        this.setImage(game.getSpriteSheet().getImage(600, 0, getSize().getWidth(), getSize().getHeight()));
        addUpdateable();
    }

    @Override
    public Position nextPosition(Position position) {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getController().addUpdateable(this);
    }

    @Override
    public void onColide() {

    }

    @Override
    public void onPlanetReach() {

    }
}
