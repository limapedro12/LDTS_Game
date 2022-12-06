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
    public boolean collideWith(ElementModel element){
        return isTangible() && (
                (position.getX() >= element.getX() && position.getX() <= element.getX() + element.getWidth() - 1 &&
                position.getY() >= element.getY() && position.getY() <= element.getY() + element.getHeight() - 1) ||
                (element.getX() >= position.getX() && element.getX() <= position.getX() + getWidth() - 1 &&
                element.getY() >= position.getY() && element.getY() <= position.getY() + getHeight() - 1));
    }
}
