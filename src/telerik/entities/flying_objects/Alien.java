package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;
import telerik.interfaces.Movable;
import telerik.interfaces.ReachingPlanet;

public class Alien extends FlyingObject implements ReachingPlanet, Movable {
    private int speed;

    public Alien(PlayState game, int x, int speed) {
        super(game);

        this.speed = speed;

        this.setSize(new Size(Constants.ALIEN_WIDTH, Constants.ALIEN_HIGHT));
        this.setPosition(new Position(x, Constants.CONTROL_PANEL_HEIGHT));
        this.setImage(game.getSpriteSheet().getImage(600, 0, getSize().getWidth(), getSize().getHeight()));

        addToMovableCollection();
    }

    @Override
    public void move() {
        getPosition().setY(getPosition().getY() + speed);
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
