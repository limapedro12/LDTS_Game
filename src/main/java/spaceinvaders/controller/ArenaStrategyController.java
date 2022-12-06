package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;

public class ArenaStrategyController implements RunStrategyController {
    private Controller arenaController;

    public ArenaStrategyController(Controller arenaController){
        this.arenaController = arenaController;
    }

    public void processKey(KeyStroke key){
        arenaController.processKey(key);
    }
}
