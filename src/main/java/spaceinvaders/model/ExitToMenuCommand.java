package spaceinvaders.model;

public class ExitToMenuCommand implements Command {
    GameModel gameModel;
    public ExitToMenuCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setStrategy(new MainMenuStrategyModel(MainMenuModel.getInstance(gameModel)));
    }
    public String getTitle(){
        return "Exit to Menu";
    }
}
