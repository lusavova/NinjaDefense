package telerik.entities;


import telerik.Constants;
import telerik.Position;
import telerik.game_states.PlayState;
import telerik.interfaces.Entity;
import telerik.interfaces.Updatable;

public class SmallExplosion extends Entity implements Updatable {

    private int live;
    private int width;
    private int height;

    public SmallExplosion(PlayState game, Entity gameObj) {
        super(game);

        this.live = Constants.EXPLOSION_LIVE;
        this.width = 25;
        this.height = 25;

        int x = gameObj.getPosition().getX() + (gameObj.getSize().getWidth() - width) / 2;
        int y = gameObj.getPosition().getY() + (gameObj.getSize().getHeight() - height) / 2;
        this.setPosition(new Position(x, y));

        setSprites();
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
    public String toString(){
        return "Small explosion";
    }

}
