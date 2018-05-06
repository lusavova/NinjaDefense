package telerik.system;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Background {

    private BufferedImage image;
    private Position position;

    public Background(String s, Position position) {
        this.position = position;
        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(s));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g){
        g.drawImage(image, position.getX(), position.getY(), null);
    }
}
