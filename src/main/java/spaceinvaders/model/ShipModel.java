package spaceinvaders.model;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import spaceinvaders.view.ShipViewer;

import java.util.ArrayList;
import java.util.List;

public class ShipModel extends ElementModel {
    private List<PositionModel> drawnPositions;
    private int leftBound;
    private int rightBound;
    private int upperBound;
    private int lowerBound;
    private final int wingLength = 4;
    private final int length = 4;
    private int lives = 3;
    public ShipModel() {
        super(new PositionModel(50, 39));
        this.upperBound = position.getY();
        this.lowerBound = position.getY() + length;
        this.leftBound = position.getX() - wingLength;
        this.rightBound = position.getX() + wingLength;
        this.viewer = new ShipViewer(this);
        this.drawnPositions = new ArrayList<>();
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
    public int getUpperBound() {
        return upperBound;
    }
    public int getLowerBound() {
        return lowerBound;
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
        return lives > 0;
    }
    public void fire() {
        ShipShotModel shot = new ShipShotModel(new PositionModel(getX(), getY() - 2));
        notifyObservers(shot);
    }
    public int getLives(){
        return lives;
    }

    public void damage(){
        lives--;
    }
    @Override
    public boolean collideWith(ShotModel shot) {
        for(PositionModel drawnPosition : drawnPositions) {
            if(drawnPosition.getX() == shot.getX() && drawnPosition.getY() == shot.getY()) {
                return true;
            }
        }
        return false;
//        if (shot.getX() >= leftBound && shot.getX() <= rightBound && shot.getY() >= upperBound && shot.getY() <= lowerBound) {
//            return true;
//        }
//        return false;
    }
    public void addDrawnPosition(PositionModel position) {
        drawnPositions.add(position);
    }
}
