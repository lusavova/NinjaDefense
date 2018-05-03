package telerik.game_states;

import java.awt.*;
import java.util.ArrayList;

import telerik.Game;
import telerik.SpriteSheet;

public class GameStateManager {

    private ArrayList<GameState> gameStates;
    private int currentState;
    private Game gamePanel;
    private SpriteSheet spriteSheet;

    public static final int MENUSTATE = 0;
    public static final int PLAYSTATE = 1;
    public static final int HELPSTATE = 2;
    public static final int GAMEOVER = 3;

    public GameStateManager(Game gamePanel) {
        this.gamePanel = gamePanel;
        spriteSheet = gamePanel.getSpriteSheet();
        gameStates = new ArrayList<GameState>();

        gameStates.add(new MenuState(this));
        gameStates.add(new PlayState(this));
        gameStates.add(new HelpState(this));
        gameStates.add(new GameOverState(this));

        setState(MENUSTATE);
    }

    public void setState(int state) {
        currentState = state;
        System.out.println(gameStates.get(currentState).toString());
        gameStates.get(currentState).init();
    }

    public void update() {
        gameStates.get(currentState).update();
    }

    public void render(Graphics2D g) {
        gameStates.get(currentState).render(g);
    }

    public void keyPressed(int k) {
        gameStates.get(currentState).keyPressed(k);
    }

    public void keyReleased(int k) {
        gameStates.get(currentState).keyReleased(k);
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }
}
