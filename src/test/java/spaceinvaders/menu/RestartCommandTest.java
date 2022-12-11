package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.menu.RestartCommand;
import spaceinvaders.model.menu.StartCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RestartCommandTest {
    StartCommand startCommand;
    RestartCommand restartCommand;
    @BeforeEach
    public void helper() {
        startCommand = Mockito.mock(StartCommand.class);
        restartCommand = new RestartCommand(startCommand);
    }

    @Test
    public void getStartCommandTest() {
        assertEquals(restartCommand.getStartCommand(), startCommand);
    }

    @Test
    public void getTitle() {
        assertEquals(restartCommand.getTitle(), "Restart Game");
    }

    @Test
    public void executeTest() {
        restartCommand.execute();
        Mockito.verify(startCommand, Mockito.times(1)).restartArena();
        Mockito.verify(startCommand, Mockito.times(1)).execute();
    }
}
