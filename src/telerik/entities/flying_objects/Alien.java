package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.abstract_classes.FlyingObject;
import telerik.entities.Explosion;
import telerik.enumerators.GameStateType;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

public class Alien extends FlyingObject implements ReachingPlanet, Updatable, CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {

    private int power;
    private int speed;

    public Alien(PlayState game, int x, int speed) {
        super(game);

        int width = Constants.ALIEN_WIDTH;
        int height = Constants.ALIEN_HEIGHT;

        this.power = Constants.ALIEN_POWER;
        this.speed = speed;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, Constants.CONTROL_PANEL_HEIGHT - Constants.ALIEN_HEIGHT));
        this.setImage(game.getSpriteSheet().getImage(600, 0, width, height));
        this.setBounds();
    }

    @Override
    public void update() {
        getPosition().setY(getPosition().getY() + speed);
        getBounds().moveBounds(this);

        if (getPosition().getY() > Constants.HEIGHT) {
            onPlanetReach();
        }
    }


    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
        new Explosion(getGame(), this);
    }

    @Override
    public void onPlanetReach() {
        int stateIndex = GameStateType.GAMEOVER.ordinal();
        getGame().getGameStateManager().setState(stateIndex);

        System.out.println(this + " reached the planet and abducted The Coding Ninja. GAME OVER.");
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        int currentHealth = getGame().getPlayer().getShip().getHealth();
        getGame().getPlayer().getShip().setHealth(currentHealth - power);

        System.out.println("KAMIKADZE! " + this + " killed. -" + power + " Health.");
    }

    @Override
    public void onCollideWithBullet(FriendlyBullet bullet) {
        onCollide();
        int currentPoints = getGame().getPlayer().getPoints();
        getGame().getPlayer().setPoints(currentPoints + bullet.getPower());

        System.out.println(this + " killed. +" + bullet.getPower() + " Points");
    }

    @Override
    public String toString() {
        return "Alien";
    }


}
