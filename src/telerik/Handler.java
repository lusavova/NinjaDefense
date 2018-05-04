package telerik;

import telerik.game_states.PlayState;
import telerik.interfaces.Entity;
import telerik.interfaces.Movable;

import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;

public class Handler {
    private PlayState game;
    private HashSet<Entity> gameObjects;
    private HashSet<Movable> movables;
    private HashSet<Entity> gameObjectsTemp;
    private HashSet<Movable> movablesTemp;

    public Handler(PlayState game) {
        this.game = game;
        this.gameObjects = new HashSet<>();
        this.movables = new HashSet<>();
        this.gameObjectsTemp = new HashSet<>();
        this.movablesTemp = new HashSet<>();
    }

    public void render(Graphics2D g) {
        gameObjects.addAll(gameObjectsTemp);
        gameObjectsTemp.clear();
        gameObjects.forEach(obj -> obj.render(g));
    }

    public void update() {
        movables.addAll(movablesTemp);
        movablesTemp.clear();
        movables.forEach(obj -> obj.move());
    }

    public void addGameObject(Entity gameObject) {
        this.gameObjectsTemp.add(gameObject);
    }

    public void addMovable(Movable gameObject) {
        this.movablesTemp.add(gameObject);
    }

    public void removeMovable(Movable gameObject) {
        this.movablesTemp.remove(gameObject);
    }

    public PlayState getGame() {
        return game;
    }

}
