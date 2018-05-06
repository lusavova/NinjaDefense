package telerik;

import telerik.Constants;
import telerik.entities.EnemyShip;
import telerik.entities.flying_objects.*;
import telerik.enumerators.CometType;
import telerik.exceptions.NoSuchEntityException;
import telerik.game_states.PlayState;

import java.util.HashSet;
import java.util.Random;

public class Spawner {
    private Random rnd;

    private int rndX;
    private int rndY;
    private int rndSpeed;

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
        this.fuelDelay = Constants.AMMO_SPAWN_DELAY;
        this.levelUpDelay = Constants.LEVELUP_SPAWN_DELAY;
        this.oneUpDelay = Constants.ONE_UP_SPAWN_DELAY;

        this.enemyShips = new HashSet<>();
    }

    public void initSpawn() {
        rndY = rnd.nextInt(Constants.HEIGHT);
        rndSpeed = rnd.nextInt(3) + 2;
        new Comet(game, CometType.LEFT, rndY, rndSpeed);
        rndY = rnd.nextInt(Constants.HEIGHT);
        rndSpeed = rnd.nextInt(3) + 2;
        new Comet(game, CometType.RIGHT, rndY, rndSpeed);

        for (int i = 0; i < Constants.NUM_OF_ENEMY_SHIPS; i++) {
            int startLeft = 1;
            if (i % 2 == 0) {
                startLeft = -1;
            }
            int rndSpeed = rnd.nextInt(2) + 2;
            rndX = rnd.nextInt(Constants.WIDTH - 100);
            //custom exception here
            try {
                new EnemyShip(game, i % 2, rndX, Constants.CONTROL_PANEL_HEIGHT - 70 + Constants.ENEMY_SHIP_1_HEIGHT + 70 * i, rndSpeed * startLeft);
            } catch (NoSuchEntityException e) {
                e.printStackTrace();
            }
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
            rndSpeed = rnd.nextInt(2) + 1;
            alienDelay = Constants.ALIEN_SPAWN_DELAY;
            new Alien(game, rndX, rndSpeed);
        }

        if (foodDelay == 0) {
            rndX = rnd.nextInt(Constants.WIDTH - Constants.FOOD_WIDTH);
            rndY = rnd.nextInt(Constants.HEIGHT - Constants.FOOD_HEIGHT);
            int rndFood = rnd.nextInt(6);
            foodDelay = Constants.FOOD_SPAWN_DELAY;

            new Food(game, rndX, rndY, rndFood);
        }

        if (fuelDelay == 0) {
            rndX = rnd.nextInt(Constants.WIDTH - Constants.AMMO_WIDTH);
            rndY = rnd.nextInt(Constants.HEIGHT - Constants.AMMO_HEIGHT);
            fuelDelay = Constants.AMMO_SPAWN_DELAY;

            new Ammo(game, rndX, rndY);
        }

        if (levelUpDelay == 0) {
            rndX = rnd.nextInt(Constants.WIDTH - Constants.LEVEL_UP_WIDTH);
            rndY = rnd.nextInt(Constants.HEIGHT - Constants.LEVEL_UP_HEIGHT);
            levelUpDelay = Constants.LEVELUP_SPAWN_DELAY;

            new LevelUp(game, rndX, rndY);
        }

        if (oneUpDelay == 0) {
            rndX = rnd.nextInt(Constants.WIDTH - Constants.ONE_UP_WIDTH);
            rndY = rnd.nextInt(Constants.HEIGHT - Constants.ONE_UP_HEIGHT);
            oneUpDelay = Constants.ONE_UP_SPAWN_DELAY;

            new OneUp(game, rndX, rndY);
        }

        enemyShips.forEach(enemyShip -> {
            if (enemyShip.getShootDelay() == 0) {
                int x = enemyShip.getPosition().getX() + enemyShip.getSize().getWidth() / 2;
                int y = enemyShip.getPosition().getY();
                new EnemyBullet(game, enemyShip.getLevel(), x, y);
            }
        });

    }

    public Random getRnd() {
        return rnd;
    }

    public void addEnemyShip(EnemyShip enemyShip) {
        enemyShips.add(enemyShip);
    }
}
