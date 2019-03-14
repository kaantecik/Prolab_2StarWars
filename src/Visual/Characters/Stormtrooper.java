package Visual.Characters;

public class Stormtrooper extends Character {
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

    public Stormtrooper(String Name, Type t) {
        super(Name,Type.Evil);
    }
    public Stormtrooper(){
        super();
        currentType = Type.Evil;
    }
}
