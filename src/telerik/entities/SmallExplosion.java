package telerik.entities;


import telerik.Constants;
import telerik.Position;
import telerik.game_states.PlayState;
import telerik.interfaces.Entity;
import telerik.interfaces.Movable;

public class SmallExplosion extends Entity implements Movable {

    private int live;
    private int width;
    private int height;

    public SmallExplosion(PlayState game, Position position) {
        super(game);

        this.live = Constants.EXPLOSION_LIVE;
        this.width = 25;
        this.height = 25;
        this.setPosition(position);
        setSprites();
        addToMovableCollection();
    }

    private void setSprites() {
        for (int i = 0; i < 7; i++) {
            this.setImage(getGame().getSpriteSheet().getImage(width * i, 521, width, height));
        }
    }


    @Override
    public void update() {
        frame++;
        if (frame == getImageList().size()) {
            frame = 0;
        }
        live--;
        if (live == 0 ) {
            getGame().getHandler().addToRemove(this);
        }
    }

    @Override
    public void addToMovableCollection() {
        getGame().getHandler().addMovable(this);
    }
}
