package spaceinvaders.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ShipView {
    private ShipModel ship;
    public ShipView(ShipModel ship) {
        this.ship = ship;
    }
    public void draw(TextGraphics graphics) {
        for (int i = ship.getLeftBound(); i <= ship.getRightBound(); i++) {
            graphics.setCharacter(i, 42, TextCharacter.fromCharacter('#')[0]);
        }
        graphics.setCharacter(ship.getX() - 1, 41, TextCharacter.fromCharacter('#')[0]);
        graphics.setCharacter(ship.getX() + 1, 41, TextCharacter.fromCharacter('#')[0]);
        graphics.setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('+')[0]);
        for (int i = 43; i >= 39; i--) {
            graphics.setCharacter(ship.getX(), i, TextCharacter.fromCharacter('S')[0]);
        }
        graphics.setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('U')[0]);
        graphics.setCharacter(ship.getX() - 1, 43, TextCharacter.fromCharacter('S')[0]);
        graphics.setCharacter(ship.getX() + 1, 43, TextCharacter.fromCharacter('S')[0]);
    }
}
