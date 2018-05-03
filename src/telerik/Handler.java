package telerik;

import telerik.game_states.PlayState;
import telerik.interfaces.Updateable;
import telerik.entities.*;
import telerik.entities.flying_objects.*;

import java.awt.*;
import java.util.HashSet;

public class Handler {
    private PlayState game;
    private HashSet<Updateable> updateable;

    public Handler(PlayState game) {
        this.game = game;
        this.updateable = new HashSet<>();
    }

    public void render(Graphics2D g) {
//        bs = game.getBufferStrategy();
//        if(bs == null) {
//            game.createBufferStrategy(3);
//            return;
//        }
//        g = bs.getDrawGraphics();
//        g.clearRect(0, 0, Constants.WIDTH, Constants.HEIGHT);
        game.getPlayer().getShip().render(g);


        g.dispose();
    }

    public void update() {
        game.getPlayer().getShip().update();

    }


    public PlayState getGame() {
        return game;
    }

    public void addUpdateable(Updateable entity) {

        this.updateable.add(entity);
    }
}
