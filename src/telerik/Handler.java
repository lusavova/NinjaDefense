package telerik;

import telerik.entities.flying_objects.FriendlyBullet;
import telerik.game_states.PlayState;
import telerik.interfaces.CollidesWithOwnBullet;
import telerik.interfaces.CollidesWithOwnShip;
import telerik.interfaces.Entity;
import telerik.interfaces.Movable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;

public class Handler {
    private PlayState game;

    private BufferedImage image;

    private HashSet<Entity> gameObjects;
    private HashSet<Entity> gameObjectsTemp;

    private HashSet<Movable> movables;
    private HashSet<Movable> movablesTemp;
    private HashSet<Entity> gameObjectsToBeRemoved;

    private HashSet<FriendlyBullet> ownBullets;
    private HashSet<CollidesWithOwnShip> shipCollidables;
    private HashSet<CollidesWithOwnBullet> bulletCollidables;


    public Handler(PlayState game) {
        this.game = game;
        this.gameObjects = new HashSet<>();
        this.movables = new HashSet<>();
        this.gameObjectsTemp = new HashSet<>();
        this.movablesTemp = new HashSet<>();
        this.ownBullets = new HashSet<>();
        this.shipCollidables = new HashSet<>();
        this.bulletCollidables = new HashSet<>();
        this.gameObjectsToBeRemoved = new HashSet<>();

        try {
            image = ImageIO.read(getClass().getResourceAsStream("res/panel_new_600.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void render(Graphics2D g) {
        gameObjects.addAll(gameObjectsTemp);
        gameObjectsTemp.clear();
        gameObjects.removeAll(gameObjectsToBeRemoved);
        gameObjectsToBeRemoved.clear();
        gameObjects.forEach(obj -> obj.render(g));

        //draw control panel
        g.drawImage(image, 0, 0, null);
    }

    public void update() {
        movables.addAll(movablesTemp);
        movablesTemp.clear();
        movables.forEach(obj -> obj.move());
        checkForCollisions();
    }

    private void checkForCollisions() {
        //Exception in thread "GameThread" java.util.ConcurrentModificationException

        bulletCollidables.forEach(collidable -> {
            ownBullets.forEach(bullet -> {
                if (bullet.getBounds().intersects(collidable.getBounds())) {
                    bullet.onCollide();
                    collidable.onCollide();
                }
            });
        });
        shipCollidables.forEach(collidable -> {
            if (game.getPlayer().getShip().getBounds().intersects(collidable.getBounds())) {
                game.getPlayer().getShip().onCollide();
                collidable.onCollide();
            }
        });
    }

    public void addGameObject(Entity gameObject) {
        this.gameObjectsTemp.add(gameObject);
    }

    public void addMovable(Movable gameObject) {
        this.movablesTemp.add(gameObject);
    }

    public void addToRemove(Entity gameObject) {
        this.gameObjectsToBeRemoved.add(gameObject);
    }

    public PlayState getGame() {
        return game;
    }

    public void addOwnBullet(FriendlyBullet friendlyBullet) {
        ownBullets.add(friendlyBullet);
    }

    public void addCollidableWithShip(CollidesWithOwnShip gameObj) {
        shipCollidables.add(gameObj);
    }

    public void addCollidableWithBullet(CollidesWithOwnBullet gameObj) {
        bulletCollidables.add(gameObj);
    }
}
