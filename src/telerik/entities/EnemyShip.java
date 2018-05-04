package telerik.entities;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.ReachingPlanet;
import telerik.interfaces.Ship;

import java.util.Random;

import static javax.swing.text.StyleConstants.Size;
import static javax.swing.text.StyleConstants.getSpaceAbove;

public class EnemyShip extends Ship implements ReachingPlanet {
    private int speed;

    private int x;
    private Random r;

    public EnemyShip(PlayState game, int kind, int x, int y, int speed) {
        super(game);

        this.speed = speed;


        if (kind == 0) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(99, 55));
            this.setImage(game.getSpriteSheet().getImage(0, 99, getSize().getWidth(), getSize().getHeight()));
        } else if (kind == 1) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(67, 60));
            this.setImage(game.getSpriteSheet().getImage(0, 154, getSize().getWidth(), getSize().getHeight()));
        }

        this.setPosition(new Position(x, y));
    }

    @Override
    public void move() {
        getPosition().setX(getPosition().getX() + speed);

        if (getPosition().getX() <= 0 || getPosition().getX() >= Constants.WIDTH - getSize().getWidth()) {
            speed *= -1;
        }
    }

    @Override
    public void onPlanetReach() {
        //TODO
    }
}
