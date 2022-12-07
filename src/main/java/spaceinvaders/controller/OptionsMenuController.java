package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import spaceinvaders.model.HighScoreMenuModel;
import spaceinvaders.model.OptionsMenuModel;

public class OptionsMenuController implements Controller{
    private OptionsMenuModel model;
    private static OptionsMenuController instance = null;

    private OptionsMenuController(OptionsMenuModel model) {
        this.model = model;
    }

    public static OptionsMenuController getInstance(OptionsMenuModel model) {
        if (instance == null) {
            instance = new OptionsMenuController(model);
        }
        return instance;
    }

    public static OptionsMenuController getInstance() {
        return instance;
    }

    @Override
    public void processKey(KeyStroke key) {
        if ((key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') ||
                key.getKeyType() == KeyType.Escape || key.getKeyType() == KeyType.Enter) {
            model.getExitCommand().execute();
        }
    }
}
