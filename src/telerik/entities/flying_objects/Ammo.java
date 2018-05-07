package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.abstract_classes.Entity;

public class Ammo extends Entity implements CollidesWithOwnShip, Collectable {

    private int live;

    public Ammo(PlayState game, int x, int y) {
        super(game);

        int width = Constants.AMMO_WIDTH;
        int height = Constants.AMMO_HEIGHT;
        this.live = Constants.AMMO_LIVE;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(525, 0, width, height));

        this.setBounds();
    }


    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }


    @Override
    public void onCollideWithShip() {
        onCollide();
        int bullets = getGame().getPlayer().getShip().getBullets();
        getGame().getPlayer().getShip().setBullets(bullets + Constants.AMMO_AWARD);

        System.out.println(Constants.AMMO_AWARD + " " + this + " collected.");
    }

    @Override
    public void shouldDie() {
        live--;
        if(live == 0) {
            onCollide();
        }
    }
    @Override
    public String toString(){
        return "Ammo";
    }
}
