package spaceinvaders.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ShipViewer implements ElementViewer {
    private ShipModel ship;
    public ShipViewer(ShipModel ship) {
        this.ship = ship;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        for (int i = ship.getLeftBound(); i <= ship.getRightBound(); i++) {
            graphics.setCharacter(i, ship.getLowerBound()-1, TextCharacter.fromCharacter('#')[0]);
        }
        graphics.setCharacter(ship.getX() - 1, ship.getLowerBound()-2, TextCharacter.fromCharacter('#')[0]);
        graphics.setCharacter(ship.getX() + 1, ship.getLowerBound()-2, TextCharacter.fromCharacter('#')[0]);
        for (int i = ship.getLowerBound(); i >= ship.getUpperBound(); i--) {
            graphics.setCharacter(ship.getX(), i, TextCharacter.fromCharacter('S')[0]);
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#9CFAF8"));
        graphics.setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('U')[0]);
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.setCharacter(ship.getX() - 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
        graphics.setCharacter(ship.getX() + 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
    }

    @Override
    public ElementModel getModel() {
        return ship;
    }
}
