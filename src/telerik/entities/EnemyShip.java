package telerik.entities;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.entities.flying_objects.EnemyBullet;
import telerik.game_states.PlayState;
import telerik.interfaces.ReachingPlanet;
import telerik.interfaces.Ship;

import java.util.Random;

import static javax.swing.text.StyleConstants.Size;

public class EnemyShip extends Ship implements ReachingPlanet {

    private int kind;
    private int velX = 2;

    private Random r;

    public EnemyShip(PlayState game, int kind) {
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
    public void move() {
        getPosition().setX(getPosition().getX() + velX);

        if (getPosition().getX() <= 0) {
            velX *= -1;
        }
        if (getPosition().getX() >= Constants.WIDTH - 60) {
            velX *= -1;
        }
        if (getPosition().getX()%5==0){

        }
    }

    @Override
    public void onPlanetReach() {
        //TODO
    }

}
