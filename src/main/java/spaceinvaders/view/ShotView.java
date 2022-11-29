package spaceinvaders.view;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ShotView implements ElementView {
    ShotModel model;



    public void draw(TextGraphics graphics) {
        graphics.setCharacter(model.getPosition().getX(), model.getPosition().getY(), TextCharacter.fromCharacter(model.getCharacter())[0]);
    }
}
