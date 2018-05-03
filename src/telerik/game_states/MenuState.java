package telerik.game_states;

import telerik.Constants;
import telerik.Position;

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

    private String username;

    public MenuState(GameStateManager gsm) {
        this.gsm = gsm;

        fontSize = 50;
        width = (int) (Constants.WINDOW_WIDTH * Constants.SCALE);
        height = (int) (Constants.WINDOW_HEIGHT * Constants.SCALE);

    }

    @Override
    public void init() {
        try {
            background = new Background("../res/open_win.png", new Position(0, 0));

//            InputStream swf = new FileInputStream("Starjedi.ttf");
//            Font starwars = Font.createFont(Font.TRUETYPE_FONT, swf);

            fontColor = Color.WHITE;
            buttonsFont = new Font("Bookman Old Style", Font.BOLD, fontSize);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {

        //debuging -> delete
        try {
            background.render(g);

        } catch (Exception e) {
            System.out.println("back is null");
        }

        g.setColor(fontColor);
        g.setFont(buttonsFont);

        for (int i = 0; i < buttons.length; i++) {

            if (i == currentChoice) {
                g.setColor(new Color(44, 56, 90));
            } else {
                g.setColor(new Color(7, 179, 30));
            }
            g.drawString(buttons[i], (width / 2) - (buttons[i].length() * fontSize / 2) + 35, (height / 2) - 100 + i * fontSize);
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
