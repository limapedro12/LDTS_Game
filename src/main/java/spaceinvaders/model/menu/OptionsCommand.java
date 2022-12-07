package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.MainMenuController;
import spaceinvaders.controller.menu.OptionsMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class OptionsCommand implements Command {
    GameModel gameModel;
    public OptionsCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        OptionsMenuModel model = OptionsMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, OptionsMenuController.getInstance(model)));
    }
    public String getTitle(){
        return "Options";
    }
}
