package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.controller.MenuController;
import spaceinvaders.model.MenuModel;

public interface MenuViewer extends Viewer {
    public abstract void draw(TextGraphics graphics);
}
