package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

import java.util.ArrayList;
import java.util.List;

public class ArenaViewer {
    private ArenaModel model;

    public ArenaViewer(ArenaModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics) {
        for (ElementModel element : model.getElements()) {
            element.getViewer().draw(graphics);
        }
    }
}
