package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.ArenaModel;
import spaceinvaders.model.GameModel;
import spaceinvaders.model.menu.MainMenuModel;
import spaceinvaders.model.menu.StartCommand;
import spaceinvaders.view.menu.MainMenuViewer;

import static org.junit.jupiter.api.Assertions.*;

public class MainMenuModelTest {
    GameModel gameModelMock;
    MainMenuModel model;
    @BeforeEach
    public void helper(){
        gameModelMock = Mockito.mock(GameModel.class);
        MainMenuModel.reset();
        model = MainMenuModel.getInstance(gameModelMock);
    }

    @Test
    public void addCommandTest(){
        model.clearCommands();
        model.addCommands();
        assertEquals(model.getCommands().size(), 4);
        assertEquals(model.getCommands().get(0).getTitle(),"Start Game");
        assertEquals(model.getCommands().get(1).getTitle(), "HighScores");
        assertEquals(model.getCommands().get(2).getTitle(),"Options");
        assertEquals(model.getCommands().get(3).getTitle(), "Exit");

    }

    @Test
    public void addContinueCommandTest(){
        model.clearCommands();
        model.addCommands();
        model.addContinueCommand();
        assertEquals(model.getCommands().size(), 5);
        assertEquals(model.getCommands().get(0).getTitle(), "Continue Game");
        assertEquals(model.getCommands().get(1).getTitle(), "Restart Game");
    }

    @Test
    public void removeContinueCommandTest(){
        model.clearCommands();
        model.addCommands();
        model.addContinueCommand();
        model.removeContinueCommand();
        assertEquals(model.getCommands().size(), 4);
        assertEquals(model.getCommands().get(0).getTitle(), "Start Game");
    }

    @Test
    public void getSelectedCommandTest(){
        model.clearCommands();
        model.addCommands();
        assertEquals(model.getSelectedCommand().getTitle(), "Start Game");
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "HighScores");
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Options");
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Exit");
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Start Game");
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Exit");
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Options");
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "HighScores");
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Start Game");
    }

    @Test
    public void getSelectedCommandIntTest(){
        model.clearCommands();
        model.addCommands();
        assertEquals(model.getSelectedCommandInt(), 0);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 1);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 2);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 3);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 0);
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 3);
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 2);
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 1);
        model.upSelectedCommand();
        assertEquals(model.getSelectedCommandInt(), 0);
    }

    @Test
    public void downSelectedCommandTest(){
        model.clearCommands();
        model.addCommands();
        assertEquals(model.getSelectedCommand().getTitle(), "Start Game");
        assertEquals(model.getSelectedCommandInt(), 0);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "HighScores");
        assertEquals(model.getSelectedCommandInt(), 1);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Options");
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Exit");
        assertEquals(model.getSelectedCommandInt(), 3);
        model.downSelectedCommand();
        assertEquals(model.getSelectedCommand().getTitle(), "Start Game");
        assertEquals(model.getSelectedCommandInt(), 0);
    }

    @Test
    public void getGameModelTest(){
        assertEquals(model.getGameModel(), gameModelMock);
    }

    @Test
    public void checkContinueTest(){
        StartCommand startCommandMock = Mockito.mock(StartCommand.class);
        ArenaModel arenaModelMock = Mockito.mock(ArenaModel.class);
        Mockito.when(arenaModelMock.isLost()).thenReturn(false);
        Mockito.when(startCommandMock.getArena()).thenReturn(arenaModelMock);
        model.setStartCommand(startCommandMock);
        model.setContinueEnabled(false);

        //model.checkContinue();

        Mockito.verify(startCommandMock, Mockito.times(1)).setTitle("Continue Game");
        assertEquals(model.getCommands().size(), 5);
        assertTrue(model.isContinueEnabled());
    }
    @Test
    public void checkContinueTest2(){
        StartCommand startCommandMock = Mockito.mock(StartCommand.class);
        ArenaModel arenaModelMock = Mockito.mock(ArenaModel.class);
        Mockito.when(arenaModelMock.isLost()).thenReturn(true);
        Mockito.when(startCommandMock.getArena()).thenReturn(arenaModelMock);
        model.setStartCommand(startCommandMock);
        model.setContinueEnabled(true);

        model.addContinueCommand();
        //model.checkContinue();

        Mockito.verify(startCommandMock, Mockito.times(1)).setTitle("Start Game");
        Mockito.verify(startCommandMock, Mockito.times(1)).restartArena();
        assertEquals(model.getCommands().size(), 4);
        assertFalse(model.isContinueEnabled());
    }
    @Test
    public void setContinueEnabledTest(){
        model.setContinueEnabled(true);
        assertTrue(model.isContinueEnabled());
        model.setContinueEnabled(false);
        assertFalse(model.isContinueEnabled());
    }

    @Test
    public void clearCommandsTest(){
        model.clearCommands();
        assertEquals(model.getCommands().size(), 0);
    }
}
