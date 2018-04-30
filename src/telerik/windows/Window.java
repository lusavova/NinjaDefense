package telerik.windows;

import telerik.Constants;
import telerik.main.GamePanel;

import javax.swing.*;

public class Window extends JFrame{
    public Window() {
        setTitle(Constants.GAME_TITLE);

        setContentPane(new GamePanel());

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        setLocationRelativeTo(null);
        setResizable(false);
    }
}
