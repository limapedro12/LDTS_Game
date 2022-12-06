package spaceinvaders.model;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.graphics.TextGraphics;
import spaceinvaders.view.AlienViewer;

public class AlienModel extends ElementModel {
    boolean alive = true;
    private final String alien = "imagens/kisspng-emoji-alien-iphone-monster-space-invaders-5ac4f1fae15e76.0256511115228564429231.png";
    protected char symbol;

    public AlienModel(PositionModel position, char symbol) {
        super(position);
        this.symbol = symbol;
        this.viewer = new AlienViewer(this);
    }
    public void damage() {
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
    public char getSymbol(){
        return symbol;
    }
    public void fire(float level) {
        AlienShotModel shot = new AlienShotModel(new PositionModel(getX(), getY() + 1), level);
        notifyObservers(shot);
    }
}
