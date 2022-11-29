package spaceinvaders.view;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.AlienModel;

public class AlienView implements ElementView{
    AlienModel model;

    public AlienView(AlienModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics){
        graphics.setCharacter(new TerminalPosition(model.getX(), model.getY()), TextCharacter.fromCharacter(model.getSymbol())[0]);

    }
}
