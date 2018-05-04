package telerik.game_states;

import java.awt.*;

public abstract class GameState {

    protected GameStateManager gsm;

    public abstract void update();

    public abstract void render(Graphics2D g);

    public abstract void keyPressed(int k);

    public abstract void keyReleased(int k);
}
