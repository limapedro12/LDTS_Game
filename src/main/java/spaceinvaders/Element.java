package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public abstract class Element {
    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public abstract void draw(Screen screen);

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }
}
