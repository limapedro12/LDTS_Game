package spaceinvaders.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.HighScoreMenuModel;
import spaceinvaders.view.menu.HighScoreMenuViewer;

import java.io.BufferedReader;
import java.io.IOException;

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
        Mockito.verify(graphicsMock, Mockito.atLeast(1)).putString(8, 20, "> Exit");
        Mockito.verify(graphicsMock, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }
    @Test
    public void resetTest(){
        HighScoreMenuViewer.reset();
        assertEquals(null, HighScoreMenuViewer.getInstance());
    }
}
