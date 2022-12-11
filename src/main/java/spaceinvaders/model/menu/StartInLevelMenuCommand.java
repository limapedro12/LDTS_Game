package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.StartInLevelMenuController;
import spaceinvaders.model.GameModel;

public class StartInLevelMenuCommand extends Command {
    GameModel gameModel;
    public StartInLevelMenuCommand(GameModel gameModel){
        this.title = "Start In Level";
        this.gameModel = gameModel;
    }
    public void execute(){
        StartInLevelMenuModel model = StartInLevelMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, StartInLevelMenuController.getInstance(model)));
    }
}
