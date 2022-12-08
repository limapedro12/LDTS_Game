package spaceinvaders.model.menu;

import spaceinvaders.model.GameModel;
import spaceinvaders.view.menu.HighScoreMenuViewer;

import java.util.ArrayList;
import java.util.List;

public class HighScoreMenuModel extends MenuModel{
    private static HighScoreMenuModel instance = null;
    private GameModel gameModel;
    private List<Integer> scores;
    private Command exitCommand;
    private HighScoreMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = HighScoreMenuViewer.getInstance(this);
        scores = new ArrayList<>();
        exitCommand = new ExitToMenuCommand(gameModel);
        scores.add(100);
        scores.add(200);
        scores.add(300);
    }
    public static HighScoreMenuModel getInstance(GameModel gameModel){
        if(instance == null){
            instance = new HighScoreMenuModel(gameModel);
        }
        return instance;
    }
    public List<Integer> getScores(){
        return scores;
    }
    public Command getExitCommand(){
        return exitCommand;
    }
}
