package system;

import entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    private Thread thread;
    private boolean isRunning = false;

    private SpriteSheet spriteSheet = null;

    private Player player;
    private Controller controller;

    public Game() {
        setDimension();
        setFrame();
    }

    public void launch() {
        start();
    }

    private synchronized void start() {
        if (isRunning) {
            return;
        }
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if(!isRunning) {
            return;
        }
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private void setFrame() {
        JFrame frame = new JFrame(Constants.TITLE);
        frame.add(this);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.pack();

    }

    private void setDimension() {
        Dimension dimension = new Dimension(Constants.WIDTH, Constants.HEIGHT);
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setMinimumSize(dimension);
    }

    @Override
    public void run() {
        init();
        long lastTime = System.nanoTime();
        double delta = 0;

        while (isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / Constants.UPDATE_TIME;
            lastTime = now;

            if (delta >= 1) {
                controller.tick();
                delta --;
            }
            controller.render();
        }
        stop();
    }

    private void init() {
        BufferedImageLoader imageLoader = new BufferedImageLoader();
        try {
            BufferedImage loadedImage = imageLoader.loadImage("../resources/sprite.png");
            spriteSheet = new SpriteSheet(loadedImage);
        } catch (IOException e) {
            e.printStackTrace();
        }

        player = new Player("Pesho", this);
        controller = new Controller(this);

    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public Player getPlayer() {
        return player;
    }

    public Controller getController() {
        return controller;
    }
}
