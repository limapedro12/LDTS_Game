package spaceinvaders.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.AlienModel;
import spaceinvaders.model.ElementModel;
import spaceinvaders.model.LifeModel;

public class LifeViewer implements ElementViewer{
    LifeModel model;

    public LifeViewer(LifeModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(model.getPosition().getX(), model.getPosition().getY(), TextCharacter.fromCharacter('?')[0]);

    }


    @Override
    public ElementModel getModel() {
        return model;
    }
}
