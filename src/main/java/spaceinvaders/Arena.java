package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    private Ship ship;
    private List<Alien> aliens;
    private List<Element> elements;
    private List<Shot> shots;
    public Arena() {
        ship = new Ship();
        createAliens();

        elements = new java.util.ArrayList<>();
        shots = new java.util.ArrayList<>();
        elements.add(new Protection(new Position(48, 35),  1));
        elements.add(new Protection(new Position(22, 35), 1));
        elements.add(new Protection(new Position(72, 35), 30));
        shots.add(new ShipShot(new Position(54, 45)));
        shots.add(new AlienShot(new Position(25, 5)));
    }

    private void createAliens() {
        aliens = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                Alien a = new Alien(new Position(13 + 8 * j, 5 + 4 * i));
                aliens.add(a);
            }
        }
    }

    public void draw(TextGraphics graphics, Screen screen) {
        ship.draw(screen);
        for (Alien a :aliens){
            a.draw(screen);
        }
        List<Element> dead = new java.util.ArrayList<>();
        for (Element element : elements) {
            element.draw(graphics);
            if(!element.isAlive()) dead.add(element);
        }
        elements.removeAll(dead);
        for (Shot shot : shots) {
            shot.draw(graphics);
            shot.update();
        }
    }

    public void checkCollisions() {
        List<Shot> collided = new java.util.ArrayList<>();
        for (Element element : elements) {
            for (Shot shot : shots) {
                if (shot.collideWith(element)) {
                    System.out.println("Lost Life!");
                    element.damage();
                    collided.add(shot);
                }
            }
        }
        shots.removeAll(collided);
    }

    public void processKey(KeyStroke key, Screen screen) {
        ship.processKey(key, screen);
    }
}
