package telerik.game_states;

import telerik.*;
import telerik.entities.OwnShip;
import telerik.entities.flying_objects.FriendlyBullet;
import telerik.enumerators.BulletShipSide;
import telerik.enumerators.GameStateType;
import telerik.system.Background;
import telerik.system.Position;
import telerik.system.SpriteSheet;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayState extends GameState {

    private Handler handler;
    private Background background;
    private Player player;
    private SpriteSheet spriteSheet;
    private int currentStateIndex;
    private Spawner spawner;
    private BufferedImage playIcon;

    private boolean won;
    private boolean initialSpawnDone;

    private boolean isShooting = false;

    public PlayState(GameStateManager gsm) {
        this.gsm = gsm;
        this.spriteSheet = gsm.getSpriteSheet();

        try {
            background = new Background("../res/play_state.png", new Position(0, 0));
            playIcon = ImageIO.read(getClass().getResourceAsStream("../res/buttons/playIcon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.handler = new Handler(this);
        this.player = new Player(this);
        this.spawner = new Spawner(this);
        this.spawner.initSpawn();

        this.won = false;
        this.initialSpawnDone = false;
    }

    @Override
    public void update() {
        spawner.spawnObject();
        handler.update();

        if (player.getLives() == 0) {
            gsm.setState(GameStateType.GAMEOVER.ordinal());
        }

        if (won) {
            gsm.setState(GameStateType.PAUSE.ordinal());
            gsm.setState(GameStateType.WIN.ordinal());
        }
    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);
        handler.render(g);
        g.drawImage(playIcon, 570, 5, null);
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
            if (player.getShip().getBullets() > 0) {
                new FriendlyBullet(this, player.getShip().getLevel(), player.getShip().getPosition(), BulletShipSide.LEFT);
                new FriendlyBullet(this, player.getShip().getLevel(), player.getShip().getPosition(), BulletShipSide.RIGHT);
                if (player.getShip().getLevel() == 2 && player.getShip().getBullets() > 0) {

                    new FriendlyBullet(this, player.getShip().getLevel(), player.getShip().getPosition(), BulletShipSide.MIDLEFT);
                    new FriendlyBullet(this, player.getShip().getLevel(), player.getShip().getPosition(), BulletShipSide.MIDRIGHT);
                }
            }
            isShooting = true;
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

        if (k == KeyEvent.VK_P) {
            currentStateIndex = GameStateType.PAUSE.ordinal();
            gsm.setState(currentStateIndex);
        }

        // left for demo
        if (k == KeyEvent.VK_W) {
            currentStateIndex = GameStateType.WIN.ordinal();
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

    public Spawner getSpawner() {
        return spawner;
    }

    public GameStateManager getGameStateManager() {
        return gsm;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public void setInitialSpawnDone(boolean initialSpawnDone) {
        this.initialSpawnDone = initialSpawnDone;
    }

    public boolean isInitialSpawnDone() {
        return initialSpawnDone;
    }
}
