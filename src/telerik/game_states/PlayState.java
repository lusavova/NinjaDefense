package telerik.game_states;

import telerik.Handler;
import telerik.Player;
import telerik.Position;
import telerik.SpriteSheet;
import telerik.entities.EnemyShip;
import telerik.entities.OwnShip;
import telerik.entities.flying_objects.Alien;
import telerik.entities.flying_objects.Comet;
import telerik.entities.flying_objects.EnemyBullet;
import telerik.entities.flying_objects.FriendlyBullet;
import telerik.enumerators.BulletShipSide;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayState extends GameState {

    private Handler handler;
    private Background background;
    private Player player;
    private SpriteSheet spriteSheet;
    private int currentStateIndex;
    private Spawner spawner;

    private int points;
    private int lives;
    private int health;
    private int bullets;

    private boolean isShooting = false;

    public PlayState(GameStateManager gsm) {
        this.gsm = gsm;
        this.spriteSheet = gsm.getSpriteSheet();


        try {
            background = new Background("../res/new_play_bg.png", new Position(0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        handler = new Handler(this);
        player = new Player(this);
        spawner = new Spawner(this);

        new Comet(this, 1, 100, 3);
        new Comet(this, 2, 200, 3);
        new EnemyShip(this, 1, 0, 100, 5);
        new EnemyShip(this, 2, 20, 200, 3);
        new EnemyBullet(this, 1);
        new EnemyBullet(this, 2);

        new FriendlyBullet(this, 1, player.getShip().getPosition(), BulletShipSide.LEFT);
        new FriendlyBullet(this, 2, player.getShip().getPosition(), BulletShipSide.RIGHT);
    }

    @Override
    public void update() {
        handler.update();
        spawner.spawnObject();

    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);
        handler.render(g);
    }

    @Override
    public void keyPressed(int k) {
        OwnShip ship = (OwnShip) player.getShip();

        if (k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (k == KeyEvent.VK_LEFT) {
            ship.setVelX(-5);
        }
        if (k == KeyEvent.VK_RIGHT) {
            ship.setVelX(5);
        }
        if (k == KeyEvent.VK_DOWN) {
            ship.setVelY(5);
        }
        if (k == KeyEvent.VK_UP) {
            ship.setVelY(-5);

        }
        if (k == KeyEvent.VK_SPACE && !isShooting) {
            new FriendlyBullet(this, 1, player.getShip().getPosition(), BulletShipSide.LEFT);
            new FriendlyBullet(this, 1, player.getShip().getPosition(), BulletShipSide.RIGHT);
            isShooting = true;
            System.out.println("shoot");
        }

    }

    @Override
    public void keyReleased(int k) {
        OwnShip ship = (OwnShip) player.getShip();

        if (k == KeyEvent.VK_LEFT) {
            ship.setVelX(0);
        }
        if (k == KeyEvent.VK_RIGHT) {
            ship.setVelX(0);
        }
        if (k == KeyEvent.VK_DOWN) {
            ship.setVelY(0);
        }
        if (k == KeyEvent.VK_UP) {
            ship.setVelY(0);
        }
        if (k == KeyEvent.VK_SPACE) {
            isShooting = false;
        }
        if (k == KeyEvent.VK_Q) {
            currentStateIndex = GameStateType.GAMEOVER.ordinal();
            gsm.setState(currentStateIndex);
        }
    }

    public Handler getHandler() {
        return handler;
    }

    public Player getPlayer() {
        return player;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
}
