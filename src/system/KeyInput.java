package system;

import entities.FriendlyShip;
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

        FriendlyShip ship = controller.getGame().getPlayer().getShip();
        int x = ship.getPosition().getX();
        int y = ship.getPosition().getY();

        if (key == KeyEvent.VK_LEFT) {
            ship.setVelX(-5);
            ship.getPosition().setX(x + ship.getVelX());
        }
        if (key == KeyEvent.VK_RIGHT) {
            ship.setVelX(5);
            ship.getPosition().setX(x + ship.getVelX());

        }

    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();
        FriendlyShip ship = controller.getGame().getPlayer().getShip();
        int x = ship.getPosition().getX();
        int y = ship.getPosition().getY();


        if (key == KeyEvent.VK_LEFT) {
            ship.setVelX(0);
        }
        if (key == KeyEvent.VK_RIGHT) {
            ship.setVelX(0);

        }

    }
}
