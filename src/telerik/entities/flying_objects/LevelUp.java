package telerik.entities.flying_objects;


import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;

public class LevelUp extends Entity implements CollidesWithOwnShip {

    public LevelUp(PlayState game, int x, int y) {
        super(game);

        this.setSize(new Size(33, 25));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(567, 0, getSize().getWidth(), getSize().getHeight()));

        this.setBounds();
        addToCollidableWithOwnShip();
    }


    @Override
    public void onCollide() {
        System.out.printf("level up collide");
    }

    @Override
    public void addToCollidableWithOwnShip() {
        getGame().getHandler().addCollidableWithShip(this);

    }
}
