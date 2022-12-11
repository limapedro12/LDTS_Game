package spaceinvaders.menu;

import org.junit.jupiter.api.Test;
import spaceinvaders.model.menu.DummyCommand;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DummyCommandTest {
    @Test
    public void getTitleTest() {
        DummyCommand command = new DummyCommand("test");
        assertEquals(command.getTitle(), "test");
    }
    @Test
    public void getTitleTest2() {
        DummyCommand command = new DummyCommand("test");
        command.setTitle("test2");
        assertEquals(command.getTitle(), "test2");
    }
    @Test
    public void executeTest() {
        DummyCommand command = new DummyCommand("test");
        command.execute();
    }
}
