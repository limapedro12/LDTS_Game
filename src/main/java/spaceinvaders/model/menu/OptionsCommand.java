package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.MainMenuController;
import spaceinvaders.controller.menu.OptionsMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class OptionsCommand extends Command {
    GameModel gameModel;
    public OptionsCommand(GameModel gameModel){
        this.title = "Options";
        this.gameModel = gameModel;
    }
    public void execute(){
        OptionsMenuModel model = OptionsMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, OptionsMenuController.getInstance(model)));
    }
}
