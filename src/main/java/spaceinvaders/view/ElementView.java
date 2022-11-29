package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.ElementModel;

public interface ElementView {
    public void draw(TextGraphics graphics);
    public ElementModel getModel();
}
