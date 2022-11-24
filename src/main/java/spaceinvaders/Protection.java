package spaceinvaders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Protection extends Element {
    private int life;
    private int height = 3;
    private int width = 8;

    public Protection(Position position, int life) {
        super(position);
        this.life = life;
    }

    public void draw() {}
    @Override
    public void draw(TextGraphics graphics) {

//        for (int i = 1; i < height; i++) {
//            graphics.setCharacter(position.getX(), position.getY() + i, TextCharacter.fromCharacter('|')[0]);
//            graphics.setCharacter(position.getX() + width - 1, position.getY() + i, TextCharacter.fromCharacter('|')[0]);
//        }
//        for (int i = 0; i < width; i++) {
//            graphics.setCharacter(position.getX() + i, position.getY(), TextCharacter.fromCharacter('-')[0]);
//        }


        graphics.drawRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(width, height), TextCharacter.fromCharacter('#')[0]);
        graphics.drawRectangle(new TerminalPosition(position.getX() + 1, position.getY() + height - 1), new TerminalSize(width-2, 1), TextCharacter.fromCharacter('\'')[0]);
        drawNumber(graphics);
    }

    private void drawNumber(TextGraphics graphics) {
        int firstDigitLife = life / 10;
        int secondDigitLife = life % 10;
        graphics.setCharacter(position.getX() + width/2 - 1, position.getY() + 1, TextCharacter.fromCharacter((char) ((char) firstDigitLife + '0'))[0]);
        graphics.setCharacter(position.getX() + width/2, position.getY() + 1, TextCharacter.fromCharacter((char) ((char) secondDigitLife + '0'))[0]);
    }

    @Override
    public int getWidth() { return width; }

    @Override
    public int getHeight() { return height; }

    public int getLife() { return life; }

    @Override
    public void damage() {
        life--;
    }

    @Override
    public boolean isAlive() {
        return life > 0;
    }
}
