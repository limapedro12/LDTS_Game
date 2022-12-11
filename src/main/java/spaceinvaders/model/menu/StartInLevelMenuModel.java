package spaceinvaders.model.menu;

import spaceinvaders.model.GameModel;
import spaceinvaders.view.menu.StartInLevelMenuViewer;

public class StartInLevelMenuModel extends MenuModel {
    private static StartInLevelMenuModel instance = null;
    private GameModel gameModel;
    private Command exitCommand;
    private String level = "";
    private StartInLevelMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = StartInLevelMenuViewer.getInstance(this);
        exitCommand = new ExitToMenuCommand(gameModel);
    }
    public static StartInLevelMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new StartInLevelMenuModel(gameModel);
        }
        return instance;
    }
    public Command getExitCommand(){
        return exitCommand;
    }
    public void setLevel(String level) {
        this.level = level;
    }
    public String getLevel() {
        return this.level;
    }
    public GameModel getGameModel() {
        return this.gameModel;
    }
}
