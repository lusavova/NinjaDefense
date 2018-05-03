package telerik.entities.flying_objects;

import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;
import telerik.interfaces.ReachingPlanet;

public class Alien extends FlyingObject implements ReachingPlanet, Movable {

    private int velY = 2;

    public Alien(PlayState game) {
        super(game);
        this.setSize(new Size(50, 60));
        this.setPosition(new Position(20, 150));
        this.setImage(game.getSpriteSheet().getImage(600, 0, getSize().getWidth(), getSize().getHeight()));
        addToMovableCollection();
    }

    @Override
    public void move() {
        getPosition().setY(getPosition().getY() + velY);
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }


    @Override
    public void onCollide() {

    }

    @Override
    public void onPlanetReach() {

    }
}
