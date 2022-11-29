package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;

public class ArenaController {
    private ShipController ship;

    public void processKey(KeyStroke key) {
        ship.processKey(key);
    }
}
