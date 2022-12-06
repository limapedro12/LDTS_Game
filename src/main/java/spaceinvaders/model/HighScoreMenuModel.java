package spaceinvaders.model;

import spaceinvaders.view.HighScoreMenuViewer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class HighScoreMenuModel extends MenuModel{
    private static HighScoreMenuModel instance = null;
    private GameModel gameModel;
    private List<Integer> scores;
    private HighScoreMenuModel(GameModel gameModel){
        this.gameModel = gameModel;
        this.viewer = HighScoreMenuViewer.getInstance(this);
        scores = new ArrayList<>();
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
}
