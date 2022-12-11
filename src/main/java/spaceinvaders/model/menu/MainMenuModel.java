package spaceinvaders.model.menu;

import spaceinvaders.model.GameModel;
import spaceinvaders.view.menu.MainMenuViewer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class MainMenuModel extends MenuModel {
    private static MainMenuModel instance = null;
    protected GameModel gameModel;
    protected List<Command> commands;
    protected boolean continueEnabled;
    protected int selectedCommand = 0;
    protected StartCommand startCommand;
    protected MainMenuModel(GameModel gameModel){
        this.startCommand = new StartCommand(gameModel);
        this.gameModel = gameModel;
        this.viewer = MainMenuViewer.getInstance(this);
        commands = new ArrayList<>();
        addCommands();
        continueEnabled = false;
    }
    protected void addCommands(){
        commands.add(startCommand);
        commands.add(new StartInLevelMenuCommand(gameModel, startCommand));
        commands.add(new HighScoreCommand(gameModel));
        commands.add(new OptionsCommand(gameModel));
        commands.add(new ExitCommand());
    }
    public static MainMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new MainMenuModel(gameModel);
        }
        System.out.println(instance.getStartCommand().getArena().isLost());
        if(!instance.getStartCommand().getArena().isLost() && !instance.isContinueEnabled()){
            instance.addContinueCommand();
            instance.setContinueEnabled(true);
        } else if(instance.isContinueEnabled() && instance.getStartCommand().getArena().isLost()){
            instance.removeContinueCommand();
            instance.setContinueEnabled(false);
        }

        return instance;
    }
    public void addContinueCommand(){
        startCommand.setTitle("Continue Game");
        commands.get(1).setTitle("Restart In Level");
        commands.add(1, new RestartCommand(startCommand));
    }
    public void removeContinueCommand(){
        startCommand.setTitle("Start Game");
        commands.get(2).setTitle("Start In Level");
        startCommand.restartArena();
        if(isContinueEnabled())
            commands.remove(1);
    }
    public List<Command> getCommands(){
        return commands;
    }
    public int getSelectedCommandInt(){
        return selectedCommand;
    }
    public Command getSelectedCommand(){
        return commands.get(selectedCommand);
    }
    public void upSelectedCommand(){
        if (selectedCommand > 0){
            selectedCommand--;
        } else {
            selectedCommand = commands.size() - 1;
        }
    }
    public void downSelectedCommand(){
        selectedCommand = (selectedCommand + 1) % commands.size();
    }
    public GameModel getGameModel(){
        return gameModel;
    }
    public boolean isContinueEnabled(){
        return continueEnabled;
    }
    public void setContinueEnabled(boolean continueEnabled){
        this.continueEnabled = continueEnabled;
    }
    public StartCommand getStartCommand(){
        return startCommand;
    }

}
