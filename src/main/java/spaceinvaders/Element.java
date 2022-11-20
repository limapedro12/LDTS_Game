package spaceinvaders;

import com.googlecode.lanterna.graphics.TextGraphics;

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
}
