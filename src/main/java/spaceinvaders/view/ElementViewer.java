package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.ElementModel;

public interface ElementViewer extends Viewer {
    public void draw(TextGraphics graphics);
    public ElementModel getModel();
}
