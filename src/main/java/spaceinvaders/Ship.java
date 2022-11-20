package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.w3c.dom.Text;

import javax.swing.*;

public class Ship extends Element{
    private int leftBound;
    private int rightBound;
    private final int upperBound = 39;
    private final int lowerBound = 43;
    public Ship () {
        super(new Position(50, 40));
        this.leftBound = 45;
        this.rightBound = 55;
    }
    public void draw(Screen screen) {
        for (int i = leftBound; i <= rightBound; i++) {
            screen.setCharacter(i, lowerBound, TextCharacter.fromCharacter('S')[0]);
        }
        for (int i = lowerBound; i >= upperBound; i--) {
            screen.setCharacter(getX(), i, TextCharacter.fromCharacter('S')[0]);
        }
    }
    public boolean canIMove(int direction) {
        switch (direction) {
            case -1:
                return leftBound > 1;
            case 1:
                return rightBound < 98;
        }
        return false;
    }
    public void processKey(KeyStroke key, Screen screen) {
        if (key.getKeyType() == KeyType.Character) {
            switch (key.getCharacter()) {
                case 'a':
                    if (!canIMove(-1)) return;
                    this.position.setY(this.position.getX() - 1);
                    leftBound--;
                    rightBound--;
                    break;
                case 'd':
                    if (!canIMove(1)) return;
                    this.position.setY(this.position.getX() + 1);
                    leftBound++;
                    rightBound++;
                    break;
            }
        } else {
            KeyType keyType = key.getKeyType();
            switch (keyType) {
                case ArrowLeft:
                    if (!canIMove(-1)) return;
                    this.position.setX(this.position.getX() - 1);
                    leftBound--;
                    rightBound--;
                    break;
                case ArrowRight:
                    if (!canIMove(1)) return;
                    this.position.setX(this.position.getX() + 1);
                    leftBound++;
                    rightBound++;
                    break;
                case ArrowUp: fire(screen); break;
            }
        }
    }
    private void fire(Screen screen) {
        return;
    }
}
