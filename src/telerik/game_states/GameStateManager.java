package telerik.game_states;

import java.awt.*;
import java.util.ArrayList;

import telerik.system.Game;
import telerik.Player;
import telerik.system.SpriteSheet;
import telerik.enumerators.GameStateType;

public class GameStateManager {

    private ArrayList<GameState> gameStates;
    private int currentState;
    private Game gamePanel;
    private SpriteSheet spriteSheet;
    private Player player;

    public GameStateManager(Game gamePanel) {
        this.gamePanel = gamePanel;
        spriteSheet = gamePanel.getSpriteSheet();
        gameStates = new ArrayList<GameState>();

        gameStates.add(new MenuState(this));
        gameStates.add(new PlayState(this));
        gameStates.add(new HelpState(this));
        gameStates.add(new GameOverState(this));
        gameStates.add(new PauseState(this));
        gameStates.add(new WinState(this));

        int menuStateIndex = GameStateType.MENUSTATE.ordinal();
        setState(menuStateIndex);
    }

    public void setState(int state) {
        currentState = state;
        gameStates.get(currentState);
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

    public void resetGame() {
        this.gameStates.set(GameStateType.PLAYSTATE.ordinal(), new PlayState(this));
    }
}
