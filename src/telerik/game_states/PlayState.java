package telerik.game_states;

import telerik.Handler;
import telerik.Player;
import telerik.Position;
import telerik.SpriteSheet;

import java.awt.*;
import java.awt.event.KeyEvent;

public class PlayState extends GameState {

    private Background background;
    private Handler handler;
    private Player player;
    private SpriteSheet spriteSheet;

    private int points;
    private int lives;
    private int health;
    private int bullets;

    public PlayState(GameStateManager gsm) {
        this.gsm = gsm;
        this.spriteSheet = gsm.getSpriteSheet();
    }

    @Override
    public void init() {
        try {
            background = new Background("../res/game_bg.png", new Position(0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        handler = new Handler(this);
        player = new Player(this);
    }

    @Override
    public void update() {
        handler.update();
    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);
        handler.render(g);
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(int k) {

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
