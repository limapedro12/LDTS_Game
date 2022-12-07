package spaceinvaders.model;

import spaceinvaders.view.OptionsMenuViewer;

import java.util.ArrayList;
import java.util.List;

public class OptionsMenuModel extends MenuModel{
    private static OptionsMenuModel instance = null;
    private GameModel gameModel;
    protected List<Command> commands;
    protected int selectedCommand = 0;
    private Command exitCommand;
    private OptionsMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = OptionsMenuViewer.getInstance(this);
        commands = new ArrayList<>();
        addCommands();
        exitCommand = new ExitToMenuCommand(gameModel);
    }
    public Command getExitCommand(){
        return exitCommand;
    }
    protected void addCommands(){
        commands.add(new DummyCommand("Commands"));
        commands.add(new DummyCommand("Info"));
    }
    public static OptionsMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new OptionsMenuModel(gameModel);
        }
        return instance;
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

}
