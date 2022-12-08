package spaceinvaders.model.menu;

import spaceinvaders.model.Command;

public class ExitCommand extends Command {
    public void execute(){
        System.exit(0);
    }
    public String getTitle(){
        return "Exit";
    }
}
