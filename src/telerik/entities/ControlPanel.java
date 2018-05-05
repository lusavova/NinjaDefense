package telerik.entities;

import telerik.Player;
import telerik.interfaces.Entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ControlPanel extends Entity {

    private int points;
    private int lives;
    private int health;
    private int bullets;
    private BufferedImage image;

    public ControlPanel(Player player) throws IOException {
        this.points = player.getPoints();
        this.lives = player.getLives();
        this.health = player.getHealth();
        this.bullets = player.getBullets();

        BufferedImage image = ImageIO.read(getClass().getResourceAsStream("../res/panel_new_600.png"));
    }

    @Override
    public void render(Graphics2D g) {
        super.render(g);
        g.drawImage(image, 0, 0, null);
    }
}
