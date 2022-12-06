package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import spaceinvaders.model.GameModel;

import java.io.IOException;

public class GameController {
    private Screen screen;
    private GameModel model;
    private ArenaController arena;

    public GameController(GameModel model, Screen screen) {
        this.screen = screen;
        this.model = model;
        arena = new ArenaController(model.getArenaModel());
    }

    public boolean processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        if (key == null) return true;
        if (key.getKeyType() == KeyType.EOF) return false;
        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q')
            screen.stopScreen();
        arena.processKey(key);
        return true;
    }
}