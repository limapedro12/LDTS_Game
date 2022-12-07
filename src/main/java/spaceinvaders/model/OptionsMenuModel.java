package spaceinvaders.model;

import spaceinvaders.view.OptionsMenuViewer;

public class OptionsMenuModel extends MenuModel{
    private static OptionsMenuModel instance = null;
    private GameModel gameModel;
    private Command exitCommand;
    private OptionsMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = OptionsMenuViewer.getInstance(this);
        exitCommand = new ExitToMenuCommand(gameModel);
    }
    public static OptionsMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new OptionsMenuModel(gameModel);
        }
        return instance;
    }
    public Command getExitCommand(){
        return exitCommand;
    }
}
