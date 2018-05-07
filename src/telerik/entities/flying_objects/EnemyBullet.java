package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.abstract_classes.FlyingObject;
import telerik.entities.SmallExplosion;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

public class EnemyBullet extends FlyingObject implements Updatable, CollidesWithOwnShip, CollidesWithOwnBullet, HurtingShip {

    private int width;
    private int height;
    private int speed;
    private int power;

    public EnemyBullet(PlayState game, int kind, int x, int y) {
        super(game);

        this.speed = Constants.ENEMY_BULLET_VEL;

        if (kind == 0) {

            this.width = Constants.ENEMY_BULLET_1_WIDTH;
            this.height = Constants.ENEMY_BULLET_1_HEIGHT;
            this.power = Constants.ENEMY_BULLET_1_POWER;

            this.setImage(game.getSpriteSheet().getImage(667, 0, width, height));

        } else if (kind == 1) {

            this.width = Constants.ENEMY_BULLET_2_WIDTH;
            this.height = Constants.ENEMY_BULLET_2_HEIGHT;
            this.power = Constants.ENEMY_BULLET_2_POWER;

            this.setImage(game.getSpriteSheet().getImage(677, 0, width, height));
        }

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x - width / 2, y + height / 2));
        this.setBounds();
    }

    @Override
    public void update() {
        getPosition().setY(getPosition().getY() + speed);

        if (getPosition().getY() >= Constants.HEIGHT) {
            getGame().getHandler().addToRemove(this);
        }

        getBounds().moveBounds(this);
    }

    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
        new SmallExplosion(getGame(), this);
    }

    @Override
    public void onCollideWithBullet(FriendlyBullet bullet) {
        onCollide();
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        int currentHealth = getGame().getPlayer().getShip().getHealth();
        getGame().getPlayer().getShip().setHealth(currentHealth - power);

        System.out.println(this + " hit you. -" + power + " Health.");
    }
    @Override
    public String toString(){
        return "Emeny bullet";
    }
}


