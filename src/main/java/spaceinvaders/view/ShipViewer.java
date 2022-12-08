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
            ship.addDrawnPosition(new PositionModel(i, ship.getLowerBound()-1));
        }
        graphics.setCharacter(ship.getX() - 1, ship.getLowerBound()-2, TextCharacter.fromCharacter('#')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() - 1, ship.getLowerBound()-2));
        graphics.setCharacter(ship.getX() + 1, ship.getLowerBound()-2, TextCharacter.fromCharacter('#')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() + 1, ship.getLowerBound()-2));
        for (int i = ship.getLowerBound(); i >= ship.getUpperBound(); i--) {
            graphics.setCharacter(ship.getX(), i, TextCharacter.fromCharacter('S')[0]);
            ship.addDrawnPosition(new PositionModel(ship.getX(), i));
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#9CFAF8"));
        graphics.setCharacter(ship.getX(), ship.getY(), TextCharacter.fromCharacter('U')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX(), ship.getY()));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.setCharacter(ship.getX() - 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() - 1, ship.getLowerBound()));
        graphics.setCharacter(ship.getX() + 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() + 1, ship.getLowerBound()));
    }

    @Override
    public ElementModel getModel() {
        return ship;
    }
}
