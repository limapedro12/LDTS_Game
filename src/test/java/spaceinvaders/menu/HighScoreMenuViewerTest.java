package spaceinvaders.menu;

import com.google.common.base.Splitter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.HighScoreMenuModel;
import spaceinvaders.view.menu.HighScoreMenuViewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreMenuViewerTest {
    GameModel gameModel;
    HighScoreMenuModel model;
    HighScoreMenuViewer viewer;
    @BeforeEach
    public void helper(){
        gameModel = Mockito.mock(GameModel.class);
        HighScoreMenuModel.reset();
        HighScoreMenuViewer.reset();
        model = HighScoreMenuModel.getInstance(gameModel);
        viewer = HighScoreMenuViewer.getInstance(model);
    }

    @Test
    public void getInstanceTest1(){
        assertEquals(viewer, HighScoreMenuViewer.getInstance(model));
    }

    @Test
    public void getInstanceTest2(){
        HighScoreMenuModel modelMock = Mockito.mock(HighScoreMenuModel.class);
        assertEquals(viewer, HighScoreMenuViewer.getInstance(modelMock));
    }

    @Test
    public void getInstanceTest3(){
        assertEquals(viewer, HighScoreMenuViewer.getInstance());
    }

    @Test
    public void draw(){
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        viewer.draw(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        Mockito.verify(graphicsMock, Mockito.atLeast(1)).putString(8, 2, "HighScores");

        String line = "";
        String splitBy = ",";
        try {
            int y = 5;
            BufferedReader br = Files.newBufferedReader(Paths.get("resources/highscores.csv"), UTF_8);
            while ((line = br.readLine()) != null) {
                List<String> arr = Splitter.onPattern(splitBy).splitToList(line);
                Mockito.verify(graphicsMock, Mockito.atLeast(1)).putString(8, y, arr.get(0));
                Mockito.verify(graphicsMock, Mockito.atLeast(1)).putString(38, y, arr.get(1));
                y++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Mockito.verify(graphicsMock, Mockito.atLeast(1)).putString(8, 20, "> Exit");
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }
    @Test
    public void resetTest(){
        HighScoreMenuViewer.reset();
        assertEquals(null, HighScoreMenuViewer.getInstance());
    }
}
