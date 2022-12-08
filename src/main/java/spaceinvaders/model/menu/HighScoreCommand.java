package spaceinvaders.model.menu;

import spaceinvaders.controller.menu.HighScoreMenuController;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class HighScoreCommand extends Command {
    GameModel gameModel;
    public HighScoreCommand(GameModel gameModel){
        this.title = "HighScores";
        this.gameModel = gameModel;
    }
    public void execute(){
        HighScoreMenuModel model = HighScoreMenuModel.getInstance(gameModel);
        gameModel.setState(new MenuStateModel(model, HighScoreMenuController.getInstance(model)));
    }
}
