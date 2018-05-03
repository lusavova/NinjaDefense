package telerik;

import telerik.Constants;

import javax.swing.*;

public class Window extends JFrame{

    public Window() {
        setTitle(Constants.GAME_TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new Game());
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
