package telerik.entities;


import javafx.geometry.Pos;
import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.Collectable;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;
import telerik.interfaces.Movable;

public class Explosion extends Entity implements Movable {

    private int live;
    private int width;
    private int height;

    public Explosion(PlayState game, Entity gameObj) {
        super(game);
        this.live = Constants.EXPLOSION_LIVE;
        this.width = 100;
        this.height = 100;

        int x = gameObj.getPosition().getX() + (gameObj.getSize().getWidth() - width) / 2;
        int y = gameObj.getPosition().getY() + (gameObj.getSize().getHeight() - height) / 2;
        this.setPosition(new Position(x, y));

        setSprites();
        addToMovableCollection();
    }

    private void setSprites() {
        for (int i = 0; i < 7; i++) {
            this.setImage(getGame().getSpriteSheet().getImage(width * i, 421, width, height));
        }
    }


    @Override
    public void update() {
        frame++;
        if (frame == getImageList().size()) {
            frame = 0;
        }
        live--;
        if (live == 0) {
            getGame().getHandler().addToRemove(this);
        }
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }

    @Override
    public String toString() {
        return "Explosion";
    }
}
