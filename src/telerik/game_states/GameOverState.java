package telerik.game_states;

import telerik.Position;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState {
    private int width;
    private int height;

    private Background background;

    private int currentChoice = 0;

    private Color fontColor;
    private Font buttonsFont;

    private String[] buttons = {
            "PLAY AGAIN",
            "EXIT"
    };

    public GameOverState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            background = new Background("../res/game_over_bg.png", new Position(0, 0));

            fontColor = Color.WHITE;
            buttonsFont = new Font("Monaco", Font.BOLD, 20);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {
        background.render(g);

        g.setColor(fontColor);
        g.setFont(buttonsFont);

        int i = 0;
        for (String button : buttons) {
            g.drawString(button, (width / 2) - button.length() / 2, (height / 2) - i * 15);
            i++;
        }
    }

    private void select() {
        if (currentChoice == 0) {
            gsm.setState(GameStateType.PLAYSTATE.ordinal());
        }
        if (currentChoice == 1) {
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {
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

    @Override
    public void keyReleased(int k) {

    }
}
