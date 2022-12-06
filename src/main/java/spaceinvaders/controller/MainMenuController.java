package spaceinvaders.controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import spaceinvaders.model.MainMenuModel;

import static com.googlecode.lanterna.input.KeyType.ArrowDown;
import static com.googlecode.lanterna.input.KeyType.ArrowUp;

public class MainMenuController implements Controller{
    private MainMenuModel model;
    private static MainMenuController instance = null;
    private MainMenuController(MainMenuModel model){
        this.model = model;
    }
    public static MainMenuController getInstance(MainMenuModel model){
        if(instance == null){
            instance = new MainMenuController(model);
        }
        return instance;
    }
    public static MainMenuController getInstance(){
        return instance;
    }

    @Override
    public void processKey(KeyStroke key) {
        if(key.getKeyType() == ArrowUp){
            model.setSelectedCommand(model.getSelectedCommand() - 1);
        }
        else if (key.getKeyType() == ArrowDown){
            model.setSelectedCommand(model.getSelectedCommand() + 1);
        }
        else if (key.getKeyType() == KeyType.Enter){
            model.getCommands()[model.getSelectedCommand()].execute();
        }
    }
}
