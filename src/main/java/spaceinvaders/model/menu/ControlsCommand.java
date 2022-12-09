package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.ControlsMenuController;
import spaceinvaders.model.GameModel;

public class ControlsCommand extends Command {
    GameModel gameModel;
    public ControlsCommand(GameModel gameModel){
        this.title = "Controls";
        this.gameModel = gameModel;
    }
    public void execute(){
        ControlsMenuModel model = ControlsMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, ControlsMenuController.getInstance(model)));
    }
}