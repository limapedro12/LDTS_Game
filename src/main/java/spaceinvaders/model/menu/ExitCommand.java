package spaceinvaders.model.menu;

public class ExitCommand extends Command {
    public void execute(){
        System.exit(0);
    }
    public String getTitle(){
        return "Exit";
    }
}
