package spaceinvaders.controller;


import com.googlecode.lanterna.input.KeyStroke;

public class RunStrategyController {
    private Controller controller;

    public RunStrategyController(Controller controller){
        this.controller = controller;
    }

    public void processKey(KeyStroke key){
        controller.processKey(key);
    }
}
