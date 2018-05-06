package telerik;

import telerik.entities.flying_objects.FriendlyBullet;
import telerik.game_states.PlayState;
import telerik.interfaces.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashSet;

public class Handler {
    private PlayState game;

    private BufferedImage image;

    private HashSet<Entity> gameObjects;
    private HashSet<Entity> gameObjectsTemp;
    private HashSet<Entity> gameObjectsToBeRemoved;

    private Font buttonsFont;

    public Handler(PlayState game) {
        this.game = game;
        this.gameObjects = new HashSet<>();
        this.gameObjectsTemp = new HashSet<>();
        this.gameObjectsToBeRemoved = new HashSet<>();

        try {
            image = ImageIO.read(getClass().getResourceAsStream("res/panel_new_600.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonsFont = new Font("Arial", Font.BOLD, 15);
    }

    public void render(Graphics2D g) {
        gameObjects.addAll(gameObjectsTemp);
        gameObjectsTemp.clear();
        gameObjects.removeAll(gameObjectsToBeRemoved);
        gameObjectsToBeRemoved.clear();

        gameObjects.forEach(obj -> obj.render(g));
        drawControlPanel(g);
    }

    public void update() {
        gameObjects
                .stream()
                .filter(obj -> obj instanceof Movable)
                .map(obj -> (Movable) obj)
                .forEach(gameObj -> gameObj.update());

        gameObjects.forEach(obj -> {
            if (obj instanceof Collectable) {
                ((Collectable) obj).shouldDie();
            }
        });

        checkForCollisions();
    }

    private void drawControlPanel(Graphics2D g) {
        g.drawImage(image, 0, 0, null);

        g.setColor(new Color(179, 24, 71));
        g.setFont(buttonsFont);

        String points = String.valueOf(getGame().getPlayer().getPoints());
        String health = String.valueOf(getGame().getPlayer().getShip().getHealth());
        String lives = String.valueOf(getGame().getPlayer().getLives());
        String bullets = String.valueOf(getGame().getPlayer().getShip().getBullets());

        g.drawString(points, 40, 15);
        g.drawString(health, 40, 40);
        g.drawString(lives, 40, 70);
        g.drawString(bullets, 40, 95);
    }

    private void checkForCollisions() {

        gameObjects
                .stream()
                .filter(obj -> obj instanceof CollidesWithOwnBullet)
                .map(obj -> (CollidesWithOwnBullet) obj)
                .forEach(
                        collidable -> {
                            gameObjects
                                    .stream()
                                    .filter(obj -> obj instanceof FriendlyBullet)
                                    .map(obj -> (FriendlyBullet) obj)
                                    .forEach(bullet -> {
                                        if (bullet.getBounds().intersects(collidable.getBounds())) {
                                            bullet.onCollide();
                                            collidable.onCollideWithBullet(bullet);
                                        }
                                    });
                        }
                );

        gameObjects
                .stream()
                .filter(obj -> obj instanceof CollidesWithOwnShip)
                .map(obj -> (CollidesWithOwnShip) obj)
                .forEach(
                        collidable -> {
                            if (game.getPlayer().getShip().getBounds().intersects(collidable.getBounds())) {
                                game.getPlayer().getShip().onCollide(collidable);
                                collidable.onCollideWithShip();
                            }
                        }
                );

    }

    public void addGameObject(Entity gameObject) {
        this.gameObjectsTemp.add(gameObject);
    }

    public void addToRemove(Entity gameObject) {
        this.gameObjectsToBeRemoved.add(gameObject);
    }

    public PlayState getGame() {
        return game;
    }
}
