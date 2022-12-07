package spaceinvaders.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.model.menu.HighScoreMenuModel;
import spaceinvaders.view.MenuViewer;

public class HighScoreMenuViewer implements MenuViewer {
    private static HighScoreMenuViewer instance = null;
    private HighScoreMenuModel model;
    private HighScoreMenuViewer(HighScoreMenuModel model){
        this.model = model;
    }
    public static HighScoreMenuViewer getInstance(HighScoreMenuModel model){
        if(instance == null){
            instance = new HighScoreMenuViewer(model);
        }
        return instance;
    }

    public void draw(TextGraphics graphics){
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.putString(40, 18, "HighScores");
        for(int i = 0; i < model.getScores().size(); i++){
            graphics.putString(40, 20 + i, model.getScores().get(i).toString());
        }
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(40, 40, "> Exit");
    }
}
