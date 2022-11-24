package spaceinvaders;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.util.List;

public class Ship extends Element implements ShotSubject {
    private int leftBound;
    private int rightBound;
    private final int upperBound = 39;
    private final int lowerBound = 43;
    public Ship() {
        super(new Position(50, 40));
        this.leftBound = 46;
        this.rightBound = 54;
    }
    public Ship(int x) {
        super(new Position(x, 40));
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

    public void addObserver(ShotObserver observer){
        observers.add(observer);
    }
    public void removeObserver(ShotObserver observer){
        observers.remove(observer);
    }
    public void notifyObservers(Shot shot){
        for(ShotObserver observer : observers){
            observer.update(shot);
        }
    }

    public List<ShotObserver> getObservers(){
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
    public void processKey(KeyStroke key, Screen screen) {
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
        notifyObservers(new ShipShot(new Position(getX(), getY() - 2)));
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
