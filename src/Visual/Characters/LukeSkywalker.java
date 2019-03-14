package Visual.Characters;

public class LukeSkywalker extends Character{
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

    public LukeSkywalker(String Name, Type t) {
        super(Name,Type.Good);
        this.Health = 3.0;
    }
    public LukeSkywalker() {
        super();
        currentType = Type.Good;
        this.Health = 3.0;
    }

    public void LossHealth(){
         Health -= 1.0;
    }

}
