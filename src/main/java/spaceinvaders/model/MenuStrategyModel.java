package spaceinvaders.model;

public class MenuStrategyModel implements RunStrategyModel{
    private MenuModel model;
    public MenuStrategyModel(MenuModel model){
        this.model = model;
    }
    public void run(){}
}
