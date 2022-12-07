package spaceinvaders.model;

public class DummyCommand implements Command{
    private String name;
    public DummyCommand(String name){
        this.name = name;
    }
    @Override
    public void execute() {}

    @Override
    public String getTitle() {
        return name;
    }

}
