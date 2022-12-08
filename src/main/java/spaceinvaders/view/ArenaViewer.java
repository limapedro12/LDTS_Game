package spaceinvaders.view;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextCharacter;
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
        //graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        //graphics.enableModifiers(SGR.BOLD);

        for (ElementModel element : model.getElements()) {
            element.getViewer().draw(graphics);
        }
        for (ShotModel shot : model.getShots())
            shot.getViewer().draw(graphics);

        /*
        for (LifeModel life: model.getLives()){
            life.getViewer().draw(graphics);
        }*/
        //graphics.putString(10,3,"Life: "+model.getLifes());
        graphics.setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        drawLives(graphics);
        //graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(80,3,"Score: "+model.getScore());

    }
    private void drawLives(TextGraphics graphics) {
        graphics.putString(10, 3, "Lives: ");
        graphics.putString(18,3,"&");
        int lives = model.getLifes();
        switch (lives) {
            case 1:
                graphics.setForegroundColor(TextColor.Factory.fromString("#660000"));
                graphics.putString(19,3,"&");
                graphics.putString(20,3,"&");
                break;
            case 2:
                graphics.putString(19,3,"&");
                graphics.setForegroundColor(TextColor.Factory.fromString("#660000"));
                graphics.putString(20,3,"&");
                break;
            case 3:
                graphics.putString(19,3,"&");
                graphics.putString(20,3,"&");
        }
    }
}
