package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import spaceinvaders.model.HighScoreMenuModel;

public class HighScoreMenuController implements Controller {
    private HighScoreMenuModel model;
    private static HighScoreMenuController instance = null;
    private HighScoreMenuController(HighScoreMenuModel model){
        this.model = model;
    }
    public static HighScoreMenuController getInstance(HighScoreMenuModel model){
        if(instance == null){
            instance = new HighScoreMenuController(model);
        }
        return instance;
    }
    public static HighScoreMenuController getInstance(){
        return instance;
    }

    @Override
    public void processKey(KeyStroke key) {
        if (key.getKeyType() == KeyType.Enter){
            model.getExitCommand().execute();
        }
    }
}
