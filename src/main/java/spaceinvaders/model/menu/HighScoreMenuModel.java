package spaceinvaders.model.menu;

import spaceinvaders.PlayerScore;
import spaceinvaders.model.GameModel;
import spaceinvaders.view.menu.HighScoreMenuViewer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import static spaceinvaders.PlayerScore.loadScores;

public class HighScoreMenuModel extends MenuModel{
    private static HighScoreMenuModel instance = null;
    private GameModel gameModel;
    private Command exitCommand;
    private HighScoreMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = HighScoreMenuViewer.getInstance(this);
        exitCommand = new ExitToMenuCommand(gameModel);
    }
    public static HighScoreMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new HighScoreMenuModel(gameModel);
        }
        return instance;
    }

    public static void reset() {
        instance = null;
    }
    public Command getExitCommand(){
        return exitCommand;
    }
    public void setExitCommand(Command exitCommand){
        this.exitCommand = exitCommand;
    }
}

