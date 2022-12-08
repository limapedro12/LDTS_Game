package spaceinvaders.model.menu;

public class DummyCommand extends Command{
    public DummyCommand(String name){
        this.title = name;
    }
    @Override
    public void execute() {}
}
