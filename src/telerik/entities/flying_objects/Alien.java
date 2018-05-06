package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.entities.Explosion;
import telerik.game_states.GameStateType;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

public class Alien extends FlyingObject implements ReachingPlanet, Movable, CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {

    private int power;
    private int speed;
    private int width;
    private int height;

    public Alien(PlayState game, int x, int speed) {
        super(game);

        this.width = Constants.ALIEN_WIDTH;
        this.height = Constants.ALIEN_HEIGHT;
        this.power = Constants.ALIEN_POWER;
        this.speed = speed;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, Constants.CONTROL_PANEL_HEIGHT));
        this.setImage(game.getSpriteSheet().getImage(600, 0, width, height));
        this.setBounds();

        addToMovableCollection();
        addToCollidableWithOwnBullet();
        addToCollidableWithOwnShip();
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
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
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
    }

    @Override
    public void addToCollidableWithOwnBullet() {
        getGame().getHandler().addCollidableWithBullet(this);
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);
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
        getGame().getPlayer().setPoints(getGame().getPlayer().getPoints() + bullet.getPower());
        System.out.println(this + " killed. +" + bullet.getPower() + " Points");
    }

    @Override
    public String toString(){
        return "Alien";
    }



}
