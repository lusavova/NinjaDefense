package telerik;

public class Constants {
    public static final String GAME_TITLE = "Ninja Defense Game";

    //dimensions
    public static final int WINDOW_WIDTH = 240;
    public static final int WINDOW_HEIGHT = 320;
    public static final double SCALE = 2;

    public static final int WIDTH = (int) (WINDOW_WIDTH * SCALE);
    public static final int HEIGHT = (int) (WINDOW_HEIGHT * SCALE);

    public static final double NUM_OF_TICKS = 60.0;
    public static final double TIME_BEFORE_UPDATE = 1000000000 / NUM_OF_TICKS;
    public static final double MOST_UPD_BEFORE_RENDER = 5;

    public static final double TARGET_FPS = 60;
    public static final double TOTAL_TIME_BEFORE_RENDER = 1000000000 / TARGET_FPS;


    public static final int INITIAL_LIVES = 3;
    public static final int INITIAL_POINTS = 0;
    public static final int INITIAL_BULLETS = 300;
    public static final int INITIAL_HEALTH = 100;


    public static final long FPS = 60;
    public static final double UPDATE_TIME = 1000000000 / FPS;

    public static final long TARGET_TIME = 1000 / FPS;

    public static final int FRIENDLY_BULLET_1_POWER = 20;
    public static final int FRIENDLY_BULLET_2_POWER = 40;
    public static final int FRIENDLY_BULLET_1_SPEED = 10;
    public static final int ENEMY_BULLET_1_POWER = 10;
    public static final int ENEMY_BULLET_2_POWER = 20;
    public static final int COMET_POWER = 20;

    public static final int ALIEN_KILL_POINTS = 500;
    public static final int SHIP_1_KILL_POINTS = 1000;
    public static final int SHIP_2_KILL_POINTS = 2000;
    public static final int BULLET_1_KILL_POINTS = 50;
    public static final int BULLET_2_KILL_POINTS = 100;
    public static final int COMET_KILL_POINTS = 100;


    public static final int CONTROL_PANEL_HEIGHT = 120;
    public static final int BUTTONS_FONT_SIZE = 50;
    public static final int CONTROL_PANEL_FONT_ZISE = 15;

    public static final int ALIEN_SPAWN_DELAY = 180;
    public static final int FOOD_SPAWN_DELAY = 600;
    public static final int FUEL_SPAWN_DELAY = 1200;
    public static final int ONEUP_SPAWN_DELAY = 3600;
    public static final int LEVELUP_SPAWN_DELAY = 60;
    public static final int ENEMY_BULLETS_SHOOT_DELAY = 90;

    public static final int FOOD_LIVE = 1200;
    public static final int FUEL_LIVE = 1200;
    public static final int LEVELUP_lIVE = 600;
    public static final int ONEUP_lIVE = 600;

    // game object sizes
    public static final int ALIEN_WIDTH = 50;
    public static final int ALIEN_HIGHT = 60;

    public static final int COMET_WIDTH = 57;
    public static final int COMET_HIGHT = 56;

    public static final int ENEMY_SHIP_1_WIDTH = 99;
    public static final int ENEMY_SHIP_1_HEIGHT = 55;

    public static final int ENEMY_SHIP_2_WIDTH = 68;
    public static final int ENEMY_SHIP_2_HEIGHT = 60;

    public static final int OWN_SHIP_WIDTH = 60;
    public static final int OWN_SHIP_HEIGHT = 99;

    public static final int OWN_SHIP_UPGRADED_WIDTH = 94;
    public static final int OWN_SHIP_UPGRADED_HEIGHT = 95;

    public static final int ENEMY_BULLET_1_WIDTH = 10;
    public static final int ENEMY_BULLET_1_HEIGHT = 27;

    public static final int ENEMY_BULLET_2_WIDTH = 10;
    public static final int ENEMY_BULLET_2_HEIGHT = 44;

    public static final int FOOD_WIDTH = 25;
    public static final int FOOD_HEIGHT = 25;

    public static final int FUEL_WIDTH = 17;
    public static final int FUEL_HEIGHT = 23;

    public static final int LEVEL_UP_WIDTH = 33;
    public static final int LEVEL_UP_HEIGHT = 25;

    public static final int ONE_UP_WIDTH = 25;
    public static final int ONE_UP_HEIGHT = 24;

    public static final int NUM_OF_ENEMY_SHIPS = 4;
}
