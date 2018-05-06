package telerik.system;

import java.awt.image.BufferedImage;

public class SpriteSheet {
    BufferedImage image;

    SpriteSheet(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage(int x, int y, int w, int h) {
        return image.getSubimage(x, y, w, h);
    }
}
