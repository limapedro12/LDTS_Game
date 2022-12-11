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
        ship.resetDrawnPositions();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(ship.getX(), ship.getUpperBound(), "\"");
        ship.addDrawnPosition(new PositionModel(ship.getX(), ship.getUpperBound()));
        /*graphics.putString(ship.getX()-1, ship.getUpperBound()+1, ")");
        ship.addDrawnPosition(new PositionModel(ship.getX()-1, ship.getUpperBound()+1));
        graphics.putString(ship.getX(), ship.getUpperBound()+1, "=");
        ship.addDrawnPosition(new PositionModel(ship.getX(), ship.getUpperBound()+1));
        graphics.putString(ship.getX()+1, ship.getUpperBound()+1, "(");
        ship.addDrawnPosition(new PositionModel(ship.getX()+1, ship.getUpperBound()+1));
        graphics.putString(ship.getLeftBound(), ship.getUpperBound()+2, "+");
        ship.addDrawnPosition(new PositionModel(ship.getLeftBound(), ship.getUpperBound()+1));*/
        graphics.putString(ship.getRightBound(), ship.getUpperBound()+1, ",");
        ship.addDrawnPosition(new PositionModel(ship.getRightBound(), ship.getUpperBound()+1));
        for (int i = ship.getLeftBound()+1; i <= ship.getRightBound()-1; i++) {
            graphics.putString(i, ship.getUpperBound()+1, "=");
            ship.addDrawnPosition(new PositionModel(i, ship.getUpperBound()+1));
        }
        for (int i = ship.getLeftBound(); i <= ship.getRightBound(); i++) {
            graphics.putString(i, ship.getUpperBound()+2, "=");
            ship.addDrawnPosition(new PositionModel(i, ship.getUpperBound()+2));
        }

        /*
        graphics.setCharacter(54, 41, TextCharacter.fromCharacter(',')[0]);
>>>>>>> font
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
<<<<<<< HEAD
        ship.addDrawnPosition(new PositionModel(ship.getX(), ship.getY()));
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.setCharacter(ship.getX() - 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() - 1, ship.getLowerBound()));
        graphics.setCharacter(ship.getX() + 1, ship.getLowerBound(), TextCharacter.fromCharacter('S')[0]);
        ship.addDrawnPosition(new PositionModel(ship.getX() + 1, ship.getLowerBound()));
=======
        graphics.setCharacter(ship.getX() - 1, 43, TextCharacter.fromCharacter('S')[0]);
        graphics.setCharacter(ship.getX() + 1, 43, TextCharacter.fromCharacter('S')[0]);
        */
    }

    @Override
    public ElementModel getModel() {
        return ship;
    }
}
