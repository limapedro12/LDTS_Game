package spaceinvaders.menu;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.MainMenuModel;
import spaceinvaders.view.menu.MainMenuViewer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuViewerTest {
    GameModel gameModel;
    MainMenuModel model;
    MainMenuViewer viewer;
    @BeforeEach
    public void helper(){
        gameModel = Mockito.mock(GameModel.class);
        MainMenuModel.reset();
        MainMenuViewer.reset();
        model = MainMenuModel.getInstance(gameModel);
        viewer = MainMenuViewer.getInstance(model);
    }

    @Test
    public void getInstanceTest1(){
        assertEquals(viewer, MainMenuViewer.getInstance(model));
    }

    @Test
    public void getInstanceTest2(){
        MainMenuModel modelMock = Mockito.mock(MainMenuModel.class);
        assertEquals(viewer, MainMenuViewer.getInstance(modelMock));
    }

    @Test
    public void draw(){
        TextGraphics graphicsMock = Mockito.mock(TextGraphics.class);
        viewer.draw(graphicsMock);
        Mockito.verify(graphicsMock, Mockito.times(2)).setForegroundColor(TextColor.Factory.fromString("#FFC300"));
        Mockito.verify(graphicsMock, Mockito.atLeast(4)).putString(Mockito.anyInt(), Mockito.anyInt(), Mockito.anyString());
        Mockito.verify(graphicsMock, Mockito.times(4)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
    }
    @Test
    public void resetTest(){
        MainMenuViewer.reset();
        assertEquals(null, MainMenuViewer.getInstance());
    }
}
