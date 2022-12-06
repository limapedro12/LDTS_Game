package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public class MenuStrategyViewer implements RunStrategyViewer {
    private MenuViewer menuViewer;

    public MenuStrategyViewer(MenuViewer menuViewer){
        this.menuViewer = menuViewer;
    }

    public void draw(TextGraphics graphics){
        menuViewer.draw(graphics);
    }
}
