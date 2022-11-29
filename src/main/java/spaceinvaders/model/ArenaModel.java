package spaceinvaders.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class ArenaModel implements ShotObserverModel {
    private ShipModel ship;
    private List<AlienModel> aliens;
    private List<ElementModel> elements;
    private List<ShotModel> shots;
    public ArenaModel() {
        ship = new ShipModel();
        ship.addObserver(this);
        elements = new ArrayList<>();
        shots = new ArrayList<>();
        aliens = new ArrayList<>();
        createAliens();
        elements.add(ship);
        elements.add(new ProtectionModel(new PositionModel(48, 35),  1));
        elements.add(new ProtectionModel(new PositionModel(22, 35), 1));
        elements.add(new ProtectionModel(new PositionModel(72, 35), 30));
        // shots.add(new ShipShot(new Position(54, 45)));
        // shots.add(new AlienShot(new Position(25, 5)));
    }

    public void update(ShotModel shot) {
        shots.add(shot);
    }

    public void createAliens() {
        for (int j = 0; j < 10; j++) {
            AlienModel a = new AlienModel(new PositionModel(13 + 8 * j, 9), '&');
            AlienModel b = new AlienModel(new PositionModel(13 + 8 * j, 11), 'Y');
            AlienModel c = new AlienModel(new PositionModel(13 + 8 * j, 13), 'Y');
            AlienModel d = new AlienModel(new PositionModel(13 + 8 * j, 15), 'X');
            AlienModel e = new AlienModel(new PositionModel(13 + 8 * j, 17), 'X');
            aliens.add(a); aliens.add(b); aliens.add(c); aliens.add(d); aliens.add(e);
            elements.add(a); elements.add(b); elements.add(c); elements.add(d); elements.add(e);
        }
    }

    public void run(TextGraphics graphics) {
        List<ElementModel> dead = new ArrayList<>();
        for (ElementModel element : elements) {
            if(!element.isAlive()) dead.add(element);
        }
        elements.removeAll(dead);
        for (ShotModel shot : shots) {
            shot.update();
        }
    }

    public void checkCollisions() {
        List<ShotModel> collided = new ArrayList<>();
        for (ElementModel element : elements) {
            for (ShotModel shot : shots) {
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

    public List<ShotModel> getShots() {
        return shots;
    }

    public List<ElementModel> getElements() {
        return elements;
    }

    public List<AlienModel> getAliens() {
        return aliens;
    }

    public ShipModel getShip() {
        return ship;
    }
}
