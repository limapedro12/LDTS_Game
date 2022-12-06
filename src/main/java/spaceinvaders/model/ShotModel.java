package spaceinvaders.model;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.ShotViewer;

public class ShotModel extends ElementModel {
    float floatY;
    private float speed;
    //if true, the shot is going up, if false, the shot is going down
    private boolean direction;
    private char character;

    public ShotModel(PositionModel position, float speed, boolean direction, char character) {
        super(position);
        this.speed = speed;
        this.direction = direction;
        this.character = character;
        this.floatY = position.getY();
        this.viewer = new ShotViewer(this);
    }

    public PositionModel getPosition() {
        return position;
    }

    public void update() {
        if (direction)
            floatY -= speed;
        else
            floatY += speed;
        position.setY((int) floatY);
    }

    static public boolean up = true;
    static public boolean down = false;
    public boolean isAlive() {
        return false;
    }

    public float getSpeed() {
        return speed;
    }

    public char getCharacter() {
        return character;
    }
    public boolean isTangible(){
        return false;
    }
}
