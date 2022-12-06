package spaceinvaders.model;

public class HighScoreCommand implements Command{
    GameModel gameModel;
    public HighScoreCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setState(new HighScoreMenuState(HighScoreMenuModel.getInstance(gameModel)));
    }
    public String getTitle(){
        return "HighScores";
    }
}
