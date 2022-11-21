package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public abstract class Element {
    protected Position position;

    public Element(Position position) {
        this.position = position;
    }

    public abstract void draw(TextGraphics graphics);

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public int getWidth() { return 1; }

    public int getHeight() { return 1; }

    public void damage() {};

    public abstract boolean isAlive();
}
