package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import spaceinvaders.model.GameModel;

import java.io.IOException;

public class GameViewer {
    private GameModel model;
    private Screen screen;

    public GameViewer(GameModel model, Screen screen) {
        this.model = model;
    }

    public void draw() throws IOException {
        System.out.println("Piu!");
        screen.clear();
        System.out.println("Piu!");
        model.getArenaModel().getViewer().draw(screen.newTextGraphics());
        screen.refresh();
    }
}
