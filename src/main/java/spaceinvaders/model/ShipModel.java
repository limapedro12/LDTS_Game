package spaceinvaders.model;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import spaceinvaders.view.ShipViewer;

import java.util.List;

public class ShipModel extends ElementModel {
    private int leftBound;
    private int rightBound;
    private final int upperBound = 39;
    private final int lowerBound = 43;
    public ShipModel() {
        super(new PositionModel(50, 40));
        this.leftBound = 46;
        this.rightBound = 54;
        this.viewer = new ShipViewer(this);
    }
    public ShipModel(int x) {
        super(new PositionModel(x, 40));
        this.leftBound = x-4;
        this.rightBound = x+4;
        this.viewer = new ShipViewer(this);
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return 40;
    }
    public void setX(int x) {
        position.setX(x);
    }
    public void setY(int y) {
        position.setY(y);
    }
    public int getLeftBound() {
        return leftBound;
    }
    public int getRightBound() {
        return rightBound;
    }
    public void setLeftBound(int leftBound) {
        this.leftBound = leftBound;
    }
    public void setRightBound(int rightBound) {
        this.rightBound = rightBound;
    }
    public int getWidth() {
        return rightBound - leftBound + 1;
    }
    public int getHeight() {
        return lowerBound - upperBound + 1;
    }
    public boolean isAlive() {
        return true;
    }
    public void fire() {
        ShipShotModel shot = new ShipShotModel(new PositionModel(getX(), getY() - 2));
        notifyObservers(shot);
    }
}
