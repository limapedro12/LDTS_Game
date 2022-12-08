package spaceinvaders.view.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.Viewer;

public interface MenuViewer extends Viewer {
    public abstract void draw(TextGraphics graphics);
}
