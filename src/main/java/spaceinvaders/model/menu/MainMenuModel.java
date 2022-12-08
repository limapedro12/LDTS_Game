package spaceinvaders.model.menu;

import spaceinvaders.model.Command;
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
    protected MainMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = MainMenuViewer.getInstance(this);
        commands = new ArrayList<>();
        addCommands();
        continueEnabled = false;
    }
    protected void addCommands(){
        commands.add(new StartCommand(gameModel));
        commands.add(new HighScoreCommand(gameModel));
        commands.add(new OptionsCommand(gameModel));
        commands.add(new ExitCommand());
    }
    public static MainMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new MainMenuModel(gameModel);
        }
        if(instance.getGameModel().getHasEnteredArena() && !instance.isContinueEnabled()){
            instance.addContinueCommand();
            instance.setContinueEnabled(true);
        }
        return instance;
    }
    public void addContinueCommand(){
        commands.get(0).setTitle("Continue Game");
        commands.add(1, new RestartCommand((StartCommand) commands.get(0)));
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

}
