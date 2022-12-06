package spaceinvaders.model;

public class StartCommand implements Command{
    ArenaModel arena;
    GameModel gameModel;
    public StartCommand(ArenaModel arena, GameModel gameModel){
        this.arena = arena;
        this.gameModel = gameModel;
    }
    public void execute(){
        gameModel.setStrategy(new ArenaStrategyModel(arena));
    }
    public String getTitle(){
        return "Start";
    }
}
