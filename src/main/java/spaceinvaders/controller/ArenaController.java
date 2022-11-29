package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import spaceinvaders.model.ArenaModel;

public class ArenaController {
    private ShipController ship;

    public ArenaController (ArenaModel model) {
        this.ship = new ShipController(model.getShip());
    }

    public void processKey(KeyStroke key) {
        ship.processKey(key);
    }
}
