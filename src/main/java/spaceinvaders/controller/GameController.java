package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import spaceinvaders.model.GameModel;

import java.io.IOException;

public class GameController {
    private Screen screen;
    private GameModel model;
    private RunStateController state;
    private KeyStroke lastKey;

    public GameController(GameModel model, Screen screen) {
        this.screen = screen;
        this.model = model;
        state = new RunStateController(model.getState().getController());
    }

    public boolean processKey() throws IOException {
        KeyStroke key = screen.pollInput();
        while(key != null && lastKey != null && key.getKeyType() == lastKey.getKeyType() && key.getCharacter() == lastKey.getCharacter())
            key = screen.pollInput();
        lastKey = key;
        if (key == null) return true;
        if (key.getKeyType() == KeyType.EOF) return false;

        if(state.getController() != model.getState().getController()){
            state = new RunStateController(model.getState().getController());
        }
        state.processKey(key);
        return true;
    }
}
