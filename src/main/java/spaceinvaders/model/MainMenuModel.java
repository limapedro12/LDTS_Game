package spaceinvaders.model;

import spaceinvaders.controller.Controller;
import spaceinvaders.controller.MainMenuController;
import spaceinvaders.view.MainMenuViewer;
import spaceinvaders.view.MenuViewer;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class MainMenuModel extends MenuModel {
    private static MainMenuModel instance = null;
    private GameModel gameModel;
    private List<Command> commands;
    private int selectedCommand = 0;
    private MainMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = MainMenuViewer.getInstance(this);
        commands = new ArrayList<>();
        commands.add(new StartCommand(gameModel));
        commands.add(new HighScoreCommand(gameModel));
        commands.add(new ExitCommand());

    }
    public static MainMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new MainMenuModel(gameModel);
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
