package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.controller.menu.StartInLevelMenuController;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.*;
import spaceinvaders.view.menu.StartInLevelMenuViewer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StartInLevelMenuModelTest {
    GameModel gameModelMock;
    StartInLevelMenuModel model;
    StartCommand startCommand;
    @BeforeEach
    public void helper(){
        gameModelMock = Mockito.mock(GameModel.class);
        StartInLevelMenuModel.reset();
        startCommand = Mockito.mock(StartCommand.class);
        model = StartInLevelMenuModel.getInstance(gameModelMock, startCommand);
    }
    @Test
    public void getExitCommandTest(){
        Command exitCommand = Mockito.mock(Command.class);
        model.setExitCommand(exitCommand);
        assertEquals(exitCommand, model.getExitCommand());
    }
    @Test
    public void getStartCommandTest(){
        assertEquals(startCommand, model.getStartCommand());
    }
    @Test
    public void getGameModelTest(){
        assertEquals(gameModelMock, model.getGameModel());
    }
    @Test
    public void getLevelTest(){
        model.setLevel("1");
        assertEquals("1", model.getLevel());
    }
    @Test
    public void resetTest(){
        StartInLevelMenuModel.reset();
        assertEquals(null, StartInLevelMenuModel.getInstance());
    }
    @Test
    public void resetLevelTest(){
        model.resetLevel();
        assertEquals("", model.getLevel());
    }
}
