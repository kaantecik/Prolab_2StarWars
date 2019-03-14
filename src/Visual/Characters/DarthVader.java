package Visual.Characters;

public class DarthVader extends Character{
    private int ShortestPath;
    private static String SpawnPoint;


    public String getSpawnPoint() {
        return SpawnPoint;
    }

    public void setSpawnPoint(String spawnPoint) {
        SpawnPoint = spawnPoint;
    }

    public int getShortestPath() {
        return ShortestPath;
    }

    public void setShortestPath(int ShortestPath) {
        this.ShortestPath = ShortestPath;
    }

    public DarthVader(String Name, Type t) {
        super(Name,Type.Evil);
    }

    public DarthVader(){
        super();
        currentType = Type.Evil;
    }
}