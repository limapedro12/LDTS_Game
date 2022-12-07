package spaceinvaders.model;

public class OptionsCommand implements Command{
    GameModel gameModel;
    public OptionsCommand(GameModel gameModel){
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setState(new OptionsMenuState(OptionsMenuModel.getInstance(gameModel)));
    }
    public String getTitle(){
        return "Options";
    }
}
