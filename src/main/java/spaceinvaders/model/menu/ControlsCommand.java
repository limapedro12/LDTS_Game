package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.ControlsMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class ControlsCommand implements Command {
    GameModel gameModel;
    public ControlsCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        ControlsMenuModel model = ControlsMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, ControlsMenuController.getInstance(model)));
    }
    public String getTitle(){
        return "Controls";
    }
}
