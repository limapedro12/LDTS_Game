package spaceinvaders.menu;

import org.junit.jupiter.api.Test;
import spaceinvaders.model.menu.ExitCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExitCommandTest {
    @Test
    public void getTitleTest() {
        ExitCommand exitCommand = new ExitCommand();
        assertEquals(exitCommand.getTitle(), "Exit");
    }
}
