package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Arena {
    private List<Element> elements;
    public Arena() {
        elements = new java.util.ArrayList<>();
        elements.add(new Protection(new Position(50, 36), 30));
    }

    public void draw(TextGraphics graphics) {
        for (Element element : elements) {
            element.draw(graphics);
        }
    }
}
