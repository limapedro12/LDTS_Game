package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;

public class ArenaStrategyViewer implements RunStrategyViewer {
    private ArenaViewer arenaViewer;

    public ArenaStrategyViewer(ArenaViewer arenaViewer){
        this.arenaViewer = arenaViewer;
    }

    public void draw(TextGraphics graphics){
        arenaViewer.draw(graphics);
    }
}
