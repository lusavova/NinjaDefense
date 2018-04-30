package telerik.windows;

import telerik.Constants;
import telerik.main.GamePanel;

import javax.swing.*;

public class Window extends JFrame{
    public Window() {
        setTitle(Constants.GAME_TITLE);

        int width = (int) (Constants.WINDOW_WIDTH * Constants.SCALE);
        int height = (int) (Constants.WINDOW_HEIGHT * Constants.SCALE);

        setContentPane(new GamePanel(width, height));

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLocationRelativeTo(null);
        setResizable(false);
    }
}
