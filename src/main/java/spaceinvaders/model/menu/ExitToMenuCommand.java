package spaceinvaders.model.menu;

import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class ExitToMenuCommand implements Command {
    GameModel gameModel;
    public ExitToMenuCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setState(new MainMenuStateModel(MainMenuModel.getInstance(gameModel)));
    }
    public String getTitle(){
        return "Exit to Menu";
    }
}
