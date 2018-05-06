package telerik.interfaces;

import telerik.Bound;
import telerik.Position;
import telerik.Size;
import telerik.game_states.PlayState;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Entity {
    private Position position;
    private Size size;
    private PlayState game;
    private ArrayList<BufferedImage> image;
    private Bound bounds;
    protected int frame;


    public Entity(PlayState game) {
        this.game = game;
        this.image = new ArrayList<>();
        this.frame = 0;

        addToGameObjectCollection();
    }

    public Entity() {

    }

    private void addToGameObjectCollection() {
        getGame().getHandler().addGameObject(this);
    }

    public void render(Graphics2D g) {
        g.drawImage(this.getImage(frame), getPosition().getX(), getPosition().getY(), null);
    }

    public PlayState getGame() {
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
        this.image.add(image);
    }

    public BufferedImage getImage(int frame) {
        return image.get(frame);
    }

    public ArrayList<BufferedImage> getImageList() {
        return image;
    }

    public Bound getBounds() {
        return bounds;
    }

    public void setBounds() {
        this.bounds = new Bound(this);
    }
}
