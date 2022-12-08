package spaceinvaders.model.menu;

import spaceinvaders.model.ArenaModel;
import spaceinvaders.model.Command;
import spaceinvaders.model.GameModel;

public class RestartCommand extends Command {
    private StartCommand startCommand;
    public RestartCommand(StartCommand startCommand){
        this.title = "Restart Game";
        this.startCommand = startCommand;
    }
    public void execute(){
        startCommand.restartArena();
        startCommand.execute();
    }
}
