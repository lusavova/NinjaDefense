package system;

import interfaces.Ship;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Controller controller;

    public KeyInput(Controller controller) {
        this.controller = controller;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        Ship ship = controller.getGame().getPlayer().getShip();
        int x = ship.getPosition().getX();
        int y = ship.getPosition().getY();

        if (key == KeyEvent.VK_LEFT) {
            ship.getPosition().setX(x-5);
        }
        if (key == KeyEvent.VK_RIGHT) {
            ship.getPosition().setX(x+5);
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();


    }
}
