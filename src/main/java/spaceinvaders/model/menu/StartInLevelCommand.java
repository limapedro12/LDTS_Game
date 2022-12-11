package spaceinvaders.model.menu;

import spaceinvaders.model.ArenaModel;
import spaceinvaders.model.ArenaStateModel;
import spaceinvaders.model.GameModel;

public class StartInLevelCommand extends Command {
    private StartCommand startCommand;
    public StartInLevelCommand(StartCommand startCommand, int level){
        this.title = "Start Game In Level";
        this.startCommand = startCommand;
        this.startCommand.setLevel(level);
    }
    public void execute(){
        //startCommand.restartArena();
        startCommand.execute();
    }
}