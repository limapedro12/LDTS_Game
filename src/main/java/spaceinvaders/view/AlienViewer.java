package spaceinvaders.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.AlienModel;
import spaceinvaders.model.ElementModel;

public class AlienViewer implements ElementViewer {
    AlienModel model;

    public AlienViewer(AlienModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(new TerminalPosition(model.getX(), model.getY()), TextCharacter.fromCharacter(model.getSymbol())[0]);
    }

    @Override
    public ElementModel getModel() {
        return model;
    }
}
