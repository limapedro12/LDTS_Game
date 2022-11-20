package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Arena {
    private List<Element> elements;
    private List<Shot> shots;
    public Arena() {
        elements = new java.util.ArrayList<>();
        shots = new java.util.ArrayList<>();
        elements.add(new Protection(new Position(48, 35), 30));
        elements.add(new Protection(new Position(22, 35), 30));
        elements.add(new Protection(new Position(72, 35), 30));
        shots.add(new ShipShot(new Position(54, 45)));
        shots.add(new AlienShot(new Position(25, 5)));
    }

    public void draw(TextGraphics graphics) {
        List<Element> died = new java.util.ArrayList<>();
        for (Element element : elements) {
            element.draw(graphics);
            if(!element.isAlive()) died.add(element);
        }
        elments.removeAll(died);
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
}
