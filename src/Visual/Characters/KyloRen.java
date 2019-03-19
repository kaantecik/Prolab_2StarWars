package Visual.Characters;

public class KyloRen extends Character {
    private int ShortestPath;
    public int getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(int ShortestPath) {
        this.ShortestPath = ShortestPath;
    }

    public KyloRen(String Name,Type t) {
        super(Name,Type.Evil);
    }
    public KyloRen(){
        super();
        currentType = Type.Evil;
    }

}
