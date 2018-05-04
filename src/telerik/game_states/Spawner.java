package telerik.game_states;

import telerik.Constants;
import telerik.entities.flying_objects.Alien;

import java.util.Random;

public class Spawner {
    private Random rnd;
    private int alienDelay;
    private PlayState game;

    public Spawner(PlayState game) {
        this.game = game;
        this.rnd = new Random();
        this.alienDelay = Constants.ALIEN_SPAWN_DELAY;

    }

    public void spawnObject() {
        alienDelay--;

        if (alienDelay == 0) {
            int rndX = rnd.nextInt(Constants.WIDTH-Constants.ALIEN_WIDTH);
            int rndSpeed = rnd.nextInt(2)+1;
            alienDelay = Constants.ALIEN_SPAWN_DELAY;
            new Alien(game, rndX, rndSpeed);

        }
    }

}
