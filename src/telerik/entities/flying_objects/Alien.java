package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

public class Alien extends FlyingObject implements ReachingPlanet, Movable, CollidesWithOwnShip, CollidesWithOwnBullet {
    private int speed;

    public Alien(PlayState game, int x, int speed) {
        super(game);

        this.speed = speed;

        this.setSize(new Size(Constants.ALIEN_WIDTH, Constants.ALIEN_HIGHT));
        this.setPosition(new Position(x, Constants.CONTROL_PANEL_HEIGHT));
        this.setImage(game.getSpriteSheet().getImage(600, 0, Constants.ALIEN_WIDTH, Constants.ALIEN_HIGHT));
        this.setBounds();

        addToMovableCollection();
    }

    @Override
    public void move() {
        getPosition().setY(getPosition().getY() + speed);
        getBounds().moveBounds(this);
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

    @Override
    public void addToCollidableWithOwnShip() {

    }

    @Override
    public void addToCollidableWithOwnBullet() {

    }
}
