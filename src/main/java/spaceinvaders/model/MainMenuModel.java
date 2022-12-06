package spaceinvaders.model;

import spaceinvaders.view.MainMenuViewer;
import spaceinvaders.view.MenuViewer;

public class MainMenuModel extends MenuModel {
    private static MainMenuModel instance = null;
    private GameModel gameModel;
    private Command[] commands;
    private int selectedCommand = 0;
    private MainMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = MainMenuViewer.getInstance(this);
        commands = new Command[3];
        commands[0] = new StartCommand(gameModel.getArenaModel(), gameModel);
        commands[1] = new StartCommand(gameModel.getArenaModel(), gameModel);
        commands[2] = new StartCommand(gameModel.getArenaModel(), gameModel);

    }
    public static MainMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new MainMenuModel(gameModel);
        }
        return instance;
    }
    public Command[] getCommands(){
        return commands;
    }
    public void addCommand(Command command, int index){
        commands[index] = command;
    }
    public void removeCommand(int index){
        commands[index] = null;
    }
    public int getSelectedCommand(){
        return selectedCommand;
    }

}
