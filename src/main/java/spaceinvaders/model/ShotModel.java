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

    public boolean collideWith(ElementModel element) {
        if (element.isTangible() && position.getX() >= element.getX() && position.getX() <= element.getX() + element.getWidth() - 1 &&
                position.getY() >= element.getY() && position.getY() <= element.getY() + element.getHeight() - 1) {
            return true;
        }
        return false;
    }

    public boolean collideWith(AlienGroupModel alienGroup) {
        for (AlienModel alien : alienGroup.getAliens()) {
            if (collideWith(alien)) {
                alien.damage()
                return true;
            }
        }
        return false;
    }

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
