package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.InfoMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class InfoCommand implements Command {
    GameModel gameModel;
    public InfoCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        InfoMenuModel model = InfoMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, InfoMenuController.getInstance(model)));
    }
    public String getTitle(){
        return "Info";
    }
}
