package Visual.Characters;

import javafx.scene.shape.Rectangle;

public class Character extends Rectangle {

    private String Name;
    private int[] PastLocX;
    private int[] PastLocY;
    private static int posX;
    private static int posY;

    public enum Type{
        Good,
        Evil
    }

    public Type currentType;

    public int getPosY() {
        return posY;
    }
    public int getPosX() {
        return posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getName() {
        return Name;
    }

    public Type getType() {
        return currentType;
    }
    public void setType(Type t) {
        this.currentType = t;
    }

    public void setPastLocX(int[] PastLocX) {
        this.PastLocX = PastLocX;
    }
    public int[] getPastLocX() {
        return PastLocX;
    }

    public void setPastLocY(int[] PastLocY) {
        this.PastLocY = PastLocY;
    }
    public int[] getPastLocY() {
        return PastLocY;
    }

    public Character(String Name, Type t) {
        this.Name = Name;
        this.currentType = t;

    }
    public Character(){

    }

}
