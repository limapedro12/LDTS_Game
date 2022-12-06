package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

public class ArenaViewer implements Viewer{
    private ArenaModel model;

    public ArenaViewer(ArenaModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics) {
        for (ElementModel element : model.getElements()) {
            element.getViewer().draw(graphics);
        }
        for (ShotModel shot : model.getShots())
            shot.getViewer().draw(graphics);


    }
}
