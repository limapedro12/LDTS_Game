package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Arena {
    private List<Element> elements;
    private List<Shot> shots;
    public Arena() {
        elements = new java.util.ArrayList<>();
        shots = new java.util.ArrayList<>();
        elements.add(new Protection(new Position(50, 35), 30));
        elements.add(new Protection(new Position(25, 35), 30));
        elements.add(new Protection(new Position(75, 35), 30));
        shots.add(new ShipShot(new Position(54, 45)));
    }

    public void draw(TextGraphics graphics) {
        for (Element element : elements) {
            element.draw(graphics);
        }
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
}
