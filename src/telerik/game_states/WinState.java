package telerik.game_states;

import telerik.system.Position;
import telerik.enumerators.GameStateType;
import telerik.system.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WinState extends GameState {
    private Background background;

    private int currentStateIndex;

    public WinState(GameStateManager gsm) {
        this.gsm = gsm;

        background = new Background("../res/win_state.png", new Position(0, 0));
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {
        if (k == KeyEvent.VK_Q) {
            System.exit(0);
        }

        if (k == KeyEvent.VK_ENTER) {
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
            gsm.resetGame();
        }
    }
}
