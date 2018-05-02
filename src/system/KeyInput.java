package system;

import entities.FriendlyShip;
import entities.flying_objects.FriendlyBullet;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Controller controller;
    private boolean isShooting = false;

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
        }
        if (key == KeyEvent.VK_RIGHT) {
            ship.setVelX(5);
        }
        if (key == KeyEvent.VK_DOWN) {
            ship.setVelY(5);
        }
        if (key == KeyEvent.VK_UP) {
            ship.setVelY(-5);

        }
        if (key == KeyEvent.VK_SPACE && !isShooting) {
            new FriendlyBullet(controller.getGame(), 1);
            isShooting = true;
            System.out.println("shoot");
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
        if (key == KeyEvent.VK_DOWN) {
            ship.setVelY(0);
        }
        if (key == KeyEvent.VK_UP) {
            ship.setVelY(0);
        }
        if (key == KeyEvent.VK_SPACE) {
            isShooting = false;
        }
    }

}

