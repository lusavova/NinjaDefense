package telerik.entities.flying_objects;


import telerik.Constants;
import telerik.system.Position;
import telerik.system.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.abstract_classes.Entity;


public class LevelUp extends Entity implements CollidesWithOwnShip, Collectable {
    private int live;
    private int width;
    private int height;

    public LevelUp(PlayState game, int x, int y) {
        super(game);

        this.live = Constants.LEVELUP_lIVE;
        this.width = Constants.LEVEL_UP_WIDTH;
        this.height = Constants.LEVEL_UP_HEIGHT;

        this.setSize(new Size(width, height));
        this.setPosition(new Position(x, y));
        this.setImage(game.getSpriteSheet().getImage(567, 0, width, height));

        this.setBounds();
    }


    @Override
    public void onCollide() {
        getGame().getHandler().addToRemove(this);
    }

    @Override
    public void onCollideWithShip() {
        onCollide();
        getGame().getPlayer().getShip().upgradeShip();
        System.out.println(this + "! You are now LEVEL " + getGame().getPlayer().getShip().getLevel() + ".");
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
        return "Level up";
    }
}
