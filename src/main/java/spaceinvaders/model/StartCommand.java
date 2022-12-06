package spaceinvaders.model;

public class StartCommand implements Command{
    ArenaModel arena;
    public StartCommand(ArenaModel arena){
        this.arena = arena;
    }
    public void execute(){
        arena.run();
    }
    public String getTitle(){
        return "Start";
    }
}
