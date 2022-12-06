package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuStateViewer implements RunStateViewer {
    private MenuViewer menuViewer;

    public MenuStateViewer(MenuViewer menuViewer){
        this.menuViewer = menuViewer;
    }

    public void draw(TextGraphics graphics){
        menuViewer.draw(graphics);
    }
}
