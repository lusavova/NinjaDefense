package telerik.entities.flying_objects;


import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class Ammo extends Entity implements CollidesWithOwnShip {
    public Ammo(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(17, 23));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(525, 0, getSize().getWidth(), getSize().getHeight()));

        this.setBounds();
        addToCollidableWithOwnShip();
    }


    @Override
    public void onCollide() {
        //? Bullets
        getGame().getPlayer().getShip().setBullets(getGame().getPlayer().getShip().getBullets() + 100);
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);

    }

    @Override
    public void onCollideWithShip() {

    }
}
