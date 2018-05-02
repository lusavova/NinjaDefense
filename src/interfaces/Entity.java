package interfaces;

import system.Game;
import system.Position;
import system.Size;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {
    private Position position;
    private Size size;
    private Game game;
    private BufferedImage image;


    public Entity(Game game) {
        this.game = game;
    }

    public Entity() {

    }

    public void render(Graphics g) {
        g.drawImage(this.getImage(), getPosition().getX(), getPosition().getY(), game);
    }

    public Game getGame() {
        return game;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {

        this.position = position;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }
}
