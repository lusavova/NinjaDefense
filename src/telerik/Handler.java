package telerik;

import telerik.game_states.PlayState;
import telerik.interfaces.Entity;
import telerik.interfaces.Movable;

import java.awt.*;
import java.util.HashSet;

public class Handler {
    private PlayState game;
    private HashSet<Entity> gameObjects;
    private HashSet<Movable> movables;

    public Handler(PlayState game) {
        this.game = game;
        this.gameObjects = new HashSet<>();
        this.movables = new HashSet<>();
    }

    public void render(Graphics2D g) {
        gameObjects.forEach(obj -> obj.render(g));
    }

    public void update() {
        movables.forEach(obj -> obj.move());

    }

    public void addGameObject(Entity gameObject) {
        this.gameObjects.add(gameObject);
    }

    public void addMovable(Movable gameObject) {
        this.movables.add(gameObject);
    }

    public PlayState getGame() {
        return game;
    }

}
