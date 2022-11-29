package spaceinvaders.model;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.ProtectionViewer;

public class ProtectionModel extends ElementModel {
    private int life;
    private int height = 3;
    private int width = 8;

    public ProtectionModel(PositionModel position, int life) {
        super(position);
        this.life = life;
        this.viewer = new ProtectionViewer(this);
    }

    public void draw() {}


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
