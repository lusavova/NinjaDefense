package system;

import entities.Background;
import entities.EnemyShip;
import entities.flying_objects.*;
import interfaces.Updateable;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.HashSet;

public class Controller {
    private Game game;
    private BufferStrategy bs;
    private Graphics g;
    private Background bg;

    private HashSet<Updateable> updateable;

    public Controller(Game game) {
        this.game = game;
        bg = new Background(game);
        this.updateable = new HashSet<>();
    }

    public void render() {
        bs = game.getBufferStrategy();
        if(bs == null) {
            game.createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
//        g.clearRect(0, 0, Constants.WIDTH, Constants.HEIGHT);

        EnemyShip enemy = new EnemyShip(game, 1);
        EnemyShip enemy2 = new EnemyShip(game, 2);
        FriendlyBullet fb1 = new FriendlyBullet(game, 1);
        FriendlyBullet fb2 = new FriendlyBullet(game, 2);
        EnemyBullet eb1 = new EnemyBullet(game, 1);
        EnemyBullet eb2 = new EnemyBullet(game, 2);
        Comet c1 = new Comet(game, 1);
        Comet c2 = new Comet(game, 2);
        Doughnut doughnut = new Doughnut(game);
        Fuel fuel = new Fuel(game);
        LevelUp lu = new LevelUp(game);
        OneUp ou = new OneUp(game);
        Alien a = new Alien(game);

        bg.render(g);
        game.getPlayer().getShip().render(g);
        enemy.render(g);
        enemy2.render(g);
        fb1.render(g);
        fb2.render(g);
        eb1.render(g);
        eb2.render(g);
        c1.render(g);
        c2.render(g);
        doughnut.render(g);
        fuel.render(g);
        lu.render(g);
        ou.render(g);
        a.render(g);

        g.dispose();
        bs.show();
    }

    public void tick() {
        game.getPlayer().getShip().tick();
    }


    public Game getGame() {
        return game;
    }

    public void addUpdateable(Updateable entity) {

        this.updateable.add(entity);
    }
}
