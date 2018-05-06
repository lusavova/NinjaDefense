package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Ammo extends Entity implements CollidesWithOwnShip, Collectable {

    private int live;
    private int width;
    private int height;

    public Ammo(PlayState game, int x, int y) {
        super(game);

        this.live = Constants.AMMO_LIVE;
        this.width = Constants.AMMO_WIDTH;
        this.height = Constants.AMMO_HEIGHT;

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
        getGame().getPlayer().getShip().setBullets(getGame().getPlayer().getShip().getBullets() + Constants.AMMO_AWARD);
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
