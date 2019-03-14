package Visual.Characters;

public class MasterYoda extends Character{
    private int ShortestPath;
    private static double Health;

    public double getHealth() {
        return Health;
    }

    public void setHealth(double Health) {
        this.Health = Health;
    }


    public int getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(int ShortestPath) {
        this.ShortestPath = ShortestPath;
    }

    public MasterYoda(String Name, Type t) {
        super(Name, Type.Good);
        this.Health = 3.0;
    }
    public MasterYoda() {
        super();
        currentType = Type.Good;
        this.Health = 3.0;
    }

   public void LossHealth(){
        Health -= 0.5;
    }

}