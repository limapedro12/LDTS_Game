package spaceinvaders.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.menu.InfoMenuController;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.Command;
import spaceinvaders.model.menu.InfoMenuModel;

import static org.testng.AssertJUnit.assertEquals;

public class InfoMenuControllerTest {
    GameModel gameModel;
    InfoMenuModel modelMock;
    InfoMenuController controller;
    @BeforeEach
    public void helper(){
        gameModel = Mockito.mock(GameModel.class);
        InfoMenuModel.reset();
        InfoMenuController.reset();
        modelMock = Mockito.mock(InfoMenuModel.class);
        controller = InfoMenuController.getInstance(modelMock);
    }

    @Test
    public void getInstanceTest1(){
        assertEquals(controller, InfoMenuController.getInstance(modelMock));
    }

    @Test
    public void getInstanceTest2(){
        assertEquals(controller, InfoMenuController.getInstance(modelMock));
    }

    @Test
    public void getInstanceTest3(){
        assertEquals(controller, InfoMenuController.getInstance());
    }

    @Test
    public void processKeyQ(){
        Command exitCommandMock = Mockito.mock(Command.class);
        Mockito.when(modelMock.getExitCommand()).thenReturn(exitCommandMock);
        controller.processKey(new KeyStroke('q', false, false));
        Mockito.verify(exitCommandMock, Mockito.times(1)).execute();
    }
    @Test
    public void processKeyTestEsc(){
        Command exitCommandMock = Mockito.mock(Command.class);
        Mockito.when(modelMock.getExitCommand()).thenReturn(exitCommandMock);
        controller.processKey(new KeyStroke(KeyType.Escape));
        Mockito.verify(exitCommandMock, Mockito.times(1)).execute();
    }
    @Test
    public void processKeyTestEnter(){
        Command exitCommandMock = Mockito.mock(Command.class);
        Mockito.when(modelMock.getExitCommand()).thenReturn(exitCommandMock);
        controller.processKey(new KeyStroke(KeyType.Enter));
        Mockito.verify(exitCommandMock, Mockito.times(1)).execute();
    }
    @Test
    public void resetTest(){
        InfoMenuController.reset();
        assertEquals(null, InfoMenuController.getInstance());
    }
}
