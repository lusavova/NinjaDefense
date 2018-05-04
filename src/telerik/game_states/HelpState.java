package telerik.game_states;

import telerik.Position;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpState extends GameState {

    private Background background;
    private int currentStateIndex;

    public HelpState(GameStateManager gsm) {
        this.background = background;

        this.gsm = gsm;
        try {
            background = new Background("../res/help_bg.png", new Position(0, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (k == KeyEvent.VK_SPACE) {
            currentStateIndex = GameStateType.MENUSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }

        if (k == KeyEvent.VK_ENTER) {
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
