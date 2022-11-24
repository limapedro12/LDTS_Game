package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Shot extends Element {
    float floatY;
    private float speed;
    //if true, the shot is going up, if false, the shot is going down
    private boolean direction;
    private char character;

    public Shot(Position position, float speed, boolean direction, char character) {
        super(position);
        this.speed = speed;
        this.direction = direction;
        this.character = character;
        this.floatY = position.getY();
    }

    public Position getPosition() {
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

    public void draw(){}
    public void draw(TextGraphics graphics) {
        graphics.setCharacter(position.getX(), position.getY(), TextCharacter.fromCharacter(character)[0]);
    }

    public boolean collideWith(Element element) {
//        System.out.printf("X: %d < %d < %d\n", element.getX(), position.getX(), element.getX() + element.getWidth());
//        System.out.printf("Y: %d < %d < %d\n\n", element.getY(), position.getY(), element.getY() + element.getHeight());
        if (position.getX() >= element.getX() && position.getX() <= element.getX() + element.getWidth() - 1 &&
                position.getY() >= element.getY() && position.getY() <= element.getY() + element.getHeight() - 1) {
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return false;
    }

    public float getSpeed() {
        return speed;
    }
}
