package spaceinvaders.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import spaceinvaders.model.menu.StartInLevelCommand;
import spaceinvaders.model.menu.StartCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StartInLevelCommandTest {
    StartCommand startCommand;
    StartInLevelCommand StartInLevelCommand;
    @BeforeEach
    public void helper() {
        startCommand = Mockito.mock(StartCommand.class);
        StartInLevelCommand = new StartInLevelCommand(startCommand, 2);
    }

    @Test
    public void getStartCommandTest() {
        assertEquals(StartInLevelCommand.getStartCommand(), startCommand);
    }

    @Test
    public void getTitle() {
        assertEquals(StartInLevelCommand.getTitle(), "Start Game In Level");
    }

    @Test
    public void executeTest() {
        StartInLevelCommand.execute();
        Mockito.verify(startCommand, Mockito.times(1)).execute();
    }
}
