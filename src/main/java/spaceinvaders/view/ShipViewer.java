package spaceinvaders.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ShipViewer implements ElementViewer {
    private ShipModel ship;
    public ShipViewer(ShipModel ship) {
        this.ship = ship;
    }
    public void draw(TextGraphics graphics) {
        // yBoundaries = 42 -> 39
        // xBoundaries = 46 -> 54
        graphics.setCharacter(ship.getX(), 39, TextCharacter.fromCharacter('"')[0]);
        graphics.setCharacter(ship.getX()-1, 40, TextCharacter.fromCharacter(')')[0]);
        graphics.setCharacter(ship.getX(), 40, TextCharacter.fromCharacter('=')[0]);
        graphics.setCharacter(ship.getX()+1, 40, TextCharacter.fromCharacter('(')[0]);
        graphics.setCharacter(ship.getLeftBound(), 41, TextCharacter.fromCharacter('+')[0]);
        graphics.setCharacter(ship.getRightBound(), 41, TextCharacter.fromCharacter(',')[0]);
        for (int i = ship.getLeftBound()+1; i <= ship.getRightBound()-1; i++) graphics.setCharacter(i, 41, TextCharacter.fromCharacter('=')[0]);
        for (int i = ship.getLeftBound(); i <= ship.getRightBound(); i++) graphics.setCharacter(i, 42, TextCharacter.fromCharacter('=')[0]);

        /*
        graphics.setCharacter(54, 41, TextCharacter.fromCharacter(',')[0]);
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
        */
    }

    @Override
    public ElementModel getModel() {
        return ship;
    }
}
