package telerik.game_states;

import telerik.Constants;
import telerik.system.Position;
import telerik.enumerators.GameStateType;
import telerik.system.Background;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {

    private int width;
    private int height;

    private Background background;

    private int currentChoice = 0;

    private Color fontColor;
    private Font buttonsFont;
    private int fontSize;
    private int currentStateIndex;

    private String[] buttons = {
            "START",
            "HELP",
            "EXIT"
    };

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        fontSize = 50;
        width = (int) (Constants.WINDOW_WIDTH * Constants.SCALE);
        height = (int) (Constants.WINDOW_HEIGHT * Constants.SCALE);

        try {
            background = new Background("../res/menu_new.png", new Position(0, 0));

            fontColor = Color.WHITE;
            buttonsFont = new Font("Arial", Font.BOLD, fontSize);

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

        g.setColor(fontColor);
        g.setFont(buttonsFont);

        for (int i = 0; i < buttons.length; i++) {

            if (i == currentChoice) {
                g.setColor(new Color(255, 253, 237));
            } else {
                g.setColor(new Color(7, 179, 30));
            }

            g.drawString(buttons[i], 90, (height / 2) - 50 + i * fontSize);
        }
    }

    private void select() {
        if (currentChoice == 0) {
            currentStateIndex = GameStateType.PLAYSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }

        if (currentChoice == 1) {
            currentStateIndex = GameStateType.HELPSTATE.ordinal();
            gsm.setState(currentStateIndex);
        }

        if (currentChoice == 2) {
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
