package telerik.entities.flying_objects;

import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.ReachingPlanet;

public class Alien extends FlyingObject implements ReachingPlanet {

    public Alien(PlayState game) {
        super(game);
        this.setSize(new Size(50, 60));
        this.setPosition(new Position(20, 150));
        this.setImage(game.getSpriteSheet().getImage(600, 0, getSize().getWidth(), getSize().getHeight()));
        addUpdateable();
    }

    @Override
    public Position nextPosition() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getHandler().addUpdateable(this);
    }

    @Override
    public void onColide() {

    }

    @Override
    public void onPlanetReach() {

    }
}
