package spaceinvaders.model.menu;

import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;
import spaceinvaders.view.menu.ControlsMenuViewer;

import java.util.ArrayList;
import java.util.List;

public class ControlsMenuModel extends MenuModel{
    private static ControlsMenuModel instance = null;
    private GameModel gameModel;
    private Command exitCommand;
    private ControlsMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = ControlsMenuViewer.getInstance(this);
        exitCommand = new OptionsCommand(gameModel);
    }
    public static ControlsMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new ControlsMenuModel(gameModel);
        }
        return instance;
    }
    public Command getExitCommand(){
        return exitCommand;
    }
}
