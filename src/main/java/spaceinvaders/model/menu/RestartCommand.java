package spaceinvaders.model.menu;

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
