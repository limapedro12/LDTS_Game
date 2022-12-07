package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.MainMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class ExitToMenuCommand implements Command {
    GameModel gameModel;
    public ExitToMenuCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        MainMenuModel model = MainMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, MainMenuController.getInstance(model)));
    }
    public String getTitle(){
        return "Exit to Menu";
    }
}
