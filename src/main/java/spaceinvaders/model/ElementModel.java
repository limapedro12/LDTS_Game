package spaceinvaders.model;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.ElementViewer;

public abstract class ElementModel {
    protected PositionModel position;
    protected ElementViewer viewer;

    public ElementModel(PositionModel position) {
        this.position = position;
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public PositionModel getPosition() {
        return position;
    }

    public int getWidth() { return 1; }

    public int getHeight() { return 1; }

    public void damage() {};

    public abstract boolean isAlive();
    public ElementViewer getViewer() {
        return viewer;
    }
    public void setViewer(ElementViewer viewer) {
        this.viewer = viewer;
    }
    public boolean isTangible() {
        return true;
    }
    public boolean canIMove(boolean goingLeft) {
        if (goingLeft) {
            return this.getX() > 1;
        } else {
            return this.getX() < 98;
        }
    }
    public void move(int direction) {
        switch (direction) {
            case 0: // left
                this.position.setX(this.position.getX()-1);
                break;
            case 1: // right
                this.position.setX(this.position.getX()+1);
                break;
            case 2: // down
                this.position.setY(this.position.getY()+1);
                break;
        }
    }
}
