package spaceinvaders.model;

public class LifeModel extends ElementModel{

    boolean alive = true;

    public LifeModel(PositionModel position){
    super(position);
    }


    public boolean isAlive(){
        return alive;
    }


}
