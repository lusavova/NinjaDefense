package telerik.game_states;

import telerik.enumerators.GameStateType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class PauseState extends GameState {
    private BufferedImage pauseIcon;

    public PauseState(GameStateManager gsm) {
        this.gsm = gsm;

        try {
            pauseIcon = ImageIO.read(getClass().getResourceAsStream("../res/buttons/pauseIcon.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(pauseIcon, 570, 5, null);
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_R) {
            gsm.setState(GameStateType.PLAYSTATE.ordinal());
        }
    }

    @Override
    public void keyReleased(int k) {

    }
}
