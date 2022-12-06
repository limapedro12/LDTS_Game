package spaceinvaders.model;

import spaceinvaders.view.MainMenuViewer;
import spaceinvaders.view.MenuViewer;

public class MainMenuModel extends MenuModel {
    private static MainMenuModel instance = null;
    private Command[] commands;
    private int selectedCommand = 0;
    private MainMenuModel(){
        this.viewer = MainMenuViewer.getInstance(this);
        commands = new Command[3];

    }
    public static MainMenuModel getInstance(){
        if(instance == null){
            instance = new MainMenuModel();
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
}
