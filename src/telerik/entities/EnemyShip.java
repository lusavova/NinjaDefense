package telerik.entities;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnBullet;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.ReachingPlanet;
import telerik.interfaces.Ship;

import java.util.Random;

import static javax.swing.text.StyleConstants.Size;
import static javax.swing.text.StyleConstants.getSpaceAbove;

public class EnemyShip extends Ship implements CollidesWithOwnShip, CollidesWithOwnBullet {
    private int speed;

    public EnemyShip(PlayState game, int kind, int x, int y, int speed) {
        super(game);

        this.speed = speed;


        if (kind == 0) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(Constants.ENEMY_SHIP_1_WIDTH, Constants.ENEMY_SHIP_1_HEIGHT));
            this.setImage(game.getSpriteSheet().getImage(0, 99, Constants.ENEMY_SHIP_1_WIDTH, Constants.ENEMY_SHIP_1_HEIGHT));
        } else if (kind == 1) {
            this.setHealth(Constants.INITIAL_HEALTH);
            this.setSize(new Size(Constants.ENEMY_SHIP_2_WIDTH, Constants.ENEMY_SHIP_2_HEIGHT));
            this.setImage(game.getSpriteSheet().getImage(0, 154, Constants.ENEMY_SHIP_2_WIDTH, Constants.ENEMY_SHIP_2_HEIGHT));
        }

        this.setPosition(new Position(x, y));

        this.setBounds();

    }

    @Override
    public void move() {
        getPosition().setX(getPosition().getX() + speed);

        if (getPosition().getX() <= 0 || getPosition().getX() >= Constants.WIDTH - getSize().getWidth()) {
            speed *= -1;
        }
        getBounds().moveBounds(this);
    }

    @Override
    public void addToCollidableWithOwnShip() {

    }

    @Override
    public void onCollide() {

    }

    @Override
    public void addToCollidableWithOwnBullet() {

    }
}
