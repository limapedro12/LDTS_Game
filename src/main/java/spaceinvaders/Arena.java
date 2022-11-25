package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Arena implements ShotObserver{
    private Ship ship;
    private List<Alien> aliens;
    private List<Element> elements;
    private List<Shot> shots;
    public Arena() {
        ship = new Ship();
        ship.addObserver(this);
        elements = new ArrayList<>();
        shots = new ArrayList<>();
        aliens = new ArrayList<>();
        createAliens();
        elements.add(ship);
        elements.add(new Protection(new Position(48, 35),  1));
        elements.add(new Protection(new Position(22, 35), 1));
        elements.add(new Protection(new Position(72, 35), 30));
        // shots.add(new ShipShot(new Position(54, 45)));
        // shots.add(new AlienShot(new Position(25, 5)));
    }

    public void update(Shot shot) {
        shots.add(shot);
    }

    public void createAliens() {
        for (int j = 0; j < 10; j++) {
            Alien a = new Alien(new Position(13 + 8 * j, 9), '&');
            Alien b = new Alien(new Position(13 + 8 * j, 11), 'Y');
            Alien c = new Alien(new Position(13 + 8 * j, 13), 'Y');
            Alien d = new Alien(new Position(13 + 8 * j, 15), 'X');
            Alien e = new Alien(new Position(13 + 8 * j, 17), 'X');
            aliens.add(a); aliens.add(b); aliens.add(c); aliens.add(d); aliens.add(e);
            elements.add(a); elements.add(b); elements.add(c); elements.add(d); elements.add(e);
        }
    }

    public void draw(TextGraphics graphics) {
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
                    element.damage();
                    collided.add(shot);
                }
            }
        }
        shots.removeAll(collided);
    }

    public void processKey(KeyStroke key) {
        ship.processKey(key);
    }

    public List<Shot> getShots() {
        return shots;
    }

    public List<Element> getElements() {
        return elements;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public Ship getShip() {
        return ship;
    }
}
