package telerik.game_states;

import telerik.Constants;
import telerik.Player;
import telerik.enumerators.GameStateButtons;
import telerik.system.Position;
import telerik.enumerators.GameStateType;
import telerik.system.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class WinState extends GameState {
    private Background background;

    private int currentChoice = 0;

    private Color fontColor;
    private Font buttonsFont;

    private int fontSize;
    private int currentStateIndex;

    private GameStateButtons[] buttons = {
            GameStateButtons.NEW_GAME,
            GameStateButtons.EXIT
    };

    public WinState(GameStateManager gsm) {
        this.gsm = gsm;

        fontSize = 50;

        background = new Background("../res/win_state.png", new Position(0, 0));

        fontColor = Color.WHITE;
        buttonsFont = new Font("Arial", Font.BOLD, fontSize);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);

        g.setColor(fontColor);
        g.setFont(buttonsFont);

        for (int i = 0; i < buttons.length; i++) {

            if (i == currentChoice) {
                g.setColor(new Color(255, 253, 237));
            } else {
                g.setColor(new Color(193, 9, 21));
            }

            switch (buttons[i]) {
                case NEW_GAME:
                    g.drawString("New Game", Constants.WIDTH / 2 - 150, (Constants.HEIGHT / 2) + i * fontSize );
                    break;
                case EXIT:
                    g.drawString("Exit", Constants.WIDTH / 2 - 150, (Constants.HEIGHT / 2) + i * fontSize);
                    break;
            }
        }
    }

    private void select() {
        if (buttons[currentChoice] == GameStateButtons.NEW_GAME) {
            gsm.resetGame();
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
        } else if (buttons[currentChoice] == GameStateButtons.EXIT) {

            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

        if (k == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (k == KeyEvent.VK_N) {
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
            gsm.resetGame();
        }

        if (k == KeyEvent.VK_ENTER) {
            select();
        }

        if (k == KeyEvent.VK_UP) {
            currentChoice--;

            if (currentChoice == -1) {
                currentChoice = buttons.length - 1;
            }
        }

        if (k == KeyEvent.VK_DOWN) {
            currentChoice++;

            if (currentChoice == buttons.length) {
                currentChoice = 0;
            }
        }
    }
}
