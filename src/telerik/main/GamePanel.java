package telerik.main;

import telerik.Constants;
import telerik.interfaces.Engine;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable, KeyListener, Engine {

    private int width;
    private int height;

    private Thread thread;
    private boolean running;

    private BufferedImage image;
    private Graphics2D g;

    public GamePanel() {
        this.width = (int) (Constants.WINDOW_WIDTH * Constants.SCALE);
        this.height = (int) (Constants.WINDOW_HEIGHT * Constants.SCALE);

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(width, height));
        setMinimumSize(new Dimension(width, height));

        setFocusable(true);
        requestFocus();
    }


    //the game panel is downloading
    @Override
    public void addNotify() {
        super.addNotify();

        if (thread == null) {
            thread = new Thread(this, "GameThread");
            addKeyListener(this);
            thread.start();
        }
    }

    public void init() {
        running = true;

        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        g = (Graphics2D) image.getGraphics();
    }

    @Override
    public void run() {
        init();

        double prevTime = 0;
        //double currentTime =

        while (running) {
            update();
            render();
            draw();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render() {

    }

    public void draw() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0,0, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
