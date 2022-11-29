package spaceinvaders.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ShotViewer implements ElementViewer {
    ShotModel model;
    public ShotViewer(ShotModel model){
        this.model = model;
    }

    public void draw(TextGraphics graphics) {
        graphics.setCharacter(model.getPosition().getX(), model.getPosition().getY(), TextCharacter.fromCharacter(model.getCharacter())[0]);
    }

    public ShotModel getModel(){
        return model;
    }
}
