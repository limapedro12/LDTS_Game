package spaceinvaders.model;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class ShipModel extends ElementModel implements ShotSubjectModel {
    private int leftBound;
    private int rightBound;
    private final int upperBound = 39;
    private final int lowerBound = 43;
    public ShipModel() {
        super(new PositionModel(50, 40));
        this.leftBound = 46;
        this.rightBound = 54;
    }
    public ShipModel(int x) {
        super(new PositionModel(x, 40));
        this.leftBound = x-4;
        this.rightBound = x+4;
    }
    public int getX() {
        return position.getX();
    }
    public int getY() {
        return 40;
    }
    public int getLeftBound() {
        return leftBound;
    }
    public int getRightBound() {
        return rightBound;
    }

    public void addObserver(ShotObserverModel observer){
        observers.add(observer);
    }
    public void removeObserver(ShotObserverModel observer){
        observers.remove(observer);
    }
    public void notifyObservers(ShotModel shot){
        for(ShotObserverModel observer : observers){
            observer.update(shot);
        }
    }

    public List<ShotObserverModel> getObservers(){
        return observers;
    }

    @Override
    public void draw(TextGraphics graphics) {
        for (int i = leftBound; i <= rightBound; i++) {
            graphics.setCharacter(i, lowerBound - 1, TextCharacter.fromCharacter('#')[0]);
        }
        graphics.setCharacter(getX() - 1, lowerBound - 2, TextCharacter.fromCharacter('#')[0]);
        graphics.setCharacter(getX() + 1, lowerBound - 2, TextCharacter.fromCharacter('#')[0]);
        graphics.setCharacter(getX(), getY(), TextCharacter.fromCharacter('+')[0]);
        for (int i = lowerBound; i >= upperBound; i--) {
            graphics.setCharacter(getX(), i, TextCharacter.fromCharacter('S')[0]);
        }
        graphics.setCharacter(getX(), getY(), TextCharacter.fromCharacter('U')[0]);
        graphics.setCharacter(getX() - 1, lowerBound, TextCharacter.fromCharacter('S')[0]);
        graphics.setCharacter(getX() + 1, lowerBound, TextCharacter.fromCharacter('S')[0]);
    }
    public boolean canIMove(boolean goingLeft) {
        if (goingLeft) {
            return leftBound > 1;
        } else {
            return rightBound < 98;
        }
    }
    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case 'a':
                    if (!canIMove(true)) return;
                    this.position.setX(this.position.getX() - 1);
                    leftBound--;
                    rightBound--;
                    break;
                case 'd':
                    if (!canIMove(false)) return;
                    this.position.setX(this.position.getX() + 1);
                    leftBound++;
                    rightBound++;
                    break;
                case ' ':
                    fire();
                    break;
            }
        } else {
            KeyType keyType = key.getKeyType();
            switch (keyType) {
                case ArrowLeft:
                    if (!canIMove(true)) return;
                    this.position.setX(this.position.getX() - 1);
                    leftBound--;
                    rightBound--;
                    break;
                case ArrowRight:
                    if (!canIMove(false)) return;
                    this.position.setX(this.position.getX() + 1);
                    leftBound++;
                    rightBound++;
                    break;
                case ArrowUp: fire(); break;
            }
        }
    }
    public void fire() {
        ShipShotModel shot = new ShipShotModel(new PositionModel(getX(), getY() - 2));
        notifyObservers(shot);
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
}
