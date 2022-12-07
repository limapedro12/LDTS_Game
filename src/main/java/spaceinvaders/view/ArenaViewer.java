package spaceinvaders.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;


import java.awt.*;

public class ArenaViewer implements Viewer{
    private ArenaModel model;

    public ArenaViewer(ArenaModel model) {
        this.model = model;
    }

    public void draw(TextGraphics graphics) {
        for (ShotModel shot : model.getShots())
            shot.getViewer().draw(graphics);
        for (ElementModel element : model.getElements())
            element.getViewer().draw(graphics);


        for (LifeModel life: model.getLives()){
            life.getViewer().draw(graphics);
        }

        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(10,3,"Life: "+model.getShip().getLives());
        graphics.putString(80,3,"Score: "+model.getScore());

    }
}
