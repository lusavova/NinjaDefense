package telerik.entities.flying_objects;

import telerik.Constants;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;
import telerik.interfaces.FlyingObject;

import static javax.swing.text.StyleConstants.Size;

public class Comet extends FlyingObject {
    private int kind;
    private int velX=2;
    private int velY=2;

    public Comet(PlayState game, int kind) {
        super(game);
        this.kind = kind;
        this.setPower(Constants.COMET_POWER);
        this.setSize(new Size(57, 56));

        if (kind == 1) {
            this.setImage(game.getSpriteSheet().getImage(277, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 440));

        } else if (kind == 2) {
            this.setImage(game.getSpriteSheet().getImage(391, 0, getSize().getWidth(), getSize().getHeight()));
            this.setPosition(new Position((Constants.WIDTH - getSize().getWidth()) / 2, 500));

        }
        addUpdateable();
    }

    @Override
    public Position nextPosition() {
        getPosition().setY(getPosition().getY() +velY);
        if (this.kind==1) {//type 1
            getPosition().setX(getPosition().getX() + velX);
        }
        if (this.kind==2){//type 2
            getPosition().setX(getPosition().getX() - velX);
        }
        return getPosition();
    }

    @Override
    public void update() {

    }

    @Override
    public void onColide() {

    }

    @Override
    public void addUpdateable() {
        this.getGame().getHandler().addUpdateable(this);
    }
}
