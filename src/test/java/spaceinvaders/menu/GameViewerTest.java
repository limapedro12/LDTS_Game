package spaceinvaders.menu;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.RunStateModel;
import spaceinvaders.view.GameViewer;

import java.io.IOException;

public class GameViewerTest {
    GameModel gameModel;
    GameViewer gameViewer;
    Screen screen;

    @BeforeEach
    public void helper() {
        gameModel = Mockito.mock(GameModel.class);
        screen = Mockito.mock(Screen.class);
        gameViewer = new GameViewer(gameModel, screen);
    }

    @Test
    public void drawTest() throws IOException {
        TextGraphics textGraphics = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
        gameViewer.draw();
        RunStateModel state = Mockito.mock(RunStateModel.class);
        Mockito.when(gameModel.getState()).thenReturn(state);
        Mockito.verify(gameModel.getState().getViewer()).draw(textGraphics);
    }
}
