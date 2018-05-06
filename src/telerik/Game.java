package telerik;

import telerik.Constants;
import telerik.entities.EnemyShip;
import telerik.exceptions.NoSuchEntityException;
import telerik.game_states.GameStateManager;
import telerik.interfaces.GameEngine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel implements Runnable, GameEngine, KeyListener {

    private int width;
    private int height;

    private boolean running;
    private Thread thread;

    private BufferedImage image;
    private Graphics2D g;
    private SpriteSheet spriteSheet;

    private GameStateManager gsm;
    private Player player;
    private Player username;

    private EnemyShip enemy;

    public Game() {
        running = false;

        this.width = (int) (Constants.WINDOW_WIDTH * Constants.SCALE);
        this.height = (int) (Constants.WINDOW_HEIGHT * Constants.SCALE);

        Dimension dimension = new Dimension(width, height);

        setPreferredSize(dimension);
        setMaximumSize(dimension);
        setMinimumSize(dimension);

        //allow JPanel to have input as soon as the JFrame is made
        setFocusable(true);
        requestFocus();
    }

    private void init() throws IOException {
        running = true;
        BufferedImage bufferedSprite = ImageIO.read(getClass().getResourceAsStream("res/spriteSheet.png"));
        spriteSheet = new SpriteSheet(bufferedSprite);
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();

        //Player player = new Player(username, this);
        gsm = new GameStateManager(this);
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            addKeyListener(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }

        double lastUpdateTime = System.nanoTime();
        double lastRenderTime;

        int frameCount = 0;
        int lastSecondTime = (int) (lastUpdateTime / 1000000000);
        int oldFrameCount = 0;

        while (running) {
            double now = System.nanoTime();
            int updateCount = 0;

            while (((now - lastUpdateTime) > Constants.TIME_BEFORE_UPDATE && (updateCount < Constants.MOST_UPD_BEFORE_RENDER))) {
                update();
                lastUpdateTime += Constants.TIME_BEFORE_UPDATE;
                updateCount++;
            }

            if (now - lastUpdateTime > Constants.TIME_BEFORE_UPDATE) {
                lastUpdateTime = now - Constants.TIME_BEFORE_UPDATE;
            }

            render();
            draw();

            lastRenderTime = now;
            frameCount++;

            int thisSecond = (int) (lastUpdateTime / 1000000000);
            if (thisSecond > lastSecondTime) {
                if (frameCount != oldFrameCount) {
                    oldFrameCount = frameCount;
                }
                frameCount = 0;
                lastSecondTime = thisSecond;
            }

            while (now - lastRenderTime < Constants.TOTAL_TIME_BEFORE_RENDER && now - lastUpdateTime < Constants.TIME_BEFORE_UPDATE) {
                Thread.yield();
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                now = System.nanoTime();
            }
        }
    }

    @Override
    public void update() {
        gsm.update();
    }

    @Override
    public void render() {
        gsm.render(g);
    }

    private void draw() {
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, width, height, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent key) {

    }

    @Override
    public void keyPressed(KeyEvent key) {
        gsm.keyPressed(key.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent key) {
        gsm.keyReleased(key.getKeyCode());
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
}
