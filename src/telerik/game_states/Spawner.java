package telerik.game_states;

import telerik.Constants;
import telerik.entities.EnemyShip;
import telerik.entities.flying_objects.*;
import telerik.enumerators.CometType;

import java.util.HashSet;
import java.util.Random;

public class Spawner {
    private Random rnd;

    private int rndX;
    private int rndY;

    private int alienDelay;
    private int foodDelay;
    private int fuelDelay;
    private int levelUpDelay;
    private int oneUpDelay;

    private PlayState game;

    private HashSet<EnemyShip> enemyShips;

    public Spawner(PlayState game) {
        this.game = game;
        this.rnd = new Random();

        this.alienDelay = Constants.ALIEN_SPAWN_DELAY;
        this.foodDelay = Constants.FOOD_SPAWN_DELAY;
        this.fuelDelay = Constants.FUEL_SPAWN_DELAY;
        this.levelUpDelay = Constants.LEVELUP_SPAWN_DELAY;
        this.oneUpDelay = Constants.ONEUP_SPAWN_DELAY;

        this.enemyShips = new HashSet<>();
    }

    public void initSpawn() {
        new Comet(game, CometType.LEFT, 100, 3);
        new Comet(game, CometType.RIGHT, 200, 3);

        for (int i = 0; i < Constants.NUM_OF_ENEMY_SHIPS; i++) {
            int rndSpeed = rnd.nextInt(2) + 2;
            new EnemyShip(game, i % 2, Constants.WIDTH / 2, Constants.CONTROL_PANEL_HEIGHT - 70 + Constants.ENEMY_SHIP_1_HEIGHT + 70 * i, rndSpeed);
        }
    }

    public void spawnObject() {
        alienDelay--;
        foodDelay--;
        fuelDelay--;
        oneUpDelay--;
        levelUpDelay--;

        if (alienDelay == 0) {
            rndX = rnd.nextInt(Constants.WIDTH - Constants.ALIEN_WIDTH);
            int rndSpeed = rnd.nextInt(2) + 1;
            alienDelay = Constants.ALIEN_SPAWN_DELAY;
            new Alien(game, rndX, rndSpeed);
        }
//
//        if (foodDelay == 0) {
//            rndX = rnd.nextInt(Constants.WIDTH - Constants.FOOD_WIDTH);
//            rndY = rnd.nextInt(Constants.HEIGHT - Constants.FOOD_HEIGHT);
//            int rndFood = rnd.nextInt(6);
//            foodDelay = Constants.FOOD_SPAWN_DELAY;
//
//            new Food(game, rndX, rndY, rndFood);
//        }
//
//        if (fuelDelay == 0) {
//            rndX = rnd.nextInt(Constants.WIDTH - Constants.FUEL_WIDTH);
//            rndY = rnd.nextInt(Constants.HEIGHT - Constants.FUEL_HEIGHT);
//            fuelDelay = Constants.FUEL_SPAWN_DELAY;
//
//            new Fuel(game, rndX, rndY);
//        }
//
//        if (levelUpDelay == 0) {
//            rndX = rnd.nextInt(Constants.WIDTH - Constants.LEVEL_UP_WIDTH);
//            rndY = rnd.nextInt(Constants.HEIGHT - Constants.LEVEL_UP_HEIGHT);
//            levelUpDelay = Constants.LEVELUP_SPAWN_DELAY;
//
//            new LevelUp(game, rndX, rndY);
//        }
//
//        if (oneUpDelay == 0) {
//            rndX = rnd.nextInt(Constants.WIDTH - Constants.ONE_UP_WIDTH);
//            rndY = rnd.nextInt(Constants.HEIGHT - Constants.ONE_UP_HEIGHT);
//            oneUpDelay = Constants.ONEUP_SPAWN_DELAY;
//
//            new OneUp(game, rndX, rndY);
//        }
//
//        enemyShips.forEach(enemyShip -> {
//            if(enemyShip.getShootDelay() == 0) {
//                new EnemyBullet(game, enemyShip.getLevel(), enemyShip.getPosition());
//            }
//        });

    }

    public Random getRnd() {
        return rnd;
    }

    public void addEnemyShip(EnemyShip enemyShip) {
        enemyShips.add(enemyShip);
    }
}
