package telerik.game_states;

import telerik.system.Position;
import telerik.enumerators.GameStateType;
import telerik.system.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpState extends GameState {

    private Background background;
    private int currentStateIndex;

    public HelpState(GameStateManager gsm) {
        this.gsm = gsm;

        background = new Background("../res/help_new.png", new Position(0, 0));
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
        if (k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (k == KeyEvent.VK_B) {
            currentStateIndex = GameStateType.MENUSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }

        if (k == KeyEvent.VK_N) {
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }
    }
}
