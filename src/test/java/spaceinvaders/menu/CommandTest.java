package spaceinvaders.menu;

import org.junit.jupiter.api.Test;
import spaceinvaders.model.menu.Command;
import spaceinvaders.model.menu.DummyCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandTest {
    @Test
    public void getTitleTest() {
        Command command = new DummyCommand("test");
        command.setTitle("test2");
        assertEquals(command.getTitle(), "test2");
    }
}
