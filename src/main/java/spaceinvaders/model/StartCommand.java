package spaceinvaders.model;

public class StartCommand implements Command{
    ArenaModel arena;
    GameModel gameModel;
    public StartCommand(GameModel gameModel){
        this.arena = new ArenaModel(gameModel);
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setStrategy(new ArenaStrategyModel(arena));
    }
    public String getTitle(){
        return "Start";
    }
}
