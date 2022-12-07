package spaceinvaders.model;

import spaceinvaders.view.LifeViewer;

public class LifeModel extends ElementModel{

    boolean alive = true;

    public LifeModel(PositionModel position){

        super(position);
        this.viewer = new LifeViewer(this);
    }

    @Override
    public void damage() {}

    public boolean isTangible(){
        return false;
    }

    public boolean isAlive(){
        return alive;
    }
}
