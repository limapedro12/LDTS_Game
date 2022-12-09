package spaceinvaders.view.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.PlayerScore;
import spaceinvaders.model.menu.HighScoreMenuModel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
        graphics.putString(20, 6, "HighScores");
        String line = "";
        String splitBy = ",";
        try {
            int y = 10;
            BufferedReader br = new BufferedReader(new FileReader("resources/highscores.csv"));
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(splitBy);
                graphics.putString(13, y, arr[0]);
                graphics.putString(60, y, arr[1]);
                y += 2;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        for(int i = 0; i < model.getScores().size(); i++){
            graphics.putString(40, 20 + i, model.getScores().get(i).toString());
        }*/
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        graphics.putString(13, 35, "> Exit");
    }
}
