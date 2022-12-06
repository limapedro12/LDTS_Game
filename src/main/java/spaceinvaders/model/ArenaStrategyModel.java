package spaceinvaders.model;

public class ArenaStrategyModel implements RunStrategyModel{
    private ArenaModel model;
    public ArenaStrategyModel(ArenaModel model){
        this.model = model;
    }
    public void run(){
        model.run();
    }
}
