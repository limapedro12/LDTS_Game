package spaceinvaders.model;

public class ExitCommand implements Command{
    public void execute(){
        System.exit(0);
    }
    public String getTitle(){
        return "Exit";
    }
}
