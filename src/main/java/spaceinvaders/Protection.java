package spaceinvaders;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Protection extends Element {
    int life;
    int height = 2;
    int width = 3;

    public Protection(Position position, int life) {
        super(position);
        this.life = life;
    }

    public void draw() {}
    @Override
    public void draw(TextGraphics graphics) {
        for (int i = 0; i <= height; i++) {
            graphics.setCharacter(position.getX() + width/2, position.getY() + i, TextCharacter.fromCharacter('|')[0]);
            graphics.setCharacter(position.getX() - width/2, position.getY() + i, TextCharacter.fromCharacter('|')[0]);
        }
        for (int i = 0; i <= width/2; i++) {
            graphics.setCharacter(position.getX() + i, position.getY(), TextCharacter.fromCharacter('_')[0]);
            graphics.setCharacter(position.getX() - i, position.getY(), TextCharacter.fromCharacter('_')[0]);
        }
    }
}
