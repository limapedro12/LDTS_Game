package spaceinvaders;
import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.graphics.TextImage;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.ImageIcon;

import javax.swing.*;

public class Alien extends Element{
    boolean alive = true;
    private final String alien = "imagens/kisspng-emoji-alien-iphone-monster-space-invaders-5ac4f1fae15e76.0256511115228564429231.png";

    public Alien(Position position){
        super(position);
    }

    @Override
    public void draw(TextGraphics graphics){
         /*ImageIcon image = new (this.getClass().getResource(alien));
        setImage(image.getImage());*/
        graphics.setCharacter(new TerminalPosition(position.getX(), position.getY()), TextCharacter.fromCharacter('Y')[0]);
    }
    public void move(Position direction) {

        this.position.setX(position.getX()+direction.getX());
        this.position.setY(position.getY()+direction.getY());
    }

    public void damage() {
        alive = false;
    }
    public boolean isAlive() {
        return alive;
    }
}


