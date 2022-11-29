package spaceinvaders.view;

import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.*;

import java.util.ArrayList;
import java.util.List;

public class ArenaView {
    ArenaModel arena;
    private ShipView ship;
    private List<AlienView> aliens;
    private List<ElementView> elements;
    private List<ShotView> shots;

    public ArenaView(ArenaModel arena) {
        this.arena = arena;
    }

    public void draw(TextGraphics graphics) {
        List<ElementModel> dead = new ArrayList<>();
        for (ElementModel element : elements) {
            element.draw(graphics);
            if(!element.isAlive()) dead.add(element);
        }
        elements.removeAll(dead);
        for (ShotModel shot : shots) {
            shot.draw(graphics);
            shot.update();
        }
    }
}
